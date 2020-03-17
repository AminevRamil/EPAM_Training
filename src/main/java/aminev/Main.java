package aminev;

import aminev.util.CommandException;
import aminev.util.WrongCommandException;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        System.out.println("Для выхода напишите \"exit\"");
        Scanner scanner = new Scanner(System.in);
        String command;
        Filter filter = new Filter();
        while(true){
            try {
                command = scanner.nextLine();
                filter.execute(command);
            } catch (CommandException | WrongCommandException e){
                log.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
