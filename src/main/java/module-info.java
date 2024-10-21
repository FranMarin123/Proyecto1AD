module example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens example to javafx.fxml;
    exports example;
}
