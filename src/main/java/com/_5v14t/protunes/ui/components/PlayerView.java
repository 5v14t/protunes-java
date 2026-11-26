package com._5v14t.protunes.ui.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class PlayerView extends HBox {
    @FXML
    private Button btnBackward;

    @FXML
    private Button btnPlayPause;

    @FXML
    private boolean plyaing = false;

    @FXML
    private Button btnForward;

    @FXML
    private ImageView imgCover;

    @FXML
    private Label lblSongTitle;

    @FXML
    private Label lblSongArtist;

    @FXML
    private Slider sldProgressBar;

    @FXML
    private Button btnMore;

    public PlayerView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerView.fxml"));

        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
