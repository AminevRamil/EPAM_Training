package aminev.handlers;

import aminev.util.CommandException;
import aminev.util.WrongCommandException;

public interface CommandHandler {
    void hande(String command)  throws CommandException, WrongCommandException;
}
