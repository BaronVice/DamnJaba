import GivenPlaces.Utilits.*;
import GivenPlaces.Utilits.CustomExceptions.NotExistingCommandException;


public class Main {
    public static void main(String[] args) {
        // Вызов меню, ловим системные ошибки (те, что мог допустить разработчик)
        try{
            Menu.mainMenu();
        }
        catch (NotExistingCommandException e){
            e.printStackTrace();
        }

    }
}