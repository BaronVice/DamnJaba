package GivenPlaces.Utilits;

import java.util.ArrayList;
import java.util.List;

public class Place {
    protected double latitude;
    protected double longitude;
    protected String name;
    protected String description;
    protected List<Review> reviews = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void showCoordinates(){
        System.out.println(String.format("Latitude: %f\nLongitude: %f", latitude, longitude));
    }

    public void addReview(){

    }

    public String toString(){
        return String.format("Название: %s\nОписание: %s", name, description);
    }
}
