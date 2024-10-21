package example.model.singleton;

import example.model.entity.User;

public class UserSigned {
    private static UserSigned _instance;
    private User currentUser;

    private UserSigned(User user){
        currentUser=user;
    }

    public static UserSigned getInstance(){
        return _instance;
    }

    public static void getInstance(User userToUse){
        _instance=new UserSigned(userToUse);
    }

    public static void closeSession(){
        _instance=null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
