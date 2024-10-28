package example.controller;

import example.App;

import java.io.IOException;

/**
 * Abstract class representing a generic controller with lifecycle methods
 * for opening and closing, and a reference to the main application instance.
 */
public abstract class Controller {
    App app;

    /**
     * Sets the main application instance for this controller.
     *
     * @param app The main application instance to associate with this controller.
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Abstract method called when the controller is opened. Subclasses should
     * implement specific actions to be performed upon opening.
     *
     * @param input The input data for initializing the controller.
     * @throws IOException If an input or output exception occurs during opening.
     */
    public abstract void onOpen(Object input) throws IOException;

    /**
     * Called when the controller is closed, providing a point for cleanup if needed.
     *
     * @param output Output data for the controller, unused in this implementation.
     */
    public abstract void onClose(Object output);
}
