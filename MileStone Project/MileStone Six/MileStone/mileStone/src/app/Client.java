package app;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.Socket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import java.io.*;

public class Client {
	//Private fields
    private Socket clientSocket;
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Client(){

    }

    //Start method
    //New socket
    //New inputStream
    //New OutputStream
    public void start(String ip, int port) throws IOException {

        clientSocket = new Socket(ip, port);

        fromServer = new DataInputStream(clientSocket.getInputStream());

        toServer = new DataOutputStream(clientSocket.getOutputStream());

    }
    //Send product method
    public void sendProduct(SalableProduct products) throws IOException {
        String product = objectMapper.writeValueAsString(products);
        String serverCommand = fromServer.readUTF();

        //update to inventory
        if (serverCommand.equals("Ready to update inventory.")){
            toServer.writeUTF(product);
            System.out.println(fromServer.readUTF());
        }
        else
            System.out.println("Server is not available. ");
    }



    //Close connection Method
    public void closeConnection() throws IOException {
        clientSocket.close();
        fromServer.close();
        toServer.close();
    }
    //Main Method in client class
    public static void main(String[] args) throws IOException {
        System.out.println("Server has been started");
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        System.out.println("Server has been started");
        client.start("localhost", 6666);

        System.out.println("Server has been started");




        //Loop for commands
        while (true) {
            System.out.println("Enter command (U for add product, R for retrieve inventory, Q to quit , Restart for restarting");
            String command = scanner.nextLine(); // Send the command to the server
//            client.toServer.writeUTF(command);
//            client.toServer.flush();  // Ensure the command is sent

            if (command.equalsIgnoreCase("U")) {
                SalableProduct product = client.createProduct();
                if (product != null) {
                    System.out.println("Sending command to server. ");
                    client.toServer.writeUTF("U");
                    client.sendProduct(product);
                }
            }

            // Close the client and exit
            else if (command.equalsIgnoreCase("Q")) {
                 client.toServer.writeUTF("Q");
                 break;

            }

            //Restart server
            else if (command.equalsIgnoreCase("Restart")) {
                client.start("localhost" , 6666);

            }

            // Retrieving inventory
            else if (command.equalsIgnoreCase("R")) {

                System.out.println("Sending command to the server.");
               client.toServer.writeUTF("R");
               String jsonInventory =  client.fromServer.readUTF();

               if ( jsonInventory.isEmpty() ) {
                   System.out.println("Inventory is empty or there is any any error");
               }
               else{
                   List<SalableProduct> serverInventory = client.objectMapper.readValue(jsonInventory , new TypeReference<>(){});

                   System.out.println("-----------Inventory----------");
                   for (SalableProduct items : serverInventory) {
                       System.out.println("Name: " + items.getName());
                       System.out.println("Description: "+items.getDescription());
                       System.out.println("Price: "+items.getPrice());
                       System.out.println("Quantity: "+ items.getQuantity());
                   }
               }

            }
            else
                System.out.println("Invalid Command");
        }

        scanner.close();
        client.closeConnection();


    }
    //Create product Method
    private  SalableProduct createProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product details:");
        System.out.print("Product Type: ");
        String productType = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        // Check if the product type is valid
        if (isValidProductType(productType)) {
            // Create a new product with the provided details
        SalableProduct product =  new SalableProduct(productType, description, price, quantity);
            System.out.println("Product created successfully!");
            return product;
        } else {
            System.out.println("Invalid product type. Product not created.");
            return null;
        }
    }

    private static boolean isValidProductType(String productName) {
        // Define a list of valid product names
        List<String> validProductNames = Arrays.asList(
                "weapon",
                "armor",
                "health"
        );

        // Check if the entered product name is in the list of valid names
        return validProductNames.contains(productName.toLowerCase());
    }


}
