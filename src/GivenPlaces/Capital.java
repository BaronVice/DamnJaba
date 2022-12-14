package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.HashSet;
import java.util.Set;


// TODO: Может здесь вообще все убрать и добавить лишь маленькую особенность?
public class Capital extends City {
    private final boolean isCapital = true;

    public Capital(String name, int population, String description, String regionAttachment){
        super(name, population, description, regionAttachment);
    }

    public static class CapitalInteraction extends CityInteraction {

    }

    public static String getPlaceType() {
        return "Столица";
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
