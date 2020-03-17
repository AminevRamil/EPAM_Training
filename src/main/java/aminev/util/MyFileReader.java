package aminev.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MyFileReader {
    public static List<String> parseFileToLines(String fileName) throws CommandException {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader bin = new BufferedReader(new FileReader(file))) {
                while (bin.ready())
                    lines.add(bin.readLine());
            } catch (FileNotFoundException e) {
                System.out.println("Целевого файла не существует");
                log.error(e.getMessage());
            } catch (Exception e) {
                log.error(e.getMessage());
                System.out.println("Ошибка при чтении файла. Смотрите logs\\lesson5.log");
            }
        } else {
            throw new CommandException("Указанного файла не существует");
        }
        return lines;
    }
}
