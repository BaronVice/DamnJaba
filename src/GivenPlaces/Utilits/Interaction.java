package GivenPlaces.Utilits;

import java.util.Scanner;

/* TODO: попробовать создание вкрутить в конструктор класса, изменение и взаимодействие отдельными методами в классы */
public class Interaction {
    private static Scanner scan = new Scanner(System.in);

    private static String inputChoice(){
        return scan.nextLine();
    }

    private static void showMenuDescription(String option){
        System.out.printf("""
                1. %1$s локацию
                2. %1$s город
                3. %1$s столицу
                4. %1$s регион
                5. Назад""", option);
    }

    private static void interactWithObject(String option){
        showMenuDescription(option);
        String placeType = scan.nextLine();

        switch (option) {
            case "Создать" -> createObject(placeType);
            case "Удалить" -> deleteObject(placeType);
            case "Изменить" -> changeObject(placeType);
            case "Вызвать" -> callObject(placeType);
        }
    }

    private static void showObjectDescription(){

    }

    public static void mainMenu(){
        System.out.println("""
                1. Создать объект
                2. Удалить объект
                3. Изменить объект
                4. Взаимодействие с объектом
                5. Выход""");

        switch (inputChoice()) {
            case "1" -> interactWithObject("Создать");
            case "2" -> interactWithObject("Удалить");
            case "3" -> interactWithObject("Изменить");
            case "4" -> interactWithObject("Вызвать");
            case "5" -> System.exit(0);
            default -> System.out.println("Неверно заданная команда. Попробуйте еще раз");
        }

        mainMenu();
    }
}
