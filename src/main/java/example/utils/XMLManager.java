package example.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Utility class for managing XML serialization and deserialization using JAXB.
 * This class provides methods to convert Java objects to XML files and vice versa.
 */
public class XMLManager {

    /**
     * Serializes the provided object to an XML file.
     *
     * @param <T>      The type of the object to serialize.
     * @param c        The object to be serialized into XML format.
     * @param filename The name of the file to which the XML will be written.
     * @return {@code true} if the XML was successfully written; {@code false} otherwise.
     */
    public static <T> boolean writeXML(T c, String filename) {
        boolean result = false;

        JAXBContext context;
        try {
            context = JAXBContext.newInstance(c.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.marshal(c, new File(filename));
            result = true;
        } catch (JAXBException e) {
            e.printStackTrace(); 
        }
        return result;
    }

    /**
     * Deserializes an XML file into an object.
     *
     * @param <T>      The type of the object to deserialize.
     * @param c        An instance of the class type to be deserialized (provides the class type).
     * @param filename The name of the file from which to read the XML data.
     * @return The deserialized object, or the provided instance if deserialization fails.
     */
    public static <T> T readXML(T c, String filename) {
        T result = c;
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(c.getClass());
            Unmarshaller um = context.createUnmarshaller();
            result = (T) um.unmarshal(new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
