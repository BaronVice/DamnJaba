package GivenPlaces;

import GivenPlaces.Utilits.Place;
import GivenPlaces.Utilits.Review;

import java.util.ArrayList;
import java.util.List;

public class Location extends Place {
    protected List<Review> reviews = new ArrayList<>();

    public String getPlaceType() {
        return "Локация";
    }
    public void addReview(){
        // Вызов добавления отзыва
    }
}
