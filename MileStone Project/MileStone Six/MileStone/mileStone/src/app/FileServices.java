package app;

import java.io.*;
import java.util.ArrayList;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class FileServices<T> {

        public void saveFile(String fileName, List<T> data) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(new File(fileName), data);
                System.out.println("Data has been saved to " + fileName);
            } catch (IOException e) {
                System.out.println("Error saving data to JSON: " + e.getMessage());
            }
        }

        public List<T> readFromFile(String fileName) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<T> data = new ArrayList<>();

            try {
                data = objectMapper.readValue(new File(fileName), new TypeReference<>() {
                });
            } catch (IOException e) {
                System.out.println("Error reading data from JSON: " + e.getMessage());
            }

            return data;
        }



    }