package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.EmptyPlacesException;

import java.util.HashSet;
import java.util.Set;

public class City extends Place {
    private int population;
    private double square;
    private static Set<Location> places = new HashSet<>();


    public City(String name, String description){
        super(name, description);
    }

    public static class CityInteraction extends Interaction{
        private static String callObject() throws EmptyPlacesException {
            emptyPlaces();
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
