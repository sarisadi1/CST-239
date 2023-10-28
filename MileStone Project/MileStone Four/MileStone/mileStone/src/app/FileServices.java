package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class FileServices {
    public static void saveToFile(String fileName, SalableProduct product) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(product);
            System.out.println("Data has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<SalableProduct> readFromFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<SalableProduct> products = new ArrayList<>();

        try {
            products = objectMapper.readValue(new File(fileName), new TypeReference<ArrayList<SalableProduct>>() {});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }




    public static ArrayList<SalableProduct> readAllFromFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<SalableProduct> products = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String json = scanner.nextLine();
                SalableProduct product = objectMapper.readValue(json, SalableProduct.class);
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (products.isEmpty()) {
            System.out.println("No products found in " + fileName);
        } else {
            System.out.println("Data has been read from " + fileName);
        }

        return products;
    }


    public static void saveAllToFile(String fileName, List<SalableProduct> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (SalableProduct product : products) {
                oos.writeObject(product);
            }
            System.out.println("Data has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}



