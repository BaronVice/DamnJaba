package GivenPlaces;

import GivenPlaces.Utilits.Review;

import java.util.ArrayList;
import java.util.List;

public class Location extends Place {
    protected List<Review> reviews = new ArrayList<>();

    public Location(String name, String description){
        super(name, description);
    }

    public static class LocationInteraction extends Interaction{

    }

    public static void buildObject(String name, String description){
        places.add(new Location(name, description));
    }

    public static String getPlaceType() {
        return "Локация";
    }
    public void addReview(){
        // Вызов добавления отзыва
    }
}
