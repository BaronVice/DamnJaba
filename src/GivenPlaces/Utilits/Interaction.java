package GivenPlaces.Utilits;

import java.util.Scanner;

public class Interaction {
    public static Review collectReview(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Имя пользователя: ");
        String userName = scan.nextLine();
        System.out.println("Оценка: ");
        int mark = inputMark();
    }
    // TODO: сделать исключение - оценка от 1 до 5
    private static int inputMark(){
        Scanner scan = new Scanner(System.in);
        try{
            mark = scan.nextInt();
            return mark;
        }
        catch (Exception e){
            System.out.println("Оценка - целое число");
        }
    }


}
