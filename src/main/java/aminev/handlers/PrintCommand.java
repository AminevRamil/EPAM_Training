package aminev.handlers;

import aminev.util.CommandException;
import aminev.util.MyFilePrinter;
import aminev.util.MyFileReader;
import aminev.util.WrongCommandException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrintCommand implements CommandHandler {

    Pattern pattern;

    @Override
    public void handle(String command) throws CommandException, WrongCommandException {
        pattern = Pattern.compile("^(print) *[\\d]{0,5} *([\\w]+[\\w.]*)");
        if (!pattern.matcher(command).matches()) throw new WrongCommandException("Команда print написана неверно");
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineNumber = 0;
        boolean hasLineNumber;
        hasLineNumber = scanner.hasNextInt();
        if (hasLineNumber) {
            lineNumber = scanner.nextInt();
        }
        if (hasLineNumber && lineNumber == 0) throw new CommandException("Нулевой строки не существует");
        String fileName = scanner.next();
        if (hasLineNumber) MyFilePrinter.printLineFromFile(fileName, lineNumber);
        else MyFilePrinter.printFile(fileName);

    }
}
