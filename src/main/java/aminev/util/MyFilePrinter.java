package aminev.util;

import java.util.List;

/**
 * The {@code MyFilePrinter} class prints specified line from file
 * or prints whole file to STDOUT
 *
 * @author Aminev Ramil
 * @see MyFileReader
 */
public class MyFilePrinter {
    /**
     * Method that print whole file
     *
     * @param fileName of file that will be print
     */
    public static void printFile(String fileName) {
        List<String> lines = MyFileReader.parseFileToLines(fileName);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    /**
     * Method that print specified line from file
     *
     * @param fileName of file which line will print
     * @param line     that will be print
     */
    public static void printLineFromFile(String fileName, int line) {
        List<String> lines = MyFileReader.parseFileToLines(fileName);
        System.out.println(lines.get(line - 1));
    }
}
