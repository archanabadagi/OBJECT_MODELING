package com.object.modeling.jukebox.commands;

import java.util.List;
import com.object.modeling.jukebox.services.IPlaylistService;

public class DeletePlaylistCommand implements ICommand{

    private final IPlaylistService playlistService;

    public DeletePlaylistCommand(IPlaylistService playlistService){
        this.playlistService=playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            playlistService.delete(tokens.get(1), tokens.get(2));
            System.out.println("Delete Successful");
        }catch(RuntimeException e){
            System.out.println("Error Message if the Playlist IDs do not exist.");
        }
    }
    
}
