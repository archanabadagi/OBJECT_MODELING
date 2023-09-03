package com.object.modeling.jukebox.services;

import java.util.Optional;

import com.object.modeling.jukebox.entities.Song;
import com.object.modeling.jukebox.entities.Album;
import com.object.modeling.jukebox.repositories.ISongRepository;

public class SongService implements ISongService{
    private final ISongRepository songRepository;
    private String activePlaylistId;

    public SongService(ISongRepository songRepository){
        this.songRepository=songRepository;
        this.activePlaylistId=null;
    }

    public void create(String name, String genre, Album album){
        Song song = new Song(name, genre, album);
        songRepository.save(song);
    }

    public Song findSongById(String id){
        Optional<Song> song =  songRepository.findById(id);
        if(song==null){
            System.out.println("Playlist is empty.");
            return null;
        }
        return song.get();
    }

    public String getActivePlaylistId(){
        return activePlaylistId;
    }

    public void setActivePlaylistId(String activePlaylistId){
        this.activePlaylistId=activePlaylistId;
    }
    
}
