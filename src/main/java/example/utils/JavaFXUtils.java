package example.utils;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.util.regex.Pattern;

/**
 * A utility class for JavaFX-related operations.
 */
public class JavaFXUtils {
    /**
     * Displays an error alert dialog.
     *
     * @param title           The title of the alert dialog.
     * @param textAboutAlert  The content text of the alert dialog.
     */
    public static void showErrorAlert(String title, String textAboutAlert) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(title);
        if (errorAlert.getDialogPane().getScene().getWindow() != null) {
            Stage alertStage = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        }
        errorAlert.setHeaderText(title);
        errorAlert.setContentText(textAboutAlert);
        errorAlert.showAndWait();
    }

    /**
     * Validates an email address using a regular expression pattern.
     *
     * @param email The email address to validate.
     * @return True if the email is valid, otherwise false.
     */
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        return pattern.matcher(email).matches();
    }

}
