module example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens example to javafx.fxml;
    exports example;

    opens example.model.entity to java.xml.bind;
    exports example.model.entity;
    exports example.controller;
    opens example.controller to javafx.fxml;
}
