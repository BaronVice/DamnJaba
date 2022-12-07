package GivenPlaces;

public class City extends Place {
    private int population;
    private double square;

    public City(String name, String description){
        super(name, description);
    }

    public static class CityInteraction extends Interaction{

    }

    public static void buildObject(String name, String description){
        places.add(new City(name, description));
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
