package aminev.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * The {@code MyFileWriter} is writing list of line to specified destination
 *
 * @author Aminev Ramil
 */
@Slf4j
public class MyFileWriter {
    /**
     * Method that write list of String to file
     * @param fileName is destination where need to write lines
     * @param lines is list that will be write
     */
    public static void writeFile(String fileName, List<String> lines){
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fileName, false))){
            for (int i=0 ; i<lines.size() - 1; i++) {
                bout.write(lines.get(i) + "\n");
            }
            // Запись последней строчки без перехода на новую строку
            bout.write(lines.get(lines.size()-1));
        } catch (Exception e){
            log.error(e.getMessage());
            System.out.println("Error while writing file. Check logs\\lesson5.log");
        }
    }
}
