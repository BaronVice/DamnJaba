import GivenPlaces.Location;
import GivenPlaces.Utilits.Place;

public class Main {
    public static void main(String[] args) {
        Location place1 = new Location();

        place1.setName("Home");
        place1.setDescription("I live here");

        System.out.println(place1);
    }
}