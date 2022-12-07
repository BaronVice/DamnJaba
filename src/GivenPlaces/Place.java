package GivenPlaces;


import GivenPlaces.Utilits.CustomExceptions.*;
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
        protected static String handleName() throws EmptyStringException {
            System.out.print("Название: ");
            String name = scan.nextLine();

            if (name.trim().isEmpty())
                throw new EmptyStringException("название не может быть пустым");
            name = name.substring(0,1).toUpperCase() + name.substring(1);

            return name;
        }
        protected static String handleDescription() {
            System.out.print("Описание: ");
            String description = scan.nextLine();

            if (description.trim().isEmpty())
                description = "Описание отсутствует";

            return description;
        }
        protected static String createObject() throws EmptyStringException{

            String name = handleName();
            String description = handleDescription();

            buildObject(name, description);
            return String.format("Новое место \"%s %s\" успешно добавлено", getPlaceType(), name);
        }
        protected static String deleteObject() throws EmptyPlacesException {
            emptyPlaces();
            String message = "Выбранное место не найдено";

            System.out.print("Название места для удаления: ");
            String toFind = scan.nextLine();
            if (places.removeIf(place -> place.name.equals(toFind)))
                message = "Выбранное место успешно удалено";

            return message;
        }
        // TODO: проверить на корректность вывода в случае неверной команды
        protected static String changeObject() throws EmptyPlacesException, EmptyStringException {
            emptyPlaces();
            String message = "Выбранное место не найдено";

            System.out.println("""
                1. Изменить название
                2. Изменить описание
                Выбор:\040""");
            String option = scan.nextLine();

            switch (option) {
                case "1", "2" -> {
                    System.out.print("Название места для изменения: ");
                    String toFind = scan.nextLine();

                    for (Place place : places) {
                        if (place.name.equals(toFind)) {
                            if (option.equals("1"))
                                place.name = handleName();
                            else
                                place.description = handleDescription();
                        }
                    }
                }
                default -> {
                    System.out.println("Неверно заданная команда. Попробуйте еще раз");
                    changeObject();
                }
            }

            return message;
        }
        private static String callObject() throws EmptyPlacesException {
            emptyPlaces();
            return "вызвано";
            // Сделать описание, что умеет объект
        }
    }

    protected static StringBuilder showObjects(){
        StringBuilder message = new StringBuilder();
        for (Place place : places)
            message.append(place.toString());

        return message;
    }

    private static String getPlaceType(){
        return "Место";
    };

    protected static void emptyPlaces() throws EmptyPlacesException {
        if (places.size() == 0)
            throw new EmptyPlacesException("Удалять нечего - список пуст");
    }

    protected static void buildObject(String name, String description){}


    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
