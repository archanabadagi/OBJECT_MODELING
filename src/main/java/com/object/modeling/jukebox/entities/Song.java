package com.object.modeling.jukebox.entities;

public class Song extends BaseEntity{
    private final String name;
    private final String genre;
    private final Album album;
    
    public Song(Song song){
        this(song.id, song.name, song.genre, song.album);
    }

    public Song(String id, String name, String genre, Album album){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.album=album;
    }

    public Song(String name, String genre, Album album){
        this.name=name;
        this.genre=genre;
        this.album=album;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Album getAlbum() {
        return album;
    }

    
}
