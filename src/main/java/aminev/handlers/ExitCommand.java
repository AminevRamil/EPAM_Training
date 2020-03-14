package aminev.handlers;

import aminev.util.CommandException;
import aminev.util.WrongCommandException;

public class ExitCommand implements CommandHandler {
    @Override
    public void hande(String command) throws WrongCommandException {
        System.exit(0);
    }
}
