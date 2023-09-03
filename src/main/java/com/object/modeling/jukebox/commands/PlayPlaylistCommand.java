package com.object.modeling.jukebox.commands;

import java.util.List;
import com.object.modeling.jukebox.entities.Playlist;
import com.object.modeling.jukebox.entities.Song;
import com.object.modeling.jukebox.services.IPlaylistService;
import com.object.modeling.jukebox.services.ISongService;

public class PlayPlaylistCommand implements ICommand{
    
    private final IPlaylistService playlistService;
    private final ISongService songService;

    public PlayPlaylistCommand(IPlaylistService playlistService, ISongService songService){
        this.playlistService=playlistService;
        this.songService=songService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            Playlist playlist = playlistService.findPlaylistByUserId(tokens.get(1), tokens.get(2));
            Song song = songService.findSongById(playlist.getSongIds().get(0));
            System.out.println("Current Song Playing");
            System.out.println("Song - "+song.getName());
            System.out.println("Album - "+song.getAlbum().getName());
            System.out.print("Artists - ");
            for(int i=0;i<song.getAlbum().getFeaturedArtists().size();i++){
                if(i!=song.getAlbum().getFeaturedArtists().size()-1)
                    System.out.print(song.getAlbum().getFeaturedArtists().get(i)+",");
                else
                    System.out.print(song.getAlbum().getFeaturedArtists().get(i));
            }
            System.out.print("\n");
            songService.setActivePlaylistId(playlist.getId());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
