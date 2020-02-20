package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Класс для проверки наличия файла и генерации нового
 */
public class Generator {

    // файл
    private File file;

    private FileWriter writer;

    /**
     * Создать объект генератора файлов
     * @param path - путь к файлу
     */
    public Generator(String path) {
        file = new File(path);
    }

    /**
     * Создать рабочую папку
     */
    private void createWorkFolder() {
        File logsDir = new File("work");
        logsDir.mkdirs();
    }

    /**
     * Проверить, что файл существует
     * @return true - если файл существует, иначе - false
     */
    public boolean checkThatTextFileExists() {
        createWorkFolder();
        return file.exists();
    }

    /**
     * Создать новый файл со случайными названиями колонок и значениями
     * @throws IOException
     */
    public void generateNewFile() throws IOException {
        writer = new FileWriter(file);
        Random random = new Random();
        // кол-во колонок
        int n = random.nextInt(15) + 5;
        StringBuilder builder = new StringBuilder();
        // генерируем строку с названиями колонок
        for (int i = 0; i < n - 1; i++) {
            builder.append(generateRandomString()).append(",");
        }
        builder.append(generateRandomString());
        writer.write(builder.toString() + "\n");
        builder = new StringBuilder();
        // генерируем строку со значениями
        for (int i = 0; i < n - 1; i++) {
            builder.append(generateRandomString()).append(",");
        }
        builder.append(generateRandomString());
        writer.append(builder.toString());
        writer.flush();
        writer.close();
    }

    /**
     * Сгенерировать случайную строку
     * @return {@link String}
     */
    public String generateRandomString() {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        // кол-во символов в строке
        int n = random.nextInt(15) + 5;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(chars[random.nextInt(chars.length)]);
        }
        return builder.toString();
    }
}