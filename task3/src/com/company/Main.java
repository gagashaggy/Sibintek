package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = scanner.nextLine();
        System.out.println(removeRepeatedPairs(s));
    }

    /**
     * Убрать из строки парные идущие друг за другом буквы, например aaabccddd => abd, baab => пусто
     * aaabccddd
     *
     * @param s - исходная строка
     * @return {@link String}
     */
    public static String removeRepeatedPairs(String s) {
        // пока строка содержит повторы
        while (checkThatStringHasPairs(s)) {
            StringBuilder builder = new StringBuilder();
            char[] chars = s.toCharArray();
            // итератор
            int i = 0;
            // количество повторений буквы
            int n = 0;
            // проходим по каждому символу строки, кроме последнего
            while (i < s.length() - 1) {
                // если текущий символ является буквой и совпадает со следующим
                if (Character.isLetter(chars[i]) && chars[i] == chars[i + 1])
                    // увеличиваем число повторений буквы
                    n++;
                    // если текущий символ не буква
                else if (!Character.isLetter(chars[i]))
                    // оставляем его в строке
                    builder.append(chars[i]);
                    // повторения буквы кончились
                else {
                    // если количество одинаковых идущих подряд букв нечётное
                    if ((n + 1) % 2 == 1)
                        // добавляем букву в результирующую строку
                        builder.append(chars[i]);
                    // обнуляем число повторений буквы
                    n = 0;
                }
                i++;
            }
            // в конце также проверяем количество одинаковых идущих подряд букв
            if ((n + 1) % 2 == 1)
                // если оно нечётное, добавляем букву в результирующую строку
                builder.append(chars[i]);
            s = builder.toString();
        }
        return s;
    }

    /**
     * Проверить, содержит ли строка повторы
     * @param s - анализируемая строка
     * @return {@link String}
     */
    private static boolean checkThatStringHasPairs(String s) {
        char[] chars = s.toCharArray();
        // проходим по каждому символу строки, кроме последнего
        for (int i = 0; i < chars.length - 1; i++) {
            // если текущий символ является буквой и совпадает со следующим
            if (Character.isLetter(chars[i]) && chars[i] == chars[i + 1])
                // значит повторы есть
                return true;
        }
        // повторов нет
        return false;
    }
}