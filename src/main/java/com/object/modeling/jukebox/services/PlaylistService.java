package com.object.modeling.jukebox.services;

import java.util.List;
import java.util.Optional;
import com.object.modeling.jukebox.entities.Playlist;
import com.object.modeling.jukebox.repositories.IPlaylistRepository;

public class PlaylistService implements IPlaylistService{
    private final IPlaylistRepository playlistRepository;

    public PlaylistService(IPlaylistRepository playlistRepository){
        this.playlistRepository=playlistRepository;
    }

    public Playlist create(String userId, String playlistName, List<String> songIds){
        return playlistRepository.save(new Playlist(userId, playlistName, songIds));
    }

    public void delete(String userId, String playlistId){
        Optional<Playlist> playlist = playlistRepository.findByUserAndPlaylistId(userId, playlistId);
        if(playlist==null){
           System.out.println("Playlist Not Found");
        }
        playlistRepository.delete(playlist.get());
    }

    public Playlist findPlaylistByUserId(String userId, String playlistId){
        Optional<Playlist> playlist = playlistRepository.findByUserAndPlaylistId(userId, playlistId);
        if(playlist==null){
           System.out.println("Playlist is empty.");
        }
        return playlist.get();
    }

    public void addSongToPlaylist(String playlistId, String songId){
        playlistRepository.addSong(playlistId, songId);
    }

    public void deleteSongFromPlaylist(String playlistId, String songId){
        playlistRepository.deleteSong(playlistId, songId);
    }

    public Playlist findById(String playlistId){
        Optional<Playlist> playlist = playlistRepository.findById(playlistId);
        if(playlist==null){
            System.out.println("Playlist is empty.");
        }
        return playlist.get();
    }
    
}
