package com.epam.aminev.task3;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Custom class loader that load class from specified classPath
 */
@Slf4j
public class CustomClassLoader extends ClassLoader {

    private String classPath;

    /**
     * Construct new {@code CustomClassLoader} with specified class path
     *
     * @param path where is classes stored
     */
    public CustomClassLoader(String path) {
        super();
        classPath = path;
    }

    /**
     * Method that trying find specified class in classPath folder
     *
     * @param className with need to find
     * @return Class object that was created from the specified class data.
     * @throws ClassNotFoundException if there is no such class in any
     *                                class path of any class loaders
     */
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] bytes = fetchClassFromFS(classPath + className + ".class");
            return defineClass(className, bytes, 0, bytes.length);
        } catch (IOException e) {
            log.error(e.getMessage());
            return super.findClass(className);
        }
    }

    /**
     * Method that tries load class from filesystem into runtime
     *
     * @param path to the class
     * @return bytes array that contains raw class data
     * @throws IOException in case there is no such file or file can't be read
     */
    private byte[] fetchClassFromFS(String path) throws IOException {
        InputStream inputStream = new FileInputStream(new File(path));
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            throw new IOException("File is too big");
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead;
        while (offset < bytes.length
                && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        inputStream.close();
        return bytes;
    }
}