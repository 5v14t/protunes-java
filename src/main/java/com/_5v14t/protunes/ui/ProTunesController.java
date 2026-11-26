package com._5v14t.protunes.ui;

import com._5v14t.protunes.ui.components.SectionView;
import javafx.fxml.FXML;

public class ProTunesController {
    @FXML private SectionView sectionPlaylists;
    @FXML private SectionView sectionSongs;

    @FXML private void initialize() {
        sectionPlaylists.setAddAction(event -> createPlaylist());
        sectionPlaylists.setAddAction(event -> addSong());
    }

    // TODO
    public void addSong() {
        // bring the file manager, asking for a file
        // open fxml window for editing the metadata
        // save to the list
    }

    // TODO
    public void createPlaylist() {
        // open fxml window for giving a playlist a name
        // save the playlist
    }
}
