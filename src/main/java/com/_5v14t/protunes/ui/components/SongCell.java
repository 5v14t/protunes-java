package com._5v14t.protunes.ui.components;

import com._5v14t.protunes.be.Song;
import javafx.scene.control.ListCell;

/**
 * This class is created to replace the usual cell in JavaFX ListView.
 * We want to display not just a random cell, but specifically desined cell SongItem.
 * SongItem is the design for our cell, and this class is an actual implemenattion
 * of that cell.
 * This class has to be called by JavaFX itself by using this class in a cellFactory when creating a ListView,
 * to let ListView know, that every new cell, has to be of this type.
 */
public class SongCell extends ListCell<Song> {
    private final SongItem songItem = new SongItem();

    @Override
    protected void updateItem(Song song, boolean empty) {
        super.updateItem(song, empty);
        setText(null);

        if (empty || song == null) {
            setGraphic(null);
        } else  {
            songItem.setTitle(song.getTitle());
            songItem.setArtist(song.getArtist());
            setGraphic(songItem);
        }
    }
}
