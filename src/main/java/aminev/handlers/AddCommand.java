package aminev.handlers;

import aminev.util.CommandHandlerException;
import aminev.util.MyFileReader;
import aminev.util.MyFileWriter;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The {@code AddCommand} class handle add command.
 * Inject line before specified line of file or append to the end, depending on command.
 *
 * @author Aminev Ramil
 * @see CommandHandler
 */
public class AddCommand implements CommandHandler {
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
        pattern = Pattern.compile("^(add)( +[\\d]*)? +([\\w]+[\\w.]*) +(\"[\\w ]*\")?$");
        if (!pattern.matcher(command).matches()) throw new CommandHandlerException("Команда add написана неверно");
        Scanner scanner = new Scanner(command);
        scanner.next();
        int toLineNumber = 0;
        boolean hasLineNumber = scanner.hasNextInt();
        if (hasLineNumber) {
            toLineNumber = scanner.nextInt();
        }
        String fileName = scanner.next();
        String text = scanner.findInLine("\"[\\w ]*\"");
        text = text.replace("\"", "");
        List<String> lines = MyFileReader.parseFileToLines(fileName);
        if (hasLineNumber) {
            for (int i = lines.size(); i < toLineNumber - 1; i++) {
                lines.add("");
            }
            lines.add(toLineNumber - 1, text);
        } else {
            lines.add(text);
        }
        MyFileWriter.writeFile(fileName, lines);
    }
}
