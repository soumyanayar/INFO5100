import java.util.Date;

public class Cat extends Pet implements Boardable {
    private String hairLength;

    private Date boardStartDate;
    private Date boardEndDate;

    public String getHairLength() {
        return this.hairLength;
    }

    public void setHairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    public Cat(String petName, String ownerName, String color, String hairLength) {
        super(petName, ownerName, color);
        this.hairLength = hairLength;
    }

    @Override
    public String toString() {
        return "CAT: " + "\n" + this.getPetName() + " Owned by " + this.getOwnerName() + "\nColor : " + this.getColor()
                + "\nGender : " + getSex() + "\nHair : " + this.getHairLength();
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
