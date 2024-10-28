package example;

import example.controller.AppController;
import example.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX Application class that serves as the entry point for the application.
 * It initializes the primary stage, loads the initial view, and sets the scene.
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    public static AppController currentController;

    /**
     * Starts the JavaFX application.
     *
     * @param stage The primary stage for this application, onto which the application scene can be set.
     * @throws IOException If the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        Object Scenes;
        View view = AppController.loadFXML(example.view.Scenes.ROOT);
        scene = new Scene(view.scene, 640, 480);
        currentController=(AppController) view.controller;
        currentController.onOpen(null);
        stage.setTitle("Whatsapp 2");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("img/logoWhatsApp2.PNG")));
        stage.setScene(scene);
        stage.setMinHeight(520);
        stage.setMinWidth(680);
        stage.setMaxHeight(520);
        stage.setMaxWidth(680);
        stage.show();
    }

    /**
     * Sets the root of the current scene to the specified FXML file.
     *
     * @param fxml The name of the FXML file to load.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public static void setRoot(String fxml) throws IOException {
        //scene.setRoot(loadFXML(fxml));
    }

    /**
     * The main entry point for all JavaFX applications.
     *
     * @param args Command line arguments for the application.
     */
    public static void main(String[] args) {
        launch();
    }

}