package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static void saveResults(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename, true)) { // Append mode
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
