package aminev.handlers;

import aminev.util.CommandException;
import aminev.util.MyFileReader;
import aminev.util.WrongCommandException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrintCommand implements CommandHandler {

    Pattern pattern = Pattern.compile("");

    @Override
    public void hande(String command) throws CommandException, WrongCommandException {
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

        List<String> lines = MyFileReader.parseFileToLines(fileName);
        if (hasLineNumber){
            if (lineNumber > lines.size()) throw new CommandException("Запрос несуществующей строки");
            System.out.println(lines.get(lineNumber-1));
        } else {
            System.out.println("Содержимое файла:");
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }
}
