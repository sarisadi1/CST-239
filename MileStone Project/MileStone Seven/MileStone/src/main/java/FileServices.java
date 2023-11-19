import java.io.*;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class FileServices<T extends SalableProduct> {

        // saving the json file
        public void saveFile(String fileName, List<T> data) {
            try {
                FileWriter fileWriter = new FileWriter(fileName , false);
                ObjectMapper objectMapper = new ObjectMapper();

                // Configuring the ObjectWriter to use an indentation style
                ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();

                // Converting the data to JSON with indentation and write to the file
                String json = objectWriter.writeValueAsString(data);
                fileWriter.write(json);

                // Closing the FileWriter
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error saving data to JSON: " + e.getMessage());
            }
        }

        // reading json file
    public List<T> readFromFile(String fileName) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<T> data = new ArrayList<>();     // list for storing json data

            try {
                // storing the json file data in data
                data = objectMapper.readValue(new File(fileName), new TypeReference<>() {
                });
            } catch (IOException e) {
                System.out.println("Error reading data from JSON: " + e.getMessage());
            }
            // returning the json file data
            return data;
        }
    }