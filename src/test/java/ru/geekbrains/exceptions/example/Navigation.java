package ru.geekbrains.exceptions.example;

import ru.geekbrains.main.site.at.Page;

public class Navigation {

    //123
    public Page clickButton(String nameButton) throws NotFoundPageException {
        switch (nameButton){
            case "Курсы":{
                //return new Page(1);
                throw new RuntimeException("Страница " + nameButton + " не найдена!");
            } default:{
                throw new NotFoundPageException("Страницы: "+nameButton+" не существует!");
            }
        }

    }
}