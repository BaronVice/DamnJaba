package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.EmptyPlacesException;
import GivenPlaces.Utilits.CustomExceptions.EmptyStringException;
import GivenPlaces.Utilits.CustomExceptions.NotExistingCommandException;
import GivenPlaces.Utilits.Interaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Region extends Place {
    private static final Set<Region> places = new HashSet<>();

    private Set<City> cities = new HashSet<>();

    public Region(String name, String description){
        super(name, description);
    }

    public static class RegionInteraction extends Interaction {
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
            places.add(new Region(name, handleDescription()));
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }

        public static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            return "call regionInteraction";
        }
    }

    public static void buildObject(String name, String description){
        places.add(new Region(name, description));
    }

    public static String getPlaceType() {
        return "Регион";
    }

    public void addCityToRegion(City city){
        cities.add(city);
    }
    public void removeCityFromRegion(City city){
        cities.remove(city);
    }

    public int calculatePopulation(){
        int totalPopulation = 0;
        for (City city : cities)
            totalPopulation += city.getPopulation();

        return totalPopulation;
    }

    public int calculateSquare(){
        int totalSquare = 0;
        for (City city : cities)
            totalSquare += city.getSquare();

        return totalSquare;
    }

}
