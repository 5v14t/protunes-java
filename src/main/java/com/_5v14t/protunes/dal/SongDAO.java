package com._5v14t.protunes.dal;

import com._5v14t.protunes.be.Song;

import java.sql.*;
import java.util.ArrayList;

public class SongDAO {
    private final ConnectionManager cm = new ConnectionManager();

    public Song addSong(Song song) {
        String sql = "INSERT INTO Songs (Title, Artist, Genre) VALUES (?, ?, ?)";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, song.getTitle());
            ps.setString(2, song.getArtist());
            ps.setString(3, song.getGenre());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return new Song(keys.getInt(1), song.getTitle(), song.getArtist(), song.getGenre());
                }
            }
            throw new SQLException("Creating song failed, no id returned.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Song getSongById(int id) {
        String sql = "SELECT * FROM Songs WHERE id = ?";
        Song song = null;
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    song = new Song(rs.getInt("id"), rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return song;
    }


    public ArrayList<Song> getAllSongs() {
        String sql = "SELECT * FROM Songs";
        ArrayList<Song> songs = new ArrayList<>();
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String artist = rs.getString("Artist");
                String title = rs.getString("Title");
                String genre = rs.getString("Genre");
                songs.add(new Song(id, title, artist, genre));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }


    public void deleteSong(Song song) {
        String deleteLinks = "DELETE FROM PlaylistSongs WHERE SongID = ?";
        String deleteSong  = "DELETE FROM Songs WHERE Id = ?";

        try (Connection conn = cm.getConnection()) {
            conn.setAutoCommit(false);              // both deletes succeed or neither does
            try (PreparedStatement ps1 = conn.prepareStatement(deleteLinks);
                 PreparedStatement ps2 = conn.prepareStatement(deleteSong)) {
                ps1.setInt(1, song.getId());
                ps1.executeUpdate();
                ps2.setInt(1, song.getId());
                ps2.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();                    // undo the first delete if the second fails
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDatabaseSong(Song song) {
        String sql = "UPDATE Songs SET Title = ?, Artist = ?, Genre= ? WHERE Id = ?";

        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, song.getTitle());
            ps.setString(2, song.getArtist());
            ps.setString(3, song.getGenre());
            ps.setInt(4, song.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Song> SearchDatabase(String search) {
        String sql = "SELECT * FROM Songs WHERE Title LIKE ? OR Artist LIKE ?";
        ArrayList<Song> songs = new ArrayList<>();
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            String pattern = "%" + search + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String artist = rs.getString("Artist");
                    String title = rs.getString("Title");
                    String genre = rs.getString("Genre");
                    songs.add(new Song(id, title, artist, genre));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }


}
