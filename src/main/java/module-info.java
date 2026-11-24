module com._5v14t.protunes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com._5v14t.protunes to javafx.fxml;
    exports com._5v14t.protunes;
}