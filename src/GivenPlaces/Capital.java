package GivenPlaces;

public class Capital extends City {

    public Capital(String name, String description){
        super(name, description);
    }

    public static class CapitalInteraction extends Interaction{

    }

    public static void buildObject(String name, String description){
        places.add(new Capital(name, description));
    }

    public static String getPlaceType() {
        return "Столица";
    }
}
