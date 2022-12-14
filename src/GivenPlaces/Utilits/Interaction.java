package GivenPlaces.Utilits;

import GivenPlaces.Location;
import GivenPlaces.Place;
import GivenPlaces.Utilits.CustomExceptions.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public abstract class Interaction {
    protected static Scanner scan = new Scanner(System.in);
    private static String toHandle;

    public static String capitalize(String name){
        toHandle = name.trim();
        return toHandle.substring(0, 1).toUpperCase() + toHandle.substring(1);
    }

    protected static void emptyPlaces(HashMap<String, ? extends Place> places) throws EmptyPlacesException {
        if (places.size() == 0)
            throw new EmptyPlacesException("Удалять нечего - список пуст");
    }

    protected static String handleName() throws EmptyStringException {
        System.out.print("Название: ");
        String name = scan.nextLine().trim();

        if (name.isEmpty())
            throw new EmptyStringException("название не может быть пустым");

        name = capitalize(name);
        return name;
    }

    protected static String handleDescription() {
        System.out.print("Описание: ");
        String description = scan.nextLine().trim();

        if (description.isEmpty())
            description = "Описание отсутствует";

        description = capitalize(description);
        return description;
    }

    protected static void handleChange(Place place) throws EmptyStringException {
        System.out.printf("""
                Текущее место:
                %s
                1. Изменить имя
                2. Изменить описание
                Выбор:\040""", place.toString()
        );

        switch (scan.nextLine()) {
            case "1" -> place.setName(handleName());
            case "2" -> place.setDescription(handleDescription());
            default -> {
                System.out.println("Неверно заданная команда. Попробуйте еще раз");
                handleChange(place);
            }
        }
    }

    protected static String deleteObject(HashMap<String, ? extends Place> places) throws EmptyPlacesException {
        emptyPlaces(places);
        String message = "Выбранное место не найдено";

        System.out.print("Название места для удаления: ");
        toHandle = scan.nextLine().toLowerCase();
        if (places.containsKey(toHandle)){
            places.remove(toHandle);
            message = "Выбранное место успешно удалено";
        }

        return message;
    }

    protected static String changeObject(HashMap<String, ? extends Place> places) throws EmptyPlacesException, EmptyStringException {
        emptyPlaces(places);
        String message = "Выбранное место не найдено";

        System.out.print("Название места для изменения: ");
        toHandle = scan.nextLine().toLowerCase();

        if (places.containsKey(toHandle)){
            handleChange(places.get(toHandle));
            message = "Выбранное место успешно изменено";
        }

        return message;
    }

    protected static StringBuilder showObjects(HashMap<String, ? extends Place> places) throws EmptyPlacesException {
        emptyPlaces(places);
        StringBuilder message = new StringBuilder();
        for (Place place : places.values())
            message.append(place.toString());

        return message;
    }
}

