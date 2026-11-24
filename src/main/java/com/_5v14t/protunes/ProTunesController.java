package com._5v14t.protunes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProTunesController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
