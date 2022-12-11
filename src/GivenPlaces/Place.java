package GivenPlaces;


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

    public Place(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getPlaceType(){
        return "Место";
    }


    public String toString(){
        return String.format("%s: %s\nОписание: %s\n", getPlaceType(), name, description);
    }
}
