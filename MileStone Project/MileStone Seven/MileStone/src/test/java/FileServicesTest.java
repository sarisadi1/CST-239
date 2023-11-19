import junit.framework.TestCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;



public class FileServicesTest extends TestCase {


    @Test
    public void testSaveFile() throws IOException {
        // Arrange
        FileServices<SalableProduct> fileServices = new FileServices<>();
        String fileName = "testFile.json";
        List<SalableProduct> testData = new ArrayList<>();
        testData.add(new SalableProduct("Test Product", "Description", 15.0, 10));

        // Act
        fileServices.saveFile(fileName, testData);

        // Assert
        String fileContent = Files.readString(Path.of(fileName));
        String expectedJson = "[ {\n  \"name\" : \"Test Product\",\n  \"description\" : \"Description\",\n  \"price\" : 15.0,\n  \"quantity\" : 10\n} ]";
        // Normalize line endings and ignore whitespace
        assertEquals(expectedJson.replaceAll("\r\n", "\n").replaceAll("\\s", ""), fileContent.replaceAll("\r\n", "\n").replaceAll("\\s", ""));

        // Clean up
        Files.deleteIfExists(Path.of(fileName));
    }

    @Test
    public void testReadFromFile() {
        // Arrange
        FileServices<SalableProduct> fileServices = new FileServices<>();
        String fileName = "testFile.json";
        List<SalableProduct> testData = new ArrayList<>();
        testData.add(new SalableProduct("Test Product", "Description", 15.0, 10));

        // Write test data to a file
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
            String json = objectWriter.writeValueAsString(testData);
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Act
        List<SalableProduct> result = fileServices.readFromFile(fileName);

        // Assert
        assertEquals(testData.size(), result.size());
        assertEquals(testData.get(0).getName(), result.get(0).getName());
        assertEquals(testData.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(testData.get(0).getPrice(), result.get(0).getPrice(), 0.001);
        assertEquals(testData.get(0).getQuantity(), result.get(0).getQuantity());

        // Clean up
        new File(fileName).delete();
    }

}