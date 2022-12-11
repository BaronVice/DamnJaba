package GivenPlaces.Utilits;

import GivenPlaces.Place;
import GivenPlaces.Utilits.CustomExceptions.*;

import java.util.Scanner;
import java.util.Set;

public abstract class Interaction {
    protected static Scanner scan = new Scanner(System.in);

    protected static void emptyPlaces(Set<? extends Place> places) throws EmptyPlacesException {
        if (places.size() == 0)
            throw new EmptyPlacesException("Удалять нечего - список пуст");
    }

    protected static String handleName() throws EmptyStringException {
        System.out.print("Название: ");
        String name = scan.nextLine().trim();

        if (name.isEmpty())
            throw new EmptyStringException("название не может быть пустым");
        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        return name;
    }

    protected static String handleDescription() {
        System.out.print("Описание: ");
        String description = scan.nextLine().trim();

        if (description.isEmpty())
            description = "Описание отсутствует";

        return description;
    }

    protected static void handleChange(Place place) throws EmptyStringException {
        System.out.printf("""
                Текущее место:
                %s
                                    
                1. Изменить имя
                2. Изменить описание
                Выбор:\040""", place.getName()
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

    protected static String deleteObject(Set<? extends Place> places) throws EmptyPlacesException {
        emptyPlaces(places);
        String message = "Выбранное место не найдено";

        System.out.print("Название места для удаления: ");
        String toFind = scan.nextLine();
        if (places.removeIf(place -> place.getName().equals(toFind)))
            message = "Выбранное место успешно удалено";

        return message;
    }

    protected static String changeObject(Set<? extends Place> places) throws EmptyPlacesException, EmptyStringException {
        emptyPlaces(places);
        String message = "Выбранное место не найдено";

        System.out.print("Название места для изменения: ");
        String toFind = scan.nextLine();
        for (Place place : places)
            if (place.getName().equals(toFind)) {
                handleChange(place);
                message = "Выбранное место успешно изменено";
            }


        return message;
    }

    protected static StringBuilder showObjects(Set<? extends Place> places) throws EmptyPlacesException {
        emptyPlaces(places);
        StringBuilder message = new StringBuilder();
        for (Place place : places)
            message.append(place.toString());

        return message;
    }
}

