package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.HashMap;

public class Region extends Place {
    private static final HashMap<String, Region> places = new HashMap<>();

    private final HashMap<String, City> cities = new HashMap<>();

    public Region(String name, String description){
        super(name, description);
    }

    public static HashMap<String, Region> getRegions(){
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
            places.put(name, new Region(name, handleDescription()));
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }

        private static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            System.out.print("Название места для взаимодействия: ");
            Region chosen;

            return "Juj";
        }
    }

    public static Region getRegion(City city){
        return places.get(city.getRegionAttachment());
    }

    public static void attachCityToRegion(City city){
        getRegion(city).addCityToRegion(city);
    }
    public static void unattachCityFrom(City city) {getRegion(city).removeCityFromRegion(city);}

    public void addCityToRegion(City city){
        cities.put(city.getName(), city);
    }
    public void removeCityFromRegion(City city){
        cities.remove(city.getName());
    }

    public int calculatePopulation(){
        int totalPopulation = 0;
        for (City city : cities.values())
            totalPopulation += city.getPopulation();

        return totalPopulation;
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
