package aminev.handlers;

import aminev.util.CommandException;
import aminev.util.MyFileReader;
import aminev.util.MyFileWriter;
import aminev.util.WrongCommandException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 *
 */
public class AddCommand implements CommandHandler {
    Pattern pattern;

    @Override
    public void handle(String command) throws CommandException, WrongCommandException {
        pattern = Pattern.compile("^(add) *[\\d]* *([\\w]+[\\w.]*) +(\"[\\w ]*\")?$");
        if (!pattern.matcher(command).matches()) throw new WrongCommandException("Команда add написана неверно");
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
            for (int i = lines.size(); i < toLineNumber-1; i++) {
                lines.add("");
            }
            lines.add(toLineNumber-1, text);
        } else {
            lines.add(text);
        }
        MyFileWriter.writeFile(fileName, lines);
    }
}
