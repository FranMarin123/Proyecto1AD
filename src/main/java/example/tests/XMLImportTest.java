package example.tests;

import example.model.entity.User;
import example.model.entity.UserCollection;
import example.utils.XMLManager;

import java.util.ArrayList;
import java.util.List;

public class XMLImportTest {
    public static void main(String[] args) {
        UserCollection ejemplo=XMLManager.readXML(new UserCollection(),"usuarios.xml");
        System.out.println(ejemplo);
    }
}
