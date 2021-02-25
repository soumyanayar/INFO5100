public class Pet {
    enum Sex {
        MALE, FEMALE, SPAYED, NEUTERED;

        static Sex fromId(int id) {
            switch (id) {
                case 0:
                    return MALE;
                case 1:
                    return FEMALE;
                case 2:
                    return SPAYED;
                case 3:
                    return NEUTERED;
            }
            return null;
        }
    }

    private String petName;
    private String ownerName;
    private String color;
    private int age;
    protected Sex sex;

    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex.toString();
    }

    public void setSex(int sexId) {
        this.sex = Sex.fromId(sexId);
    }

    public Pet(String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String toString() {
        return "Pet " + this.getPetName() + " Owned by " + this.getOwnerName() + " \nColor : " + this.getColor()
                + "\nGender : " + getSex();
    }
}
