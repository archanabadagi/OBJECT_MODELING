package com.object.modeling.jukebox.repositories;

import java.util.Optional;

import com.object.modeling.jukebox.entities.Playlist;

public interface IPlaylistRepository extends CRUDRepository<Playlist,String>{
    public Optional<Playlist> findByUserAndPlaylistId(String userId, String playlistId);
    public void addSong(String playlistId, String songId);
    public void deleteSong(String playlistId, String songId);
}
