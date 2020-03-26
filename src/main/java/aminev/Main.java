package aminev;

import aminev.util.CommandHandlerException;
import aminev.util.WrongCommandException;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Main class which demonstrate understanding of how Streams and IO works
 *
 * @author Aminev Ramil
 */
@Slf4j
public class Main {
    /**
     * Entry point in demo that was did during lesson 5
     *
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {
        System.out.println("Для выхода напишите \"exit\"");
        Scanner scanner = new Scanner(System.in);
        String command;
        Filter filter = new Filter();
        while (true) {
            try {
                command = scanner.nextLine();
                filter.execute(command);
            } catch (CommandHandlerException | WrongCommandException e) {
                log.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
