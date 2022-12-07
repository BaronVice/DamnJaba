package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.EmptyPlacesException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Region extends Place {
    private static Set<Region> places = new HashSet<>();

    private List<City> cities = new ArrayList<>();

    public Region(String name, String description){
        super(name, description);
    }

    public static class RegionInteraction extends Interaction{
        private static String callObject() throws EmptyPlacesException {
            emptyPlaces();
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
