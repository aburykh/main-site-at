package ru.geekbrains.main.site.at.collection.map;

import ru.geekbrains.main.site.at.collection.Dog;
import ru.geekbrains.main.site.at.collection.Human;

import java.util.HashMap;

public class ContainsExample {

    public static void main(String[] args) {
        HashMap<Human, Dog> mapDogs = new HashMap<>();
        mapDogs.put(new Human("Коля"), new Dog("Тузик"));

        boolean containsKey = mapDogs.containsKey(new Human("Коля"));
        boolean containsValue = mapDogs.containsValue(new Dog("Тузик"));


        System.out.println(containsKey);
        System.out.println(containsValue);

    }

}
