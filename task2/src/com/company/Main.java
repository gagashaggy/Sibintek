package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // путь к файлу
        String path = "work/file.txt";
        // генератор файлов
        Generator generator = new Generator(path);
        // если файла не существует, генерируем новый
        if (!generator.checkThatTextFileExists()) {
            generator.generateNewFile();
        }
        // редактор файлов
        Editor editor = new Editor(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название колонки, значение которой хотите заменить");
        String column = scanner.nextLine();
        while (!editor.getColumns().contains(column)) {
            System.out.println("Такой колонки не существует");
            column = scanner.nextLine();
        }
        System.out.println("Текущее значение колонки: " + editor.getValues().get(editor.getColumns().indexOf(column)));
        System.out.println("Введите новое значение для колонки");
        String value = scanner.nextLine();
        if (editor.edit(column, value))
            System.out.println("Колонке " + column + " присвоено новое значение: " + value);
        else System.out.println("При записи возникоа ошибка");
    }
}