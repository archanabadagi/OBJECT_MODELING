package com.object.modeling.jukebox.entities;

import java.util.List;

public class Playlist extends BaseEntity{
    private final String name;
    private final String userId;
    private final List<String> songIds;
    
    public Playlist(Playlist playlist){
        this(playlist.id, playlist.userId,  playlist.name, playlist.songIds);
    }

    public Playlist(String id, String userId, String name, List<String> songIds){
        this.id=id;
        this.name=name;
        this.userId=userId;
        this.songIds=songIds;
    }

    public Playlist(String userId, String name, List<String> songIds){
        this.name=name;
        this.userId=userId;
        this.songIds=songIds;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getSongIds() {
        return songIds;
    }
}
