package com._5v14t.protunes.bll;

import com._5v14t.protunes.be.Playlist;
import com._5v14t.protunes.dal.PlaylistDAO;

public class PlaylistManager {
    private final PlaylistDAO pd = new PlaylistDAO();

    public void createPlaylist(String name){
        pd.addNewPlaylist(name);
        pd.getPlaylistByName(name);
    }

    public void deletePlaylist(String name){

    }

}
