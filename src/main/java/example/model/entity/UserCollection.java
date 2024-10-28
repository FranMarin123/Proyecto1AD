package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Represents a collection of User objects.
 * Provides methods to manage the user list, including adding and removing users.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "userCollection")
public class UserCollection implements Serializable {

    @XmlElement(name = "user", type = User.class)
    private List<User> users;

    /**
     * Constructs a UserCollection with the specified list of users.
     *
     * @param users List of users to initialize the collection with.
     */
    public UserCollection(List<User> users) {
        this.users = users;
    }

    /**
     * Default constructor, initializes an empty UserCollection.
     */
    public UserCollection() {

    }

    /**
     * Retrieves the list of users in this collection.
     *
     * @return List of users in the collection.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the list of users for this collection.
     *
     * @param users List of users to set in the collection.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Compares this UserCollection to another object for equality.
     * Collections are considered equal if they contain the same users.
     *
     * @param object The object to compare.
     * @return {@code true} if the collections contain the same users.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserCollection that = (UserCollection) object;
        return Objects.equals(users, that.users);
    }

    /**
     * Generates a hash code for this UserCollection based on its user list.
     *
     * @return The hash code of the collection.
     */
    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    /**
     * Returns a string representation of the UserCollection, displaying all users in the collection.
     *
     * @return String representation of the user collection.
     */
    @Override
    public String toString() {
        return "UserCollection{" +
                "users=" + users +
                '}';
    }

    /**
     * Adds a user to the collection if the user is not already present.
     *
     * @param userToAdd The user to add to the collection.
     * @return {@code true} if the user was added, {@code false} if already present.
     */
    public boolean addUser(User userToAdd) {
        boolean result = false;
        if (!users.contains(userToAdd)) {
            users.add(userToAdd);
            result = true;
        }
        return result;
    }

    /**
     * Removes a user from the collection if the user is present.
     *
     * @param userToRemove The user to remove from the collection.
     * @return {@code true} if the user was removed, {@code false} if not present.
     */
    public boolean removeUser(User userToRemove) {
        boolean result = false;
        if (users.contains(userToRemove)) {
            users.remove(userToRemove);
            result = true;
        }
        return result;
    }
}
