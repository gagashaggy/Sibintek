package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> referentKeys = new ArrayList<>();
        referentKeys.add("A");
        referentKeys.add("B");
        referentKeys.add("C");
        referentKeys.add("D");
        List<String> databaseKeys = new ArrayList<>();
        databaseKeys.add("A");
        databaseKeys.add("B");
        databaseKeys.add("C");
        databaseKeys.add("D");
        databaseKeys.add("E");
        checkExtraKeys(referentKeys, databaseKeys);
        checkDatabaseContainsReferentKeys(referentKeys, databaseKeys);
    }

    private static void checkExtraKeys(List<String> referentKeys, List<String> databaseKeys) {
        List<String> temp = new ArrayList<>(databaseKeys);
        temp.removeAll(referentKeys);
        if (!temp.isEmpty()) {
            System.out.println("Список содержит лишние ключи:");
            for (String key: temp)
                System.out.println(key);
        } else System.out.println("Список содержит только эталонные ключи");
    }

    private static void checkDatabaseContainsReferentKeys(List<String> referentKeys, List<String> databaseKeys) {
        List<String> temp = new ArrayList<>(referentKeys);
        temp.removeAll(databaseKeys);
        if (!temp.isEmpty()) {
            System.out.println("Список не содержит некоторые эталонные ключи:");
            for (String key: temp)
                System.out.println(key);
        } else System.out.println("Список содержит все эталонные ключи");
    }
}