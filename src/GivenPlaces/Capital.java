package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.EmptyPlacesException;

import java.security.cert.CertPath;
import java.util.HashSet;
import java.util.Set;

public class Capital extends City {
    private static Set<Capital> places = new HashSet<>();


    public Capital(String name, String description){
        super(name, description);
    }

    public static class CapitalInteraction extends Interaction{
        private static String callObject() throws EmptyPlacesException {
            emptyPlaces();
            return "call capitalInteraction";
        }
    }

    public static void buildObject(String name, String description){
        places.add(new Capital(name, description));
    }

    public static String getPlaceType() {
        return "Столица";
    }
}
