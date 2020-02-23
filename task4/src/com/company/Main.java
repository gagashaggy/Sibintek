package com.company;

import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // первый список
        List<ObjectA> list1 = new ArrayList<>();
        list1.add(new ObjectA(1, "field1", "value1"));
        list1.add(new ObjectA(2, "field2", "value2"));
        list1.add(new ObjectA(3, "field3", "value3"));
        list1.add(new ObjectA(4, "field4", "value4"));
        // второй список
        List<ObjectA> list2 = new ArrayList<>();
        list2.add(new ObjectA(1, "field1", "value1"));
        list2.add(new ObjectA(2, "otherField", "value2"));
        list2.add(new ObjectA(3, "field3", "otherValue"));
        list2.add(new ObjectA(4, "otherField", "otherValue"));
        // объект, который будет осуществлять сравнение
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < list1.size(); i++) {
            // сравниваем без использования SoftAssert
            compareFields(list1.get(i), list2.get(i));
            // сравниваем с использованием SoftAssert
            compareFields(list1.get(i), list2.get(i), softAssert);
        }
        softAssert.assertAll();
    }

    /**
     * Сравнить поля двух объектов класса ObjectA без использования SoftAssert
     * @param obj1 - эталонный объект
     * @param obj2 - объект, который требуется проверить на соответствие эталонному
     */
    public static void compareFields(ObjectA obj1, ObjectA obj2) {
        if (!obj2.field.equals(obj1.field))
            System.out.println("Для id=" + obj1.id +
                    " не совпало следующее: Поле field => ожидаемое значение: " + obj1.field + ", текущее: " + obj2.field);
        if (!obj2.fieldValue.equals(obj1.fieldValue))
            System.out.println("Для id=" + obj1.id +
                    " не совпало следующее: Поле fieldValue => ожидаемое значение: " + obj1.fieldValue + ", текущее: " + obj2.fieldValue);
    }

    /**
     * Сравнить поля двух объектов класса ObjectA с использованием класса SoftAssert
     * @param obj1 - эталонный объект
     * @param obj2 - объект, который требуется проверить на соответствие эталонному
     * @param softAssert - объект класса SoftAssert, выполняющий сравнение
     */
    public static void compareFields(ObjectA obj1, ObjectA obj2, SoftAssert softAssert) {
        softAssert.assertEquals(obj2.field, obj1.field, "Для id=" + obj1.id +
                " не совпало следующее: Поле field => ожидаемое значение: " + obj1.field + ", текущее: " + obj2.field);
        softAssert.assertEquals(obj2.fieldValue, obj1.fieldValue, "Для id=" + obj1.id +
                " не совпало следующее: Поле fieldValue => ожидаемое значение: " + obj1.fieldValue + ", текущее: " + obj2.fieldValue);
    }
}