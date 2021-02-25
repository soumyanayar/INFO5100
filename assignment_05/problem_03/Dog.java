import java.util.Date;

public class Dog extends Pet implements Boardable {
    private String size;

    private Date boardStartDate;
    private Date boardEndDate;

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Dog(String petName, String ownerName, String color, String size) {
        super(petName, ownerName, color);
        this.size = size;
    }

    @Override
    public String toString() {
        return "DOG : " + "\n" + this.getPetName() + " owned by " + this.getOwnerName() + "\nColor : " + this.getColor()
                + "\nGender : " + getSex() + "\nSize : " + this.getSize();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.boardStartDate = new Date(year, month - 1, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.boardEndDate = new Date(year, month - 1, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Date date = new Date(year, month - 1, day);

        /* boardStartDate <= date <= boardEndDate */
        if (!this.boardStartDate.after(date) && !this.boardEndDate.before(date)) {
            return true;
        }

        return false;
    }

}
