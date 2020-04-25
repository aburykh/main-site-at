package ru.geekbrains.main.site.at.collection;

import java.util.Objects;

/**
 * V 1. Создать массив с набором из 10–20 слов, должны встречаться повторяющиеся. Найти и вывести список уникальных слов,
 * из которых состоит массив. Посчитать, сколько раз встречается каждое слово.
 *
 * 2. Написать простой класс Телефонный Справочник, который хранит список фамилий и телефонных номеров.
 * В него с помощью метода add() можно добавлять записи, а с помощью get() — искать номер телефона по фамилии.
 * Для одной фамилии может быть несколько телефонов (однофамильцы): тогда при запросе такой фамилии должны выводиться все номера.
 * Не надо в телефонную запись добавлять дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль
 * и иначе дополнять задание. Консоль желательно не использовать для ввода, тестировать просто из метода main(), прописывая add() и get().
 */

public class Surname {

    private String name;

//    public static void main(String[] args) {
//        List<Words> listOfWord = new ArrayList<>();
//        listOfWord.add(new Words("Иванов"));
//        listOfWord.add(new Words("Петров"));
//        listOfWord.add(new Words("Соколов"));
//        listOfWord.add(new Words("Хорьков"));
//        listOfWord.add(new Words("Волков"));
//        listOfWord.add(new Words("Иванов"));
//        listOfWord.add(new Words("Сусликов"));
//        listOfWord.add(new Words("Бобров"));
//        listOfWord.add(new Words("Соколов"));
//        listOfWord.add(new Words("Медведев"));
//        listOfWord.add(new Words("Орлов"));
//        listOfWord.add(new Words("Иванов"));
//        System.out.println(">>>>>>>>>>");
//        System.out.println(listOfWord.isEmpty());
//        System.out.println(listOfWord);
//        System.out.println(">>>>>>>>>>");
//        int frequency = Collections.frequency(listOfWord, "Иванов");
//        System.out.println(frequency);
//
//        System.out.println(listOfWord.contains(Words));
//    }

    public Surname(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Surname surname = (Surname) o;
        return Objects.equals(name, surname.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Surname{" +
                "name='" + name + '\'' +
                '}';
    }

}
