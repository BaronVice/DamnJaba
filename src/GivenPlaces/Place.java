package GivenPlaces;


import GivenPlaces.Utilits.CustomExceptions.EmptyPlacesException;
import GivenPlaces.Utilits.CustomExceptions.EmptyStringException;
import GivenPlaces.Utilits.CustomExceptions.NotExistingCommandException;
import GivenPlaces.Utilits.InteractionOperations;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


/* TODO: сделать проверки в сетерах: на непустые имена и описания, на парс в double
*   Идеи: сделать базу с пользователями, комменатрии можно оставлять если пользователь существует,
*   Можно использовать дату и время для отзыва
*         */
public abstract class Place {
    // Имя места
    protected String name;
    // Описание места
    protected String description;
    // Все существующие имена мест
    protected static Set<Place> places = new HashSet<>();
    protected static Scanner scan = new Scanner(System.in);

    public Place(String name, String description){
        this.name = name;
        this.description = description;
    }

    protected static class Interaction implements InteractionOperations {

        public static void handleOption(String option) throws EmptyStringException, EmptyPlacesException, NotExistingCommandException {
            System.out.println(
                switch (option) {
                    case "Создать" -> createObject();
                    case "Удалить" -> deleteObject();
                    case "Изменить" -> changeObject();
                    case "Вызвать" -> callObject();
                    case "Показать" -> showObjects();
                    default -> throw new NotExistingCommandException(
                            String.format("Системная ошибка: команда \"%s\" не обрабатывается", option));
                }
            );
        }
        private static String handleName(String name) throws EmptyStringException {
            if (name.trim().isEmpty())
                throw new EmptyStringException("название не может быть пустым");

            name = name.substring(0,1).toUpperCase() + name.substring(1);

            return name;
        }
        private static String handleDescription(String description) {

            if (description.trim().isEmpty())
                description = "Описание отсутствует";

            return description;
        }
        private static String createObject() throws EmptyStringException{

            System.out.print("Название: ");
            String name = handleName(scan.nextLine());

            System.out.print("\nОписание: ");
            String description = handleDescription(scan.nextLine());

            buildObject(name, description);
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }
        private static String deleteObject() throws EmptyPlacesException {
            emptyPlaces();
            return "Объект успешно удален";
        }
        private static String changeObject() throws EmptyPlacesException {
            emptyPlaces();
            return "изменено";
            // Сделать описание, что можно изменить
        }
        private static String callObject() throws EmptyPlacesException {
            emptyPlaces();
            return "вызвано";
            // Сделать описание, что умеет объект
        }
    }

    private static StringBuilder showObjects(){
        StringBuilder message = new StringBuilder();
        for (Place place : places)
            message.append(place.toString());

        return message;
    }

    private static String getPlaceType(){
        return "Место";
    };

    private static void emptyPlaces() throws EmptyPlacesException {
        if (places.size() == 0)
            throw new EmptyPlacesException("Удалять нечего - список пуст");
    }

    private static void buildObject(String name, String description){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
