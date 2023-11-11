package app;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.List;


public class Server<T extends SalableProduct> {


    InventoryManager<T> inventory = new InventoryManager<>();
    // StoreFrontApplication app = new StoreFrontApplication();
    ObjectMapper objectMapper = new ObjectMapper();
    FileServices<T> file = new FileServices<>();

    public Server() {
    }

    public void addItemToInventory(SalableProduct product) {
        if (inventory.getInventory().isEmpty()) {
            List<T> products = file.readFromFile("inventory.json");

            if (products != null) {
                // Add the existing products to the inventory
                inventory.getInventory().addAll(products);

            } else {
                System.out.println("Failed to add the item to the inventory. Invalid JSON data.");
            }
            // Adding new product to inventory
            inventory.addProductToInventory(product.getName());
            inventory.saveInventoryToJSON("inventory.json", inventory.getInventory());
        }
    }

    public  void startServer(int port) throws IOException {
        System.out.println("Waiting for Client connection");

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true){

                // Accept a client connection
            	Socket clientSocket = serverSocket.accept();
            	System.out.println("Server started on port " + clientSocket.getLocalPort());
            	
            	//Create a new thread
                new Thread(() -> {
                    try (DataInputStream inputFromClient = new DataInputStream(clientSocket.getInputStream());
                         DataOutputStream outputToClient = new DataOutputStream(clientSocket.getOutputStream())) {

                        System.out.println("Waiting for Client connection");

                        // Read the command from the client
                        String command;
                        while (true) {
                            // reading the command from the client
                            command = inputFromClient.readUTF();

                            switch (command.toUpperCase()) {
                                case "U":
                                    // Received command to update the inventory
                                    System.out.println("Preparing to take product...");
                                    outputToClient.writeUTF("Ready to update inventory.");

                                    String product =  inputFromClient.readUTF();
                                    SalableProduct item = objectMapper.readValue(product, SalableProduct.class);
                                    addItemToInventory(item);
                                    outputToClient.writeUTF("Inventory updated.");


                                    break;
                                case "R":
                                    // Received command to retrieve the inventory
                                    try {
                                        List<T> inventoryData = file.readFromFile("inventory.json");
                                        String inventoryJson = objectMapper.writeValueAsString(inventoryData);
                                        outputToClient.writeUTF(inventoryJson);
                                        System.out.println("Sent inventory data to the client.");
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Null");
                                    }
                                    break;

                                default:
                                    System.out.println("Invalid command received: " + command);
                                    break;
                            }
//
                        }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }}).start();
        }

    }}

    public static void main(String[] args) throws IOException {
        Server<SalableProduct> server = new Server<>();
        server.startServer(6666);
    }
}

