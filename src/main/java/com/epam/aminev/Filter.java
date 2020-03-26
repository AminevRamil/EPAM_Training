package com.epam.aminev;

import com.epam.aminev.handlers.*;
import com.epam.aminev.util.WrongCommandException;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The {@code Filter} is a command handler that valid incoming command
 * and pick a proper command handler for further processing.
 *
 * @author Aminev Ramin
 * @see CommandsTypes
 */
public class Filter {

    private HashMap<String, CommandsTypes> stringCommandsTypesHashMap;
    private HashMap<CommandsTypes, CommandHandler> commandsTypesCommandHandlerHashMap;
    private Pattern pattern;

    /**
     * Construct default Filter with pattern and HashMap of proper handlers
     */
    public Filter() {
        pattern = Pattern.compile("(\\b(add|print|delete)\\b( +[\\d]*)? +([\\w]+[\\w.]*) +(\"[\\w ]*\")?)|(exit)|(help)");
        stringCommandsTypesHashMap = new HashMap<>();
        stringCommandsTypesHashMap.put("add", CommandsTypes.ADD);
        stringCommandsTypesHashMap.put("exit", CommandsTypes.EXIT);
        stringCommandsTypesHashMap.put("print", CommandsTypes.PRINT);
        stringCommandsTypesHashMap.put("delete", CommandsTypes.DELETE);
        commandsTypesCommandHandlerHashMap = new HashMap<>();
        commandsTypesCommandHandlerHashMap.put(CommandsTypes.ADD, new AddCommand());
        commandsTypesCommandHandlerHashMap.put(CommandsTypes.EXIT, new ExitCommand());
        commandsTypesCommandHandlerHashMap.put(CommandsTypes.PRINT, new PrintCommand());
        commandsTypesCommandHandlerHashMap.put(CommandsTypes.DELETE, new DeleteCommand());
    }

    /**
     * Method that must be used to process incoming command
     *
     * @param command that need to be checked and executed
     * @throws WrongCommandException in case of wrong command has come
     */
    public void execute(String command) {
        if (pattern.matcher(command).matches()) {
            System.out.println("Command recognized");
            Scanner scanner = new Scanner(command);
            scanner.useDelimiter(" ");
            CommandsTypes type = stringCommandsTypesHashMap.get(scanner.next());
            commandsTypesCommandHandlerHashMap.get(type).handle(command);
        } else {
            throw new WrongCommandException("Command not recognized");
        }
    }
}
