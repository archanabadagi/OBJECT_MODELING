package com.object.modeling.jukebox.appConfig;

import com.object.modeling.jukebox.commands.*;
import com.object.modeling.jukebox.repositories.*;
import com.object.modeling.jukebox.services.*;

public class ApplicationConfig {
    private final IPlaylistRepository playlistRepository = new PlaylistRepository();
    private final ISongRepository songRespository = new SongRepository();
    private final IUserRepository userRepository = new UserRepository();

    private final IPlaylistService playlistService = new PlaylistService(playlistRepository);
    private final ISongService songService = new SongService(songRespository);
    private final IUserService userService = new UserService(userRepository);

    private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
    private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
    private final LoadSongCommand loadSongCommand = new LoadSongCommand(songService);
    private final ModifyPlaylistCommand modifyPlaylistCommand = new ModifyPlaylistCommand(playlistService, songService);
    private final PlayPlaylistCommand playPlaylistCommand = new PlayPlaylistCommand(playlistService, songService);
    private final PlaySongCommand playSongCommand = new PlaySongCommand(playlistService, songService);
    

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("CREATE-PLAYLIST",createPlaylistCommand);
        commandInvoker.register("CREATE-USER",createUserCommand);
        commandInvoker.register("DELETE-PLAYLIST",deletePlaylistCommand);
        commandInvoker.register("LOAD-DATA",loadSongCommand);
        commandInvoker.register("MODIFY-PLAYLIST",modifyPlaylistCommand);
        commandInvoker.register("PLAY-PLAYLIST",playPlaylistCommand);
        commandInvoker.register("PLAY-SONG",playSongCommand);
        return commandInvoker;
    }
    
}
