package aminev.handlers;

import aminev.util.CommandHandlerException;
import aminev.util.MyFilePrinter;
import aminev.util.MyFileReader;
import aminev.util.WrongCommandException;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The {@code PrintCommand} class handle print command.
 * Print specified line of file or whole file, depending on command.
 *
 * @author Aminev Ramil
 * @see CommandHandler
 */
public class PrintCommand implements CommandHandler {

    Pattern pattern;

    /**
     * Method that handle command. Check in more accurate pattern,
     * then parsing and calling util classes i.g. {@link MyFileReader}
     *
     * @param command that handled and need to be process
     * @throws CommandHandlerException in case of command handler isn't able to process command
     */
    @Override
    public void handle(String command) throws CommandHandlerException {
        pattern = Pattern.compile("^(print)( +[\\d])? +([\\w]+[\\w.]*)");
        if (!pattern.matcher(command).matches()) throw new WrongCommandException("Команда print написана неверно");
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineNumber = 0;
        boolean hasLineNumber;
        hasLineNumber = scanner.hasNextInt();
        if (hasLineNumber) {
            lineNumber = scanner.nextInt();
        }
        if (hasLineNumber && lineNumber == 0) throw new CommandHandlerException("Нулевой строки не существует");
        String fileName = scanner.next();
        if (hasLineNumber) MyFilePrinter.printLineFromFile(fileName, lineNumber);
        else MyFilePrinter.printFile(fileName);
    }
}
