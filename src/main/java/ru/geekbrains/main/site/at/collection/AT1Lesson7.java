package ru.geekbrains.main.site.at.collection;

import java.util.*;

/**
 * V 1. Создать массив с набором из 10–20 слов, должны встречаться повторяющиеся. Найти и вывести список уникальных слов,
 * из которых состоит массив. Посчитать, сколько раз встречается каждое слово.
 * <p>
 * 2. Написать простой класс Телефонный Справочник, который хранит список фамилий и телефонных номеров.
 * В него с помощью метода add() можно добавлять записи, а с помощью get() — искать номер телефона по фамилии.
 * Для одной фамилии может быть несколько телефонов (однофамильцы): тогда при запросе такой фамилии должны выводиться все номера.
 * Не надо в телефонную запись добавлять дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль
 * и иначе дополнять задание. Консоль желательно не использовать для ввода, тестировать просто из метода main(), прописывая add() и get().
 */

public class AT1Lesson7 {

        public static void main(String[] args) {

                String[] arrSurnames = {"Иванов", "Петров", "Соколов", "Хорьков", "Волков", "Иванов", "Сусликов", "Бобров", "Соколов", "Медведев", "Орлов", "Иванов"};

                System.out.println(">>> ДАНО: <<<");
                System.out.println("Массив из " + arrSurnames.length + " фамилий:");
                System.out.println(Arrays.toString(arrSurnames));
                String[] arrUniqueSurnames = getUniques(arrSurnames);
                System.out.println(countUniques(arrSurnames));

                System.out.println(">>> " + arrUniqueSurnames.length + " неповторяющихся фамилий в массиве:");
                System.out.println(Arrays.toString(arrUniqueSurnames));
        }

        private static String[] getUniques(String[] arr) {
                Set<String> stringSet = new HashSet<>(Arrays.asList(arr));
                return Arrays.copyOf(stringSet.toArray(), stringSet.size(), String[].class);
        }

        static String countUniques(String[] arr) {
                String[] arrUniqueSurnames = getUniques(arr);
                StringBuilder result = new StringBuilder();

                ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(arr));
                result.append(">>> Количество упоминаний каждой из  " + stringArrayList.size() + " фамилий в заданном массиве:\n");
                Collections.sort(stringArrayList);
                for (String surname : arrUniqueSurnames) {
                        result.append(surname + ": " + Collections.frequency(stringArrayList, surname) + "\n");
                }
                return result.toString();
        }
}




//        Surname surname = new Surname("Иванов");
//
//        List<Surname> surnameList = new ArrayList<>();
//        surnameList.add(new Surname("Иванов"));
//        surnameList.add(new Surname("Петров"));
//        surnameList.add(new Surname("Соколов"));
//        surnameList.add(new Surname("Хорьков"));
//        surnameList.add(new Surname("Волков"));
//        surnameList.add(new Surname("Иванов"));
//        surnameList.add(new Surname("Сусликов"));
//        surnameList.add(new Surname("Бобров"));
//        surnameList.add(new Surname("Соколов"));
//        surnameList.add(new Surname("Медведев"));
//        surnameList.add(new Surname("Орлов"));
//        surnameList.add(new Surname("Иванов"));
//
//        surnameList.add(surname);
//
//
//        List<String> listString = new ArrayList<>();
//        listString.add("Иванов");
//        listString.add("Петров");
//        listString.add("Соколов");
//        listString.add("Хорьков");
//        listString.add("Волков");
//        listString.add("Иванов");
//        listString.add("Сусликов");
//        listString.add("Бобров");
//        listString.add("Соколов");
//        listString.add("Медведев");
//        listString.add("Орлов");
//        listString.add("Иванов");
//
//        System.out.println(">>>>>>>>>>");
//        //System.out.println(listString);
//        Collections.sort(listString);
//        System.out.println(listString);
//
//        System.out.println(">>> Collections.frequency(arr, object) - проверка на одинаковые значения");
//        int frequency1 = Collections.frequency(listString, "Иванов");
//        System.out.println(frequency1);
//        System.out.println(">>>>>>>>>>");
//
//
//        System.out.println(">>>>>>>>>>");
//        System.out.println(surnameList.isEmpty());
//
//        System.out.println(surnameList.indexOf(surname));
//
//        System.out.println(surnameList);
//        System.out.println(">>>>>>>>>>");
//
//        int frequency2 = Collections.frequency(surnameList, "Иванов");
//        System.out.println(frequency2);
//
//        System.out.println(surnameList.contains(surname));
//    }
//}
