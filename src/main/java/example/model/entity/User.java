package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Represents a user with a name, email, and hashed password.
 * Implements methods for secure password handling, equality checks, and
 * basic user information retrieval and modification.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="user")
public class User implements Serializable {
    private String name;
    private String mail;
    private String password;

    /**
     * Default constructor initializing a User with empty fields.
     */
    public User() {
        this("","","");
    }

    /**
     * Constructs a User with specified name, email, and password.
     * Password is hashed using SHA-256 for security.
     *
     * @param name     The name of the user.
     * @param mail     The email of the user.
     * @param password The plaintext password of the user.
     */
    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        setPassword(password);
    }

    /**
     * Retrieves the user's name.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     *
     * @param name The name to set for the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the user's email.
     *
     * @return The email of the user.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the user's email.
     *
     * @param mail The email to set for the user.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Retrieves the user's hashed password.
     *
     * @return The hashed password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets and hashes the user's password using SHA-256.
     *
     * @param pass The plaintext password to hash and set.
     */
    public void setPassword(String pass) {
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashedBytes = digest.digest(pass.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            String hashedPassword = stringBuilder.toString();

            this.password = hashedPassword;
        } catch (NoSuchAlgorithmException e) {
        }
    }

    /**
     * Checks equality based on the email and hashed password.
     *
     * @param object The object to compare with.
     * @return {@code true} if the emails and passwords are identical.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(mail, user.mail) && Objects.equals(password, user.password);
    }

    /**
     * Generates a hash code based on the email and hashed password.
     *
     * @return The hash code of the user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(mail, password);
    }

    /**
     * Returns a string representation of the User, displaying basic details.
     *
     * @return The string representation of the user.
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
