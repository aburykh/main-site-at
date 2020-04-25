package ru.geekbrains.main.site.at.collection;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Start {
    public static void main(String[] args) {
        Dog dog = new Dog("Купер");
        //Dog dog2 = new Dog("Купер");
        //Cat cat = new Cat("Купер");

        List<Dog> dogs = new ArrayList<>();
        //Добавление в массив:
        System.out.println(">>> clear() - очистка массива");

        dogs.add(new Dog("Барбос"));
        dogs.add(new Dog("Тузик"));
        dogs.add(dog);

        //        ensureCapacity(); -- задать фиксированный размер массива
        System.out.println(">>> ensureCapacity() - задать фиксированный размер массива");
        //((ArrayList) dog).ensureCapacity(7);

        //        trimToSize(); -- удаление незанятых ячеек
        System.out.println(">>> trimToSize() - удаление незанятых ячеек");
        //((ArrayList) dog).ensureCapacity(7);

        //Получаем:
        System.out.println(">>> indexOff() - получение индекса элемента по объекту");
        System.out.println(dogs.indexOf(dog));
        System.out.println(dogs.indexOf(dogs));

        System.out.println(dogs.get(2));


        //Проверка массива на isEmprty:
        System.out.println(">>> clear() - очистка массива");


        System.out.println(dogs.isEmpty());
        System.out.println(dogs);

        //Проверка на вхождение в коллекцию:
        System.out.println(">>> contains() - проверка на вхождение элемента в коллекцию");
        System.out.println(dogs.contains(dog));
        System.out.println(dogs.contains(new Dog("Дик")));


        //Удаление:
        System.out.println(">>> remove() - Удаление  по индексу/объекту");
        System.out.println(dogs.remove(new Dog("Дик")));
        System.out.println(dogs.remove(dog));
        System.out.println(dogs.remove(1));
        System.out.println(dogs);

        //Замена:
        System.out.println(">>> set() - замена элемента");
        System.out.println(dogs.set(0, new Dog("Шарик")));
        System.out.println(dogs);


        //Проверка массива на isEmprty:
        System.out.println(">>> clear() - очистка массива");
        System.out.println(dogs.isEmpty());


        System.out.println(dogs);

        List<String> listString = new ArrayList<>();
        listString.add("Купер");
        listString.add("Купер");
        listString.add("Барбос");
        listString.add("Тузик");

        System.out.println(listString);
        Collections.sort(listString);
        System.out.println(listString);


        // Проверка на одинаковые значения
        System.out.println(">>> Collections.frequency(arr, object) - проверка на одинаковые значения");
        int frequency = Collections.frequency(listString, "Купер");
        System.out.println(frequency);

        //ОБъединение
        System.out.println(">>> ListUtils.union(listA, listB)");
        List<String> listString1 = new ArrayList<>();
        listString1.add("Купер");
        listString1.add("Барбос");

        List<String> listString2 = new ArrayList<>();
        listString2.add("Тимми");
        listString2.add("Нортон");

        List<String> union = ListUtils.union(listString1, listString2);


        //Позволяет ходить итератором в 2х направлениях
        System.out.println(">>> listIterator");
        ListIterator<String> stringListIterator = union.listIterator();


        //System.out.println(dog1.equals(cat));

        System.out.println();
    }
}
