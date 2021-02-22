public class TestBoarding {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Pinky", "Monica", "Grey", "Long");
        cat1.setSex(1);
        System.out.println(cat1.toString());
        cat1.setBoardStart(12, 8, 2019);
        cat1.setBoardEnd(1, 29, 2020);
        boolean boarding = cat1.boarding(1, 29, 2020);
        System.out.println("Boarding available : " + boarding);
        System.out.println("\n");

        Dog dog1 = new Dog("Goldy", "Adam", "Black", "Medium");
        dog1.setSex(3);
        System.out.println(dog1.toString());
        dog1.setBoardStart(10, 9, 2000);
        dog1.setBoardEnd(10, 10, 2000);
        boarding = dog1.boarding(11, 10, 2000);
        System.out.println("Boarding available : " + boarding);
        System.out.println("\n");
    }
}
