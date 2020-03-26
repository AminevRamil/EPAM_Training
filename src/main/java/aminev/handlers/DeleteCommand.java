package aminev.handlers;

import aminev.util.CommandHandlerException;
import aminev.util.MyFileReader;
import aminev.util.MyFileWriter;
import aminev.util.WrongCommandException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The {@code DeleteCommand} class handle delete command.
 * Remove specified or last line of file, depending on command.
 *
 * @author Aminev Ramil
 * @see CommandHandler
 */
public class DeleteCommand implements CommandHandler {
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
        pattern = Pattern.compile("^(delete)( +[\\d]*)? +([\\w]+[\\w.]*)$");
        if (!pattern.matcher(command).matches()) throw new WrongCommandException("Команда delete написана неверно");
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineToDelete = 1;
        boolean hasLineNumber = scanner.hasNextInt();
        if (hasLineNumber) {
            lineToDelete = scanner.nextInt();
        }
        String fileName = scanner.next();
        List<String> lines = MyFileReader.parseFileToLines(fileName);
        if (hasLineNumber) {
            if (lineToDelete > lines.size()) throw new CommandHandlerException("Указана строка отсутствующая в файле");
            lines.remove(lineToDelete - 1);
        } else {
            lines.remove(lines.size() - 1);
        }
        MyFileWriter.writeFile(fileName, lines);
    }
}
