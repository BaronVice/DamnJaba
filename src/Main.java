import GivenPlaces.Location;
import GivenPlaces.Utilits.*;

/* TODO: для города, столицы и региона добавить население, подумать о переносе отзывов к функционалу локации
*   В Place можно положить страну
*    В регионе можно сделать список городов и сумму площадей исходя из площади городов
*     Для столицы сложно что-то придумать
*      Как вариант сделать класс для записи и чтения мест  */
public class Main {
    public static void main(String[] args) {
        Location place1 = new Location();

        try {
            place1.setName("          ");
            place1.setDescription("I live here");
        }
        catch (EmptyStringException e){
            System.out.println("Имя не может быть пустым");
        }


        System.out.println(place1);
    }
}