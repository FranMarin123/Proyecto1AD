package example;

import example.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    public static AppController currentController;

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

    public static void setRoot(String fxml) throws IOException {
        //scene.setRoot(loadFXML(fxml));
    }

    public static void main(String[] args) {
        launch();
    }

}