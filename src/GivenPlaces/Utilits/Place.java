package GivenPlaces.Utilits;


import java.util.ArrayList;
import java.util.List;

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
    protected static List<String> placesName = new ArrayList<>();

    public static class Interaction{
        public static String handleName(String name) throws EmptyStringException{
            if (name.trim().isEmpty())
                throw new EmptyStringException("имя не может быть пустым");

            name = name.substring(0,1).toUpperCase() + name.substring(1);

            return name;
        }
        public static String handleDescription(String description) {

            if (description.trim().isEmpty())
                description = "Описание отсутствует";

            return description;
        }
        public static String createObject(){
            // Запрашиваю имя, описание. Если успешно, то добавляю имя в existingPlaces
            // Из вне создаю объект класса
            return "создано";
        }
        public static String deleteObject(){
//            if (emptyPlaces()){
//                return "Сейчас это сделать невозможно, поскольку объекты этого класса еще не созданы";
//            }
            return "удалено";
        }
        public static String changeObject(){
            if (emptyPlaces()){

            }
            return "изменено";
            // Сделать описание, что можно изменить
        }
        public static String callObject(){
            if (emptyPlaces()){

            }
            return "вызвано";
            // Сделать описание, что умеет объект
        }
    }

    public abstract String getPlaceType();

    public static boolean emptyPlaces(){
        return placesName.size() == 0;
    }

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
        return String.format("%s: %s\nОписание: %s", getPlaceType(), name, description);
    }
}
