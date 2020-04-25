package ru.geekbrains.main.site.at.collection.map;

import ru.geekbrains.main.site.at.collection.Dog;
import ru.geekbrains.main.site.at.collection.Human;

import java.util.HashMap;

public class AddExample {

    public static void main(String[] args) {
        HashMap<Human, Dog> mapDogs = new HashMap<>();
        mapDogs.put(new Human("Коля"), new Dog("Тузик"));

        System.out.println(mapDogs);
        System.out.println(mapDogs.size());
        System.out.println(mapDogs.isEmpty());

    }

}
