package aminev.handlers;

import aminev.util.CommandException;
import aminev.util.MyFileReader;
import aminev.util.MyFileWriter;
import aminev.util.WrongCommandException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DeleteCommand implements CommandHandler {
    Pattern pattern;

    @Override
    public void handle(String command) throws CommandException, WrongCommandException {
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
            if (lineToDelete > lines.size()) throw new CommandException("Указана строка отсутствующая в файле");
            lines.remove(lineToDelete - 1);
        } else {
            lines.remove(lines.size() - 1);
        }
        MyFileWriter.writeFile(fileName, lines);
    }
}
