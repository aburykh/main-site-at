package ru.geekbrains.exceptions.checked;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static java.lang.Thread.sleep;

public class FileNotFoundExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Блок try");
            new FileReader(new File("путь к файлу"));
        } catch (FileNotFoundException e) {
            System.out.println("Блок catch");
            e.printStackTrace();
        } finally {
            sleep(100);
            System.out.println("Блок finally");
        }
        sleep(10);
        System.out.println("!!!!");
    }
}