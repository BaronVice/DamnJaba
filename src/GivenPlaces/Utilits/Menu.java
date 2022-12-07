package GivenPlaces.Utilits;

import GivenPlaces.*;
import GivenPlaces.Utilits.CustomExceptions.EmptyPlacesException;
import GivenPlaces.Utilits.CustomExceptions.EmptyStringException;
import GivenPlaces.Utilits.CustomExceptions.NotExistingCommandException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Научиться хранить тип класса
public class Menu {

    private static Scanner scan = new Scanner(System.in);

    private static String inputChoice(){
        return scan.nextLine();
    }

    private static void interactWithObject(String option) throws NotExistingCommandException {
        boolean goBack = false;
        System.out.printf("""
                1. %1$s локацию
                2. %1$s город
                3. %1$s столицу
                4. %1$s регион
                5. Назад""", option);
        try {
            switch (inputChoice()) {
                case "1" -> Location.LocationInteraction.handleOption(option);
                case "2" -> City.CityInteraction.handleOption(option);
                case "3" -> Capital.CapitalInteraction.handleOption(option);
                case "4" -> Region.RegionInteraction.handleOption(option);
                case "5" -> goBack = true;
                default -> System.out.println("Неверно заданная команда. Попробуйте еще раз");
            }
        }
        catch (EmptyStringException e){
            System.out.println("Название не может быть пустым");
        }
        catch (EmptyPlacesException e){
            System.out.println(String.format("Пока что нету таких мест, которые можно было бы %s", option.toLowerCase()));
        }

        if (goBack)
            mainMenu();
        else
            inputChoice();

    }


    public static void mainMenu() throws NotExistingCommandException {
        System.out.println("""
                1. Создать объект
                2. Удалить объект
                3. Изменить объект
                4. Взаимодействие с объектом
                5. Посмотреть все существующие объекты
                6. Выход""");

        switch (inputChoice()) {
            case "1" -> interactWithObject("Создать");
            case "2" -> interactWithObject("Удалить");
            case "3" -> interactWithObject("Изменить");
            case "4" -> interactWithObject("Вызвать");
            case "5" -> interactWithObject("Показать");
            case "6" -> System.exit(0);
            default -> System.out.println("Неверно заданная команда. Попробуйте еще раз");
        }

        mainMenu();
    }
}
