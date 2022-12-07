import GivenPlaces.Utilits.*;
import GivenPlaces.Utilits.CustomExceptions.NotExistingCommandException;

import java.io.IOException;

/* TODO: для города, столицы и региона добавить население, подумать о переносе отзывов к функционалу локации
*   В Place можно положить страну
*    В регионе можно сделать список городов и сумму площадей исходя из площади городов
*     Для столицы сложно что-то придумать
*      Как вариант сделать класс для записи и чтения мест  */
public class Main {
    public static void main(String[] args) {
        try{
            Menu.mainMenu();
        }
        catch (NotExistingCommandException e){
            e.printStackTrace();
        }

    }
}