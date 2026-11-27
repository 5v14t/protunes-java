package com._5v14t.protunes.ui;

import com._5v14t.protunes.bll.PlaylistManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreatePlaylistController {
    ProTunesController ptc;
    PlaylistManager pm = new PlaylistManager();
    @FXML
    private TextField lblPlaylistTitle;

    public void createNewPlaylist(){
        pm.createPlaylist(lblPlaylistTitle.getText());
        lblPlaylistTitle.getScene().getWindow().hide();
    }

    public void setMainController(ProTunesController proTunesController) {
    ptc = proTunesController;
    }
}
