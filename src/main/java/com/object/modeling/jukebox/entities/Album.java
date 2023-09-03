package com.object.modeling.jukebox.entities;

import java.util.List;

public class Album{
    private final String name;
    private final String albumArtist;
    private final List<String> featuredArtists;

    public Album(Album album){
        this(album.name, album.albumArtist, album.featuredArtists);
    }

    public Album(String name, String albumArtist, List<String> featuredArtists){
        this.name=name;
        this.albumArtist=albumArtist;
        this.featuredArtists = featuredArtists;
    }

    public String getName() {
        return name;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public List<String> getFeaturedArtists(){
        return featuredArtists;
    }

}
