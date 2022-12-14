import GivenPlaces.Utilits.*;
import GivenPlaces.Utilits.CustomExceptions.NotExistingCommandException;


// TODO: здесь прикрутить создание потока для чтения прошлых результатов
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