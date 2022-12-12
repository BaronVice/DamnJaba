package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.HashSet;
import java.util.Set;

public class Region extends Place {
    private static final Set<Region> places = new HashSet<>();

    private final Set<City> cities = new HashSet<>();

    public Region(String name, String description){
        super(name, description);
    }

    public static Set<Region> getRegions(){
        return places;
    }

    public static String getPlaceType() {
        return "Регион";
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

        private static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            return "call regionInteraction";
        }
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

    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
