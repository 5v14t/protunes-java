package com._5v14t.protunes.be;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private String playlistName;
    private final ArrayList<Song> songs = new ArrayList<>();
    private int id;
// constructor
    public Playlist(String name, int id) {
        this.playlistName = name;
        this.id = id;
    }

// Unsure if these should be here or BLL
    public void add(Song song){
    this.songs.add(song);
    }

    public void remove(Song song){
    this.songs.remove(song);
    }


// Getters
    public String getName() {
        return playlistName;
    }

    public int getId() {
        return id;
    }
  
    public int getSongAmount() {
        return songs.size();
    }

    // Read-only view, so other classes must use add/remove
    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }
  

// Setters
    public void setName(String name){
      this.playlistName = name;
    }





}
