package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "userCollection")
public class UserCollection {

    @XmlElement(name = "user", type = User.class)
    private List<User> users;

    public UserCollection(List<User> users) {
        this.users = users;
    }

    public UserCollection() {

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserCollection that = (UserCollection) object;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "UserCollection{" +
                "users=" + users +
                '}';
    }

    public boolean addUser(User userToAdd) {
        boolean result = false;
        if (!users.contains(userToAdd)) {
            users.add(userToAdd);
            result = true;
        }
        return result;
    }

    public boolean removeUser(User userToRemove) {
        boolean result = false;
        if (users.contains(userToRemove)) {
            users.remove(userToRemove);
            result = true;
        }
        return result;
    }
}
