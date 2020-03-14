package aminev.util;

import java.util.List;

public class MyFilePrinter {
    public static void printFile(String fileName) {
        List<String> lines = MyFileReader.parseFileToLines(fileName);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void printLineFromFile(String fileName, int line) {
        List<String> lines = MyFileReader.parseFileToLines(fileName);
        System.out.println(lines.get(line - 1));
    }
}
