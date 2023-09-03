package com.object.modeling.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.object.modeling.jukebox.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository{

    private final Map<String,Playlist> playlistMap;
    private Integer autoIncrement = 0;

    public PlaylistRepository(){
        this.playlistMap = new HashMap<String,Playlist>();
    }

    public PlaylistRepository(Map<String, Playlist> userMap) {
        this.playlistMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public Playlist save(Playlist entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Playlist u = new Playlist(Integer.toString(autoIncrement), entity.getUserId(), entity.getName(), entity.getSongIds());
            playlistMap.put(u.getId(),u);
            return u;
        }
        playlistMap.put(entity.getId(),entity);
        return entity;
    }



    @Override
    public List<Playlist> findAll() {
     return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Playlist> findById(String id) {
        return Optional.ofNullable(playlistMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Playlist entity) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find the User Present in the Repository provided name
    // Tip:- Use Java Streams

    @Override
    public Optional<Playlist> findByUserAndPlaylistId(String userId, String playlistId) {
        return playlistMap.values().stream()
                .filter(playlist -> (playlist.getId().equals(playlistId) && playlist.getUserId().equals(userId)))
                .findFirst();
    }

    @Override
    public void addSong(String playlistId, String songId) {
        Playlist userPlaylist =  playlistMap.values().stream().filter(playlist -> (playlist.getId().equals(playlistId))).findFirst().get();
        userPlaylist.getSongIds().add(songId);
    }

    @Override
    public void deleteSong(String playlistId, String songId) {
        Playlist userPlaylist =  playlistMap.values().stream().filter(playlist -> (playlist.getId().equals(playlistId))).findFirst().get();
        userPlaylist.getSongIds().remove(songId);
    }
    
}
