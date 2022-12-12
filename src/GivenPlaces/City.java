package GivenPlaces;

import GivenPlaces.Utilits.CustomExceptions.*;
import GivenPlaces.Utilits.Interaction;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class City extends Place {
    protected int population;
    protected double square;
    protected String regionAttachment;
    private static final Set<City> places = new HashSet<>();

    public City(String name, String description, String regionAttachment){
        this.name = name;
        this.description = description;
        this.regionAttachment = regionAttachment;
    }

    public static String getPlaceType() {
        return "Город";
    }

    public int getPopulation() {
        return population;
    }
    // Проверка на int и не ноль
    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquare() {
        return square;
    }
    // Проверка на double и не ноль
    public void setSquare(double square) {
        this.square = square;
    }

    public static class CityInteraction extends Interaction {
        protected static String handleRegion(){
            System.out.printf("""
                    Доступные регионы: %s
                    Название региона, которому принадлежит город:\040
                    """, Region.getRegions().stream().map(Place::getName).collect(Collectors.joining(", ")));

            String regionName = scan.nextLine();
            if (existsInSet(Region.getRegions(), regionName))
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
                        case "Удалить" -> deleteObject(places);
                        case "Изменить" -> changeObject(places);
                        case "Вызвать" -> callObject();
                        case "Показать" -> showObjects(places);
                        default -> throw new NotExistingCommandException(
                                String.format("Системная ошибка: команда \"%s\" не обрабатывается", option));
                    }
            );
        }
        // TODO: возможно потребуется поменять с private на protected из-за handleDescription
        protected static String createObject() throws EmptyStringException {
            City createdCity = new City(handleName(), handleDescription(), handleCityToRegion());
            places.add(createdCity);
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), createdCity.getName());
        }

        protected static String callObject() throws EmptyPlacesException {
            emptyPlaces(places);
            return "call cityInteraction";
        }
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s\nРегион: %s\n", getPlaceType(), name, description, regionAttachment);
    }
}
