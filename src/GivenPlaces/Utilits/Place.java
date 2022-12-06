package GivenPlaces.Utilits;


/* TODO: сделать проверки в сетерах: на непустые имена и описания, на парс в double
*   Идеи: сделать базу с пользователями, комменатрии можно оставлять если пользователь существует,
*   Можно использовать дату и время для отзыва
*         */
public abstract class Place {
    protected String name;
    protected String description;
    public String getDescription() {
        return description;
    }

    public abstract String getPlaceType();

    public void setDescription(String description) {
        if (description.trim().isEmpty())
            this.description = "Описание отсутствует";
        else
            this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EmptyStringException{
        if (name.trim().isEmpty())
            throw new EmptyStringException("имя не может быть пустым");

        this.name = name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public String toString(){
        return String.format("%s: %s\nОписание: %s", getPlaceType(), name, description);
    }
}
