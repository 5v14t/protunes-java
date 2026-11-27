package com._5v14t.protunes.be;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;

public class Song {
    private String title;
    private String artist;
    private String genre;
    private File file;
    private double durationSeconds;
    private BufferedImage artwork;
    private final int id;


    // Constructor
    public Song(int id, String title, String artist, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }


    // Getters
    public String getTitle() {return title;}
    public String getArtist() {return artist;}
    public String getGenre() {return genre;}
    public double getDuration() {return durationSeconds;}
    public File getFile() {return file;}
    public BufferedImage getArtwork() {return artwork;}

    public int getId() {return id;}


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
        double minutes = durationSeconds / 60;
        double seconds = durationSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}
