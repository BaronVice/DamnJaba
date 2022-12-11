package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.HashSet;
import java.util.Set;

public class City extends Place {
    protected int population;
    protected double square;
    private static final Set<City> places = new HashSet<>();

    public City(String name, String description){
        super(name, description);
    }

    public static class CityInteraction extends Interaction {
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
            places.add(new City(name, handleDescription()));
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }

        private static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            return "call cityInteraction";
        }
    }

    public static String getPlaceType() {
        return "Город";
    }

    public int getPopulation() {
        return population;
    }
    // Проверка на int и не ноль
    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquare() {
        return square;
    }
    // Проверка на double и не ноль
    public void setSquare(double square) {
        this.square = square;
    }
}
