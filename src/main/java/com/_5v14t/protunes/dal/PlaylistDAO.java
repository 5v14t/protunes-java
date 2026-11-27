package com._5v14t.protunes.dal;

import com._5v14t.protunes.be.Playlist;
import com._5v14t.protunes.be.Song;

import java.sql.*;
import java.util.ArrayList;

public class PlaylistDAO {
    private ConnectionManager cm = new ConnectionManager();


    public ArrayList<Song> SongsToPlaylist(Playlist playlist) {
        ArrayList<Song> songs = new ArrayList<>();

        String sql = "select * from PlaylistSongs where PlaylistID = ?";

        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, playlist.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("SongID");
                songs.add(new SongDAO().getSongById(id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }

    public int getNextId(){
        int nextId = 0;
        String sql = "SELECT MAX(SongID) FROM PlaylistSongs";
        try (Connection conn = cm.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs.getInt("MAX(SongID)") > 0){
                nextId = rs.getInt("MAX(SongID") + 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nextId;
    }


    public Playlist getPlaylistByName(String name) {
        String sql = "SELECT * FROM Playlists WHERE name = ?";
        Playlist pl = null;
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pl = new Playlist(rs.getString("name"), rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pl;
    }

    public void addNewPlaylist(String name) {
        String sql = "INSERT INTO Playlists (name) VALUES (?)";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Playlist> getAllPlaylist() {
        String sql = "SELECT * FROM Playlists";
        ArrayList<Playlist> playlists = new ArrayList<>();
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                playlists.add(new Playlist(name, id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playlists;
    }

    public void updatePlaylistDb(Playlist playlist) {
        String sql = "UPDATE Playlists SET Name = ? WHERE Id = ?";

        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, playlist.getName());
            ps.setInt(2, playlist.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deletePlaylist(Playlist playlist) {
        String deleteLinks = "DELETE FROM PlaylistSongs WHERE PlaylistID = ?";
        String deletePlaylist  = "DELETE FROM Playlists WHERE Id = ?";

        try (Connection conn = cm.getConnection()) {
            conn.setAutoCommit(false);              // both deletes succeed or neither does
            try (PreparedStatement ps1 = conn.prepareStatement(deleteLinks);
                 PreparedStatement ps2 = conn.prepareStatement(deletePlaylist)) {

                ps1.setInt(1, playlist.getId());
                ps1.executeUpdate();

                ps2.setInt(1, playlist.getId());
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
}

