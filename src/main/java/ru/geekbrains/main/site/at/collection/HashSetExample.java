package ru.geekbrains.main.site.at.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Set<Dog> objects = new HashSet<>();
        objects.add(new Dog("Барбос"));
        objects.add(new Dog("Шарик"));
        objects.add(new Dog("Купер"));
        objects.add(new Dog("Барбос"));

        Object[] objects1 = objects.toArray();

        System.out.println(objects);


    }
}
