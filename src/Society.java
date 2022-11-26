import java.util.ArrayList;
import java.util.List;

/* TODO: Написать class Stuff, который будет организовывать работу сотрудников.
*   У каждого сотрудника есть имя, возраст, стаж.
*    Сотрудник умеет работать n часов, после которых получает k монет (k = n * стаж)
*     Сотрудник умеет пить кофе из офисного автомата
*      (Кофе бесплатный для сотрудников, но на каждую порцию компания тратит 3 монеты)
*       -
*        Сделать два конструктора: принимающий имя, принимающий имя и возраст.
*         -
*          У компании есть особенность: она берет только сотрудников 18 лет, за стаж возьмем формулу "возраст - 17"
*           -
*            В классе Stuff создать статическое поле для хранения затрат компании (выплата зарплат и кофе)*/

public class Society {
    public static void main(String[] args) {

        Human person1 = new Human("Олег", 69);
        Human person2 = new Human();
        Human person3 = new Human("Игорь");

        Human.addMember(person1);
        Human.addMember(person2);
        Human.addMember(person3);

        Human.showSocietyMembersNames();

    }
}

class Human{

    private static List<Human> societyMembers = new ArrayList<>();
    private String name;
    private int age;
    private int metersWalked = 0;

    public Human(){
        name = "Женя";
        age = 0;
    }

    public Human(String name){
        this.name = name;
        age = 0;
    }

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        if (name.length() == 0){
            System.out.println("Имя не может быть пустым!");
            return;
        }
        this.name = name;
    }
    public void setAge(int age) {
        if (age < 0){
            System.out.println("Возраст не может быть отрицательным!");
            return;
        }
        this.age = age;
    }
    public void setMetersWalked(int metersWalked) {
        if (metersWalked < 0){
            System.out.println("Дистанция не может быть равной нулю");
            return;
        }
        this.metersWalked = metersWalked;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getMetersWalked(){
        return metersWalked;
    }

    void walk(){
        metersWalked += 1;
    }

    void showDistance(){
        System.out.println(name + " прошел(-ла) " + metersWalked + " метр(-ов)");
    }

    static void addMember(Human person){
        societyMembers.add(person);
    }

    static void showSocietyMembersNames(){
        for (Human person : societyMembers)
            System.out.println(person.name);
    }
}
