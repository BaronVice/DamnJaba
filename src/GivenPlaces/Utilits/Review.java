package GivenPlaces.Utilits;

// Будет реализован в бета версии
public abstract class Review {

    private String userName;
    private int mark;
    private String comment;

    /* TODO: сделать проверки в сетерах: на непустые имя и комментарий, на оценку*/

    public Review(String userName, int mark, String comment) {
        this.userName = userName;
        this.mark = mark;
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString(){
        return String.format("User: %s\nMark: %d\nComment: %s", userName, mark, comment);
    }
}
