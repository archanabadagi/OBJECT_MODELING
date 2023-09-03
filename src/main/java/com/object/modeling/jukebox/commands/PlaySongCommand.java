package com.object.modeling.jukebox.commands;

import java.util.List;

import com.object.modeling.jukebox.entities.Playlist;
import com.object.modeling.jukebox.entities.Song;
import com.object.modeling.jukebox.services.IPlaylistService;
import com.object.modeling.jukebox.services.ISongService;

public class PlaySongCommand implements ICommand{

    private final IPlaylistService playlistService;
    private final ISongService songService;
    private int activeSongIndex;

    public PlaySongCommand(IPlaylistService playlistService, ISongService songService){
        this.playlistService=playlistService;
        this.songService=songService;
        this.activeSongIndex=-1;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            Playlist playlist = playlistService.findById(songService.getActivePlaylistId());
            int index=0;
            if(tokens.get(2).equals("NEXT")){
                if(activeSongIndex==playlist.getSongIds().size()-1)
                    activeSongIndex=0;
                else
                    activeSongIndex=activeSongIndex+1;

            }else if(tokens.get(2).equals("BACK")){
                if(activeSongIndex==0)
                    activeSongIndex=playlist.getSongIds().size()-1;
                else
                    activeSongIndex=activeSongIndex-1;

            }else{
                Boolean present=false;
                for(int i=0;i<playlist.getSongIds().size();i++){
                    if(tokens.get(2).equals(playlist.getSongIds().get(i))){
                        activeSongIndex=i;
                        present=true;
                    }
                }
                if(present==false){
                    System.out.println("Given song id is not a part of the active playlist");
                    return ;
                }
            }
            List<String> playlistSongs = playlist.getSongIds();
            //System.out.println("---------------- activeSongIndex: "+activeSongIndex+" : "+playlistSongs.get(activeSongIndex));
            Song song=songService.findSongById(playlistSongs.get(activeSongIndex));
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
        }catch(RuntimeException e){
            System.out.println("Song Not Found in the current active playlist.");
        }
    }
    
}
