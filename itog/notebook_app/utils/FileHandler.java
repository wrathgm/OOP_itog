package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileHandler {
    public static void saveListToFile(List<?> list, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(ObjectMapper.writeValueAsString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> loadListFromFile(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            String json = (String) ois.readObject();
            return ObjectMapper.readValue(json, new TypeReference<List<T>>() {
            });
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
