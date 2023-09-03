package com.object.modeling.jukebox.commands;

import java.util.List;
import java.util.ArrayList;

import com.object.modeling.jukebox.services.IPlaylistService;
import com.object.modeling.jukebox.entities.Playlist;

public class CreatePlaylistCommand implements ICommand{

    private final IPlaylistService playlistService;

    public CreatePlaylistCommand(IPlaylistService playlistService){
        this.playlistService=playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            List<String> songIds = new ArrayList<String>();
            for(int i=3;i<tokens.size();i++){
                songIds.add(tokens.get(i));
            }
            Playlist playlist= playlistService.create(tokens.get(1), tokens.get(2), songIds);
            System.out.println("Playlist ID - "+playlist.getId());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
