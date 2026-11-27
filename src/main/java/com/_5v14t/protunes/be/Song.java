package com._5v14t.protunes.be;

import java.awt.image.BufferedImage;
import java.io.File;

public class Song {
    private String title;
    private String artist;
    private String genre;
    private File file;
    private int durationSeconds;
    private BufferedImage artwork;


    // Constructor
    public Song(String title, String artist, String genre, File file, int duration, int id) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.file = file;
        this.durationSeconds = duration;
    }

    // Getters
    public String getTitle() {return title;}
    public String getArtist() {return artist;}
    public String getGenre() {return genre;}
    public int getDuration() {return durationSeconds;}
    public File getFile() {return file;}
    public BufferedImage getArtwork() {return artwork;}


    // Setters
    public void setTitle(String title) {this.title = title;}
    public void setArtist(String artist) {this.artist = artist;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setDuration(int duration) {this.durationSeconds = duration;}
    public void setFile(Path path) {this.file = new File(path.toString());}
    public void setArtwork(BufferedImage artwork) {this.artwork = artwork;}

    // Other

    public String toString(){
        return title + " - " + artist;
    }

    public String getFormattedDuration() {
        int minutes = durationSeconds / 60;
        int seconds = durationSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}
