package example.model.singleton;

import example.model.entity.User;

/**
 * Singleton class that manages the session of a signed-in user.
 * Only one instance of UserSigned exists, representing the currently signed-in user.
 */
public class UserSigned {
    private static UserSigned _instance;
    private User currentUser;

    /**
     * Private constructor to prevent direct instantiation and ensure singleton pattern.
     *
     * @param user The user to initialize as the currently signed-in user.
     */
    private UserSigned(User user){
        currentUser=user;
    }

    /**
     * Retrieves the existing instance of UserSigned.
     *
     * @return The current instance of UserSigned, or {@code null} if no user is signed in.
     */
    public static UserSigned getInstance(){
        return _instance;
    }

    /**
     * Creates or replaces the singleton instance with a specified user, effectively signing in the user.
     *
     * @param userToUse The user to set as the current signed-in user.
     */
    public static void getInstance(User userToUse){
        _instance=new UserSigned(userToUse);
    }

    /**
     * Ends the session by nullifying the singleton instance, effectively signing out the user.
     */
    public static void closeSession(){
        _instance=null;
    }

    /**
     * Retrieves the currently signed-in user.
     *
     * @return The user currently signed in, or {@code null} if no user is signed in.
     */
    public User getCurrentUser() {
        return currentUser;
    }
}
