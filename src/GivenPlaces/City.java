package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.HashMap;
import java.util.InputMismatchException;


public class City extends Place {
    protected int population;
    protected String regionAttachment;
    private static final HashMap<String, City> places = new HashMap<>();

    public City(String name, int population, String description, String regionAttachment){
        this.name = name;
        this.population = population;
        this.description = description;
        this.regionAttachment = regionAttachment;
    }
    public static HashMap<String, City> getCities(){
        return places;
    }

    public static String getPlaceType() {
        return "Город";
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getRegionAttachment(){
        return regionAttachment;
    }
    public void setRegionAttachment(String regionAttachment){
        this.regionAttachment = regionAttachment;
    }


    public static class CityInteraction extends Interaction {
        protected static int handlePopulation(){
            System.out.print("Население: ");
            try {
                int population = scan.nextInt();
                if (population < 1)
                    throw new NegativePopulationException();

                return population;
            }
            catch (InputMismatchException | NegativePopulationException e){
                System.out.println("Население должно быть целым числом больше 0");
                scan.next();
                return handlePopulation();
            }
        }
        protected static String handleRegion(){
            System.out.printf("""
                    Доступные регионы: %s
                    Название региона, которому принадлежит город:\040""",
                    String.join(", ", Region.getRegions().keySet()));

            String regionName = scan.nextLine();
            if (Region.getRegions().containsKey(regionName))
                return regionName;
            else{
                System.out.println("Регион не найден. Выберите из списка доступных регионов");
                return handleCityToRegion();
            }
        }
        protected static String handleCityToRegion(){
            try{
                emptyPlaces(Region.getRegions());
            }
            catch (EmptyPlacesException e){
                return "Не принадлежит какому-либо региону";
            }

            System.out.print("""
                Город принадлежит региону?
                1. Да
                2. Нет
                Выбор:\040"""
            );
            String choice = scan.nextLine();
            if ("1".equals(choice)) {
                return handleRegion();
            }
            else if ("2".equals(choice)) {
                return "Не принадлежит какому-либо региону";
            }
            else {
                System.out.println("Неверно заданная команда. Попробуйте еще раз");
                return handleCityToRegion();
            }
        }
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
        protected static String createObject() throws EmptyStringException {
            City createdCity = new City(handleName(), handlePopulation(), handleDescription(), handleCityToRegion());

            if (!createdCity.getRegionAttachment().equals("Не принадлежит какому-либо региону"))
                Region.attachCityToRegion(createdCity);

            places.put(createdCity.getName(), createdCity);
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), createdCity.getName());
        }

        protected static String deleteCity() throws EmptyPlacesException {
            emptyPlaces(places);
            String message = "Выбранное место не найдено";

            System.out.print("Название места для удаления: ");
            String name = scan.nextLine().toLowerCase();

            if (places.containsKey(name)) {
                Region.unattachCityFrom(places.get(name));
                places.remove(name);
                message = "Выбранное место успешно удалено";
            }

            return message;
        }

    }

    public String toString(){
        return String.format("%s: %s\nНаселение: %d\nОписание: %s\nРегион: %s\n", getPlaceType(), name, population, description, regionAttachment);
    }
}
