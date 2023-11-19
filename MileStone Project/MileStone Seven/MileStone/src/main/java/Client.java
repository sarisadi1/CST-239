
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.Socket;


import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Client {
    private Socket clientSocket;
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Client(){

    }

    // starting the admin user (the client)
    public void start(String ip, int port) throws IOException {
        // client socket will take the same port as server
        clientSocket = new Socket(ip, port);

        // for accepting data from the server
        fromServer = new DataInputStream(clientSocket.getInputStream());

        // for sending data to the server
        toServer = new DataOutputStream(clientSocket.getOutputStream());
    }


    // Sending the Salable product to the server for adding it to the inventory.json
    public void sendProduct(SalableProduct products) throws IOException {

        // for sending string values to the server
        String product = objectMapper.writeValueAsString(products);
        // reading the command from the server
        String serverCommand = fromServer.readUTF();

        // checking if the server is ready to update inventory with new product
        if (serverCommand.equals("Ready to update inventory.")){
            toServer.writeUTF(product);  //sending product info to the server
            System.out.println(fromServer.readUTF());  // receiving server message
        }
        else
            System.out.println("Server is not available. ");
    }

    // closing the connection
    public void closeConnection() throws IOException {
        clientSocket.close();       // closing client socket
        fromServer.close();         // closing input
        toServer.close();           // closing output to the server
    }


    // ------------MAIN METHOD---------
    public static void main(String[] args) throws IOException {
        System.out.println("Server has been started");
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        // starting client with port 6666
        client.start("localhost", 6666);

        while (true) {
            System.out.println("Enter command (U for add product, R for retrieve inventory, Q to quit , Restart for restarting");
            String command = scanner.nextLine(); // Send the command to the server

            // for updating inventory according to the admin user
            if (command.equalsIgnoreCase("U")) {
                SalableProduct product = client.createProduct();  // creating product method will take info from the admin

                // if the createProduct has created the product (admin entered the correct product type)
                if (product != null) {
                    System.out.println("Sending command to server. ");
                    client.toServer.writeUTF("U");
                    client.sendProduct(product);      // sending product info to the server
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
                client.toServer.writeUTF("R");   // sending R to the server

                // reading inventory data from the server
                String jsonInventory =  client.fromServer.readUTF();

                // checking if the inventory is empty
               if ( jsonInventory.isEmpty() ) {
                   System.out.println("Inventory is empty or there is any any error");
               }
               else{

                   // displaying the available products to the admin user
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

    private  SalableProduct createProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product details:");
        System.out.print("Product Type: ");
        String productType = scanner.nextLine();

        System.out.println("Enter the product name:");
        String productName = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        // Check if the product type is valid
        if ((productType).toLowerCase().contains("weapon") || productType.toLowerCase().contains("health") || productType.toLowerCase().contains("armor")) {
            // Create a new product with the provided details
        SalableProduct product =  new SalableProduct(productName, description, price, quantity);
            System.out.println("Product created successfully!");
            return product;
        } else {
            System.out.println("Invalid product type. Product not created.");
            return null;
        }
    }
}
