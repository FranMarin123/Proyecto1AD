package example.tests;

import example.model.entity.User;
import example.model.entity.UserCollection;
import example.utils.XMLManager;

import java.util.ArrayList;
import java.util.List;

public class XMLImportTest {
    public static void main(String[] args) {
        UserCollection ejemplo=XMLManager.readXML(new UserCollection(),"usuarios.xml");
        User usuario=new User("","juan@gmail.com","1234");
        System.out.println(browseUserInArray(ejemplo,usuario));
    }

    public static User browseUserInArray(UserCollection allUsers,User userToBrowse){
        User userReturn=null;
        for (int i=0;i<allUsers.getUsers().size();i++){
            if (allUsers.getUsers().get(i).equals(userToBrowse)){
                userReturn=allUsers.getUsers().get(i);
            }
        }
        return userReturn;
    }
}
