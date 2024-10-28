package example.controller;

import example.App;
import example.controller.Controller;
import example.model.entity.Conversation;
import example.model.entity.UserCollection;
import example.model.singleton.SelectedConversation;
import example.model.singleton.UserSigned;
import example.utils.JavaFXUtils;
import example.utils.Serializator;
import example.utils.XMLManager;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller for managing XML export functionality, allowing the user to export
 * a selected conversation to an XML file.
 */
public class ExportXMLController extends Controller implements Initializable {

    @FXML
    public ComboBox<String> selection;

    @FXML
    public TextField filenameExport;

    /**
     * Initializes the controller on opening, populating the user selection ComboBox
     * with users that have active conversations with the signed-in user.
     *
     * @param input The input data for initializing the controller, unused in this implementation.
     * @throws IOException If an error occurs while reading the user data.
     */
    @Override
    public void onOpen(Object input) throws IOException {
        UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
        for (int i = 0; i < allUsers.getUsers().size(); i++) {
            if (!allUsers.getUsers().get(i).getMail().equals(UserSigned.getInstance().getCurrentUser().getMail())) {
                selection.getItems().add(allUsers.getUsers().get(i).getMail());
            }
        }
    }

    /**
     * Called when the controller is closed, providing a point for cleanup if needed.
     *
     * @param output Output data for the controller, unused in this implementation.
     */
    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Exports the conversation between the signed-in user and the selected user
     * to an XML file. It validates if both the user and filename are provided.
     * Displays error alerts if validation fails or the conversation file does not exist.
     *
     * @throws IOException If an error occurs during file operations.
     */
    public void exportXML() throws IOException {
        if (selection != null && selection.getValue() != null) {
            if (filenameExport != null && filenameExport.getText() != null) {
                File conversationFileName1 = new File(UserSigned.getInstance().getCurrentUser().getMail() + selection.getValue());
                File conversationFileName2 = new File(selection.getValue() + UserSigned.getInstance().getCurrentUser().getMail());
                if (conversationFileName1.exists()) {
                    Conversation conversationToExport = Serializator.deserializeObject(conversationFileName1.toString());
                    XMLManager.writeXML(conversationToExport, filenameExport.getText());
                    App.currentController.changeScene(Scenes.HOME,null);
                } else if (conversationFileName2.exists()) {
                    Conversation conversationToExport = Serializator.deserializeObject(conversationFileName2.toString());
                    XMLManager.writeXML(conversationToExport, filenameExport.getText());
                    App.currentController.changeScene(Scenes.HOME,null);
                } else {
                    JavaFXUtils.showErrorAlert("ERROR: CONVERSACIÓN NO ENCONTRADA", "La conversación no ha sido encontrada");
                }
            } else {
                JavaFXUtils.showErrorAlert("ERROR: RUTA NO INDICADA", "La ruta en la que se va a guardar el archivo no ha sido indicada");
            }
        } else {
            JavaFXUtils.showErrorAlert("ERROR: USUARIO NO SELECCIONADO", "Por favor, selecciona un usuario para poder " +
                    "acceder a su conversación");
        }
    }

    /**
     * Returns to the home screen when the exit button is clicked.
     *
     * @throws IOException If an error occurs while changing the scene to the home screen.
     */
    public void exitButton() throws IOException {
        App.currentController.changeScene(Scenes.HOME,null);
    }
}
