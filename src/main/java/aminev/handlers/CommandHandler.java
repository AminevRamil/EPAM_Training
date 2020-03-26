package aminev.handlers;

import aminev.util.CommandHandlerException;
import aminev.util.WrongCommandException;

/**
 * The {@code CommandHandler} interface that indicates that implemented
 * class is an command handler that should process user's command
 * and if it need throwing appropriate exception
 *
 * @author Aminev Ramil
 */
public interface CommandHandler {
    void handle(String command)  throws CommandHandlerException;
}
