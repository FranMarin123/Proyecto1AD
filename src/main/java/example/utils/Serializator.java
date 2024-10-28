package example.utils;

import java.io.*;

/**
 * Utility class for serializing and deserializing objects to and from files.
 * This class provides methods to save an object to a file (serialization) and
 * retrieve an object from a file (deserialization).
 */
public class Serializator {

    /**
     * Serializes the provided object and saves it to a file with the specified filename.
     *
     * @param <T>      The type of the object to serialize.
     * @param obj      The object to serialize.
     * @param filename The name of the file to save the serialized object.
     * @return {@code true} if the serialization was successful; {@code false} otherwise.
     */
    public static <T> boolean serializeObject(T obj, String filename) {
        boolean result = false;
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename)
        )) {
            oos.writeObject(obj);
            result = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Deserializes an object from a file with the specified filename.
     *
     * @param <T>      The type of the object to deserialize.
     * @param filename The name of the file from which to deserialize the object.
     * @return The deserialized object, or {@code null} if deserialization failed.
     */
    public static <T> T deserializeObject(String filename) {
        T result = null;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename)
        )) {
            result = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
