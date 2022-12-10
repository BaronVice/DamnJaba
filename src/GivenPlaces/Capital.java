package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.EmptyPlacesException;
import GivenPlaces.Utilits.CustomExceptions.EmptyStringException;
import GivenPlaces.Utilits.CustomExceptions.NotExistingCommandException;
import GivenPlaces.Utilits.Interaction;

import java.security.cert.CertPath;
import java.util.HashSet;
import java.util.Set;

public class Capital extends City {
    private static final Set<Capital> places = new HashSet<>();


    public Capital(String name, String description){
        super(name, description);
    }

    public static class CapitalInteraction extends Interaction {
        public static void handleOption(String option) throws EmptyStringException, EmptyPlacesException, NotExistingCommandException {
            System.out.println(
                    switch (option) {
                        case "Создать" -> createObject();
                        case "Удалить" -> deleteObject(places);
                        case "Изменить" -> changeObject(places);
                        case "Вызвать" -> callObject();
                        case "Показать" -> showObjects(places);
                        default -> throw new NotExistingCommandException(
                                String.format("Системная ошибка: команда \"%s\" не обрабатывается", option));
                    }
            );
        }
        private static String createObject() throws EmptyStringException {
            String name = handleName();
            places.add(new Capital(name, handleDescription()));
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }
        private static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            return "call capitalInteraction";
        }
    }

    public static void buildObject(String name, String description){
        Capital.places.add(new Capital(name, description));
    }

    public static String getPlaceType() {
        return "Столица";
    }
}
