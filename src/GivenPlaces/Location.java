package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;
import GivenPlaces.Utilits.Review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Location extends Place {
    private final List<Review> reviews = new ArrayList<>();
    private static final Set<Location> places = new HashSet<>();

    public Location(String name, String description){
        super(name, description);
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

        public static String createObject() throws EmptyStringException {
            String name = handleName();
            places.add(new Location(name, handleDescription()));
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }

        public static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            return "call locationInteraction";
        }
    }

    public static String getPlaceType() {
        return "Локация";
    }
    public void addReview(){
        // Вызов добавления отзыва
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
