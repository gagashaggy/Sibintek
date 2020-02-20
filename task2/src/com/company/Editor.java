package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Editor {

    // файл
    private File file;
    // колонки
    private List<String> columns;
    // значения
    private List<String> values;

    /**
     * Создать объект редактора файлов
     * @param path - путь к файлу
     */
    public Editor(String path) throws IOException {
        // файл
        file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        columns = Arrays.asList(reader.readLine().split(","));
        values = Arrays.asList(reader.readLine().split(","));
    }

    /**
     * Изменить файл - записать в указанную колонку новое значение
     * @param column - название колонки
     * @param value - новое значение
     * @return true - если удалось перезаписать значение в файле, иначе - false
     */
    public boolean edit(String column, String value) {
        int i = columns.indexOf(column);
        values.set(i, value);
        String columns = String.join(",", this.columns);
        String values = String.join(",", this.values);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(columns + "\n");
            writer.append(values);
            writer.flush();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Получить названия колонок
     * @return {@link java.util.ArrayList} of {@link String}
     */
    public List<String> getColumns() {
        return columns;
    }

    /**
     * Получить значения колонок
     * @return {@link java.util.ArrayList} of {@link String}
     */
    public List<String> getValues() {
        return values;
    }
}