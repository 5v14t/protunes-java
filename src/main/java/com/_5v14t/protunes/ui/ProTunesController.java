package com._5v14t.protunes.ui;

import com._5v14t.protunes.ui.components.SectionView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProTunesController {
    @FXML
    private SectionView sectionPlaylists;
    @FXML
    private SectionView sectionSongs;

    @FXML
    private void initialize() {
        sectionPlaylists.setAddAction(event -> createPlaylist());
        sectionSongs.setAddAction(event -> addSong());
    }

    // TODO
    public void addSong() {
        // bring the file manager, asking for a file
        // open fxml window for editing the metadata
        // save to the list
    }

    // TODO
    public void createPlaylist() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreatePlaylist.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            CreatePlaylistController controller = loader.getController();
            controller.setMainController(this);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initOwner(sectionPlaylists.getScene().getWindow());
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // open fxml window for giving a playlist a name
        // save the playlist
    }
}
