package com.object.modeling.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.object.modeling.jukebox.entities.Song;

public class SongRepository implements ISongRepository{

    private final Map<String,Song> songMap;
    private Integer autoIncrement = 0;

    public SongRepository(){
        this.songMap = new HashMap<String,Song>();
    }

    public SongRepository(Map<String, Song> userMap) {
        this.songMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public Song save(Song entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Song u = new Song(Integer.toString(autoIncrement),entity.getName(),entity.getGenre(), entity.getAlbum());
            songMap.put(u.getId(),u);
            return u;
        }
        songMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<Song> findAll() {
     return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Song> findById(String id) {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Song entity) {
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

    // @Override
    // public Optional<User> findByName(String name) {
    //     return userMap.values().stream()
    //             .filter(user -> user.getName().equals(name))
    //             .findFirst();
    //}
    
}
