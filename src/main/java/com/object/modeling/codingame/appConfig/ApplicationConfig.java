package com.object.modeling.codingame.appConfig;

import com.object.modeling.codingame.commands.AttendContestCommand;
import com.object.modeling.codingame.commands.CommandInvoker;
import com.object.modeling.codingame.commands.CreateContestCommand;
import com.object.modeling.codingame.commands.CreateQuestionCommand;
import com.object.modeling.codingame.commands.CreateUserCommand;
import com.object.modeling.codingame.commands.LeaderBoardCommand;
import com.object.modeling.codingame.commands.ListContestCommand;
import com.object.modeling.codingame.commands.ListQuestionCommand;
import com.object.modeling.codingame.commands.RunContestCommand;
import com.object.modeling.codingame.commands.WithdrawContestCommand;
import com.object.modeling.codingame.repositories.ContestRepository;
import com.object.modeling.codingame.repositories.IContestRepository;
import com.object.modeling.codingame.repositories.IQuestionRepository;
import com.object.modeling.codingame.repositories.IUserRepository;
import com.object.modeling.codingame.repositories.QuestionRepository;
import com.object.modeling.codingame.repositories.UserRepository;
import com.object.modeling.codingame.services.ContestService;
import com.object.modeling.codingame.services.IContestService;
import com.object.modeling.codingame.services.IQuestionService;
import com.object.modeling.codingame.services.IUserService;
import com.object.modeling.codingame.services.QuestionService;
import com.object.modeling.codingame.services.UserService;

public class ApplicationConfig {
    private final IQuestionRepository questionRepository = new QuestionRepository();
    private final IUserRepository userRepository = new UserRepository();
    private final IContestRepository contestRepository = new ContestRepository();

    private final IQuestionService questionService = new QuestionService(questionRepository);
    private final IUserService userService = new UserService(userRepository, contestRepository);
    private final IContestService contestService = new ContestService(contestRepository, questionRepository, userRepository, userService);
    
    private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    private final CreateQuestionCommand createQuestionCommand = new CreateQuestionCommand(questionService);
    private final ListQuestionCommand listQuestionCommand = new ListQuestionCommand(questionService);
    private final CreateContestCommand createContestCommand = new CreateContestCommand(contestService);
    private final ListContestCommand listContestCommand = new ListContestCommand(contestService);
    private final AttendContestCommand attendContestCommand = new AttendContestCommand(userService);
    private final RunContestCommand runContestCommand = new RunContestCommand(contestService);
    private final LeaderBoardCommand leaderBoardCommand = new LeaderBoardCommand(userService);
    private final WithdrawContestCommand withdrawContestCommand = new WithdrawContestCommand(userService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("CREATE_USER",createUserCommand);
        commandInvoker.register("CREATE_QUESTION",createQuestionCommand);
        commandInvoker.register("LIST_QUESTION",listQuestionCommand);
        commandInvoker.register("CREATE_CONTEST",createContestCommand);
        commandInvoker.register("LIST_CONTEST",listContestCommand);
        commandInvoker.register("ATTEND_CONTEST",attendContestCommand);
        commandInvoker.register("RUN_CONTEST",runContestCommand);
        commandInvoker.register("LEADERBOARD",leaderBoardCommand);
        commandInvoker.register("WITHDRAW_CONTEST",withdrawContestCommand);
        return commandInvoker;
    }
}
