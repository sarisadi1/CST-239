import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.List;

public class Server<T extends SalableProduct> {
    ObjectMapper objectMapper = new ObjectMapper();
    FileServices<T> file = new FileServices<>();

    public Server() {
    }


    // Adding item to json file so that it will be available at front store
    public void addItemToInventory(T product) {
        InventoryManager<T> inventory = new InventoryManager<>();

        // reading already available data
        if (inventory.getInventory().isEmpty()) {
            inventory.initializeInventoryFromJSON("inventory.json");

            // Adding new product to inventory
            inventory.getInventory().add(product);
            // saving the complete file
            inventory.saveInventoryToJSON("inventory.json", inventory.getInventory());
        }
    }

    public  void startServer(int port) throws IOException {
        System.out.println("Waiting for Client connection...");

        // creating server socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true){

                // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Server started on port " + clientSocket.getLocalPort());

                new Thread(() -> {
                    try (DataInputStream inputFromClient = new DataInputStream(clientSocket.getInputStream());
                         DataOutputStream outputToClient = new DataOutputStream(clientSocket.getOutputStream())) {

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

                                    //taking product info from the admin user (the Client)
                                    String product =  inputFromClient.readUTF();
                                    T item = objectMapper.readValue(product, new TypeReference<>() {});

                                    // adding the new product to the json file
                                    addItemToInventory(item);
                                    outputToClient.writeUTF("Inventory updated.");
                                    break;

                                case "R":
                                    // Received command to retrieve the inventory
                                    try {
                                        List<T> inventoryData = file.readFromFile("inventory.json");
                                        // reading the data from json file
                                        String inventoryJson = objectMapper.writeValueAsString(inventoryData);

                                        // sending the available products to admin
                                        outputToClient.writeUTF(inventoryJson);
                                        System.out.println("Sent inventory data to the client.");
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Null");
                                    }
                                    break;
                                case "Q":
                                    System.out.println("Connection end");
                                    break;

                                default:
                                    System.out.println("Invalid command received: " + command);
                                    break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }}).start();

        }

    }
    }

    public static void main(String[] args) throws IOException {
        // instance of server class
        Server<SalableProduct> server = new Server<>();

        // starting server on the port 6666
        server.startServer(6666);

    }
}

