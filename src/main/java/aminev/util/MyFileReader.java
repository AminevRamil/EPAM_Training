package aminev.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MyFileReader} class is reads whole specified file
 * in RAM for further processing
 *
 * @author Aminev Ramil
 */
@Slf4j
public class MyFileReader {
    /**
     * Method that parse file to list of lines
     *
     * @param fileName of file that will be parsed
     * @return list of lines from file
     * @throws CommandHandlerException in case
     */
    public static List<String> parseFileToLines(String fileName) throws CommandHandlerException {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader bin = new BufferedReader(new FileReader(file))) {
                while (bin.ready())
                    lines.add(bin.readLine());
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
                System.out.println("Specified file doesn't exist");
            } catch (Exception e) {
                log.error(e.getMessage());
                System.out.println("Error while read file. Check logs\\lesson5.log");
            }
        } else {
            throw new CommandHandlerException("Specified file doesn't exist");
        }
        return lines;
    }
}
