package com._5v14t.protunes.ui.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class SongItem extends HBox {

    @FXML
    private ImageView imgCover;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblArtist;

    public SongItem() {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("SongItem.fxml")
        );

        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTitle() {
        return lblTitle.getText();
    }

    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public String getArtist() {
        return lblArtist.getText();
    }

    public void setArtist(String artist) {
        lblArtist.setText(artist);
    }

    public Image getCover() {
        return imgCover.getImage();
    }

    public void setCover(Image cover) {
        imgCover.setImage(cover);
    }
}
