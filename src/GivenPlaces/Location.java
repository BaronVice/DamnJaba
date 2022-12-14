package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.*;

public class Location extends Place {
    private static final HashMap<String, Location> places = new HashMap<>();

    public Location(String name, String description){
        super(name, description);
    }

    public static String getPlaceType() {
        return "Локация";
    }


    public static class LocationInteraction extends Interaction {
        public static void handleOption(String option) throws EmptyStringException, EmptyPlacesException, NotExistingCommandException {
            System.out.println(
                    switch (option) {
                        case "Создать" -> createObject();
                        case "Удалить" -> deleteObject(places);
                        case "Изменить" -> changeObject(places);
                        case "Вызвать" -> callObject();
                        case "Показать" -> showObjects(places);
                        default -> throw new NotExistingCommandException(
                                String.format("Системная ошибка: команда \"%s\" не обрабатывается", option));
                    }
            );
        }

        private static String createObject() throws EmptyStringException {
            String name = handleName();
            places.put(name, new Location(name, handleDescription()));
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }

        private static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            // TODO: обработать имя, вывести возможные действия
            return "Juj";
        }
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
