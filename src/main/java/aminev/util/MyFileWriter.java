package aminev.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Slf4j
public class MyFileWriter {
    public static void writeFile(String fileName, List<String> lines){
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fileName, false))){
            for (int i=0 ; i<lines.size() - 1; i++) {
                bout.write(lines.get(i) + "\n");
            }
            // Запись последней строчки без перехода на новую строку
            bout.write(lines.get(lines.size()-1));
        } catch (Exception e){
            log.error(e.getMessage());
            System.out.println("Ошибка во время записи в файл. Смотрите logs\\lesson5.log");
        }
    }
}
