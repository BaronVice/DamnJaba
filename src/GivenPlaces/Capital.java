package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.HashSet;
import java.util.Set;


// TODO: Может здесь вообще все убрать и добавить лишь маленькую особенность?
public class Capital extends City {
    private static final Set<Capital> places = new HashSet<>();

    public Capital(String name, String description, String regionAttachment){
        super(name, description, regionAttachment);
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

    public static String getPlaceType() {
        return "Столица";
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
