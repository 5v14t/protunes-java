package com._5v14t.protunes.ui.components;

import com._5v14t.protunes.be.Song;
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

    // TODO: Private PlayerManager dependency

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

    // TODO
    public void backwardBtnClicked() {
        // Access the Player Manager
        // Check if the song is less than 6 sec in
            // play precious song
        // else
            // start the song from the beginning
    }

    // TODO
    public void playBtnClicked() {
        // Access the player manager
        // if the song is playing
            // change btn text to 'play' (what is the next action)
            // pause
        // else
            // change btn text to 'pause' (what is the next action)
            // play
    }

    // TODO
    public void forwardBtnClicked() {
        // Access the player Manager
        // play the next song
    }

    // TODO
    public void setPlayerManager(/* pass playerManager instance*/) {
        // this.manager = manager;
        // bind the title
        // bind the artist name
        // bind the artwork
        // bind the duration
        // bind the current position
    }

    // TODO
    public void showMore() {
        // show options to add the song to a playlist
    }
}
