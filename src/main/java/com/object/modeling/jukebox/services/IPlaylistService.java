package com.object.modeling.jukebox.services;

import java.util.List;
import com.object.modeling.jukebox.entities.Playlist;

public interface IPlaylistService {
    public Playlist create(String userId, String playlistName, List<String> songIds);
    public void delete(String userId, String playlistId);
    public Playlist findPlaylistByUserId(String userId, String playlistId);
    public Playlist findById(String playlistId);
    public void addSongToPlaylist(String playlistId, String songId);
    public void deleteSongFromPlaylist(String playlistId, String songId);
}
