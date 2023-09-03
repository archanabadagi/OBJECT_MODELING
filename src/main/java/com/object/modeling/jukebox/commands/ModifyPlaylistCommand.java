package com.object.modeling.jukebox.commands;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import com.object.modeling.jukebox.entities.Playlist;
import com.object.modeling.jukebox.entities.Song;
import com.object.modeling.jukebox.services.IPlaylistService;
import com.object.modeling.jukebox.services.ISongService;

public class ModifyPlaylistCommand implements ICommand{

    IPlaylistService playlistService;
    ISongService songService;

    public ModifyPlaylistCommand(IPlaylistService playlistService, ISongService songService){
        this.playlistService=playlistService;
        this.songService=songService;
    }


    @Override
    public void execute(List<String> tokens) {
        try{
            String userId=tokens.get(2);
            String playlistId=tokens.get(3);
            List<String> songIds = new ArrayList<String>(Arrays.asList(tokens.get(4).split(" ")));
            Playlist playlist = playlistService.findPlaylistByUserId(userId, playlistId);
            if(tokens.get(1).equals("ADD-SONG")){
                for(String s: songIds){
                    Song song = songService.findSongById(s);
                    if(song==null){
                        System.out.println("Some Requested Songs Not Available. Please try again.");
                        return;
                    }else{
                        playlistService.addSongToPlaylist(playlist.getId(), s);
                    }

                }
            }else{
                for(String s: songIds){
                    Song song = songService.findSongById(s);
                    if(song==null){
                        System.out.println("Some Requested Songs Not Available. Please try again.");
                        return;
                    }else{
                        playlistService.deleteSongFromPlaylist(playlist.getId(), s);
                    }

                }
            }
            Playlist updatedPlaylist = playlistService.findPlaylistByUserId(userId, playlistId);
            System.out.println("Playlist ID - "+updatedPlaylist.getId());
            System.out.println("Playlist Name - "+updatedPlaylist.getName());
            System.out.println("Song IDs - "+updatedPlaylist.getSongIds().toString().replace("[", "").replace("]", "").replace(",", ""));
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
