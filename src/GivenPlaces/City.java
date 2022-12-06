package GivenPlaces;

import GivenPlaces.Utilits.Place;

public class City extends Place {
    private int population;
    private double square;

    public String getPlaceType() {
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
