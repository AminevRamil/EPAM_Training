package aminev;

import aminev.handlers.*;
import aminev.util.CommandException;
import aminev.util.WrongCommandException;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Filter {

    HashMap<String, CommandsTypes> stringCommandsTypesHashMap;
    HashMap<CommandsTypes, CommandHandler> commandsTypesCommandHandlerHashMap;
    Pattern pattern;
    Filter(){
        pattern = Pattern.compile("(\\b(add|print|delete)\\b *[\\d]* *([\\w]+[\\w.]*) *(\"[\\w ]*\")?)|(exit)|(help)");
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

    public void execute(String command) throws CommandException, WrongCommandException {
        if (pattern.matcher(command).matches()) {
            System.out.println("Команда распознана");
            Scanner scanner = new Scanner(command);
            scanner.useDelimiter(" ");
            CommandsTypes type = stringCommandsTypesHashMap.get(scanner.next());
            commandsTypesCommandHandlerHashMap.get(type).hande(command);
        } else {
            throw new WrongCommandException("Комманда не распознана");
        }
    }
}
