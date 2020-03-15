package aminev.handlers;

import aminev.util.CommandException;
import aminev.util.WrongCommandException;

public interface CommandHandler {
    void handle(String command)  throws CommandException, WrongCommandException;
}
