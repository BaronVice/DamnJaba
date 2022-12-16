package GivenPlaces;


import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;
import GivenPlaces.Utilits.PlaceHandlers;

import java.util.HashMap;

// Здесь все почти тоже, что и в городе
public class Capital extends City implements PlaceHandlers {

    private static final HashMap<String, City> places = new HashMap<>();

    public Capital(String name, int population, String description, String regionAttachment){
        super(name, population, description, regionAttachment);
    }

    public static String getPlaceType() {
        return "Столица";
    }

    public static class CapitalInteraction extends CityInteraction{
        public static void handleOption(String option) throws EmptyStringException, EmptyPlacesException, NotExistingCommandException {
            System.out.println(
                    switch (option) {
                        case "Создать" -> createObject();
                        case "Удалить" -> deleteCity();
                        case "Изменить" -> changeObject(places);
                        case "Показать" -> showObjects(places);
                        default -> throw new NotExistingCommandException(
                                String.format("Системная ошибка: команда \"%s\" не обрабатывается", option));
                    }
            );
        }
        private static String createObject() throws EmptyStringException, EmptyPlacesException {
            Capital createdCapital = new Capital(handleName(), handlePopulation(), handleDescription(), handleCityToRegion());

            if (!createdCapital.getRegionAttachment().equals("Не принадлежит какому-либо региону"))
                Region.attachCityToRegion(createdCapital);

            places.put(createdCapital.getName(), createdCapital);
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), createdCapital.getName());
        }
    }

    public void handleHashMapChange() throws EmptyStringException {
        String oldName = this.name;
        setName(Interaction.handleName());

        places.put(this.name, places.remove(oldName));
    }

    public String toString(){
        return String.format("%s: %s\nНаселение: %d\nОписание: %s\nРегион: %s\n", getPlaceType(), name, population, description, regionAttachment);
    }
}
