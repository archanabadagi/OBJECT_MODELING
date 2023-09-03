package com.object.modeling.jukebox.services;

import com.object.modeling.jukebox.entities.Album;
import com.object.modeling.jukebox.entities.Song;

public interface ISongService {
    public void create(String name, String genre, Album album);
    public Song findSongById(String id);
    public String getActivePlaylistId();
    public void setActivePlaylistId(String activePlaylistId);
}
