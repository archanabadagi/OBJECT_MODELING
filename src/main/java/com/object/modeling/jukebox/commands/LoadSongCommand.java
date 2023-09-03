package com.object.modeling.jukebox.commands;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

import com.object.modeling.jukebox.entities.Album;
import com.object.modeling.jukebox.services.ISongService;


public class LoadSongCommand implements ICommand{

    private final ISongService songService;

    public LoadSongCommand(ISongService songService){
        this.songService=songService;
    }

    @Override
    public void execute(List<String> tokens) {
        BufferedReader reader;
        String inputFile=tokens.get(1);
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                List<String> song = Arrays.asList(line.split(","));
                List<String> featuredArtists = new ArrayList<String>(Arrays.asList(song.get(4).split("#")));
                songService.create(song.get(0), song.get(1), new Album(song.get(2), song.get(3), featuredArtists));
                line = reader.readLine();
            }
            System.out.println("Songs Loaded successfully");
            reader.close();
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
