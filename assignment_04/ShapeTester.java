class Shape {
    private String name;
    private double perimeter;
    private double area;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void draw() {
        System.out.println("Drawing Shape");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.height + this.width);
    }

    @Override
    public double getArea() {
        return this.height * this.width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getPerimeter() {
        return 4 * this.side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class ShapeTester {
    public static void main(String[] args) {
        Shape s = new Shape();
        Rectangle r = new Rectangle(2, 3);
        Circle c = new Circle(4);
        Square sq = new Square(4);

        System.out.println();
        s.draw();
        System.out.println();

        System.out.println("The area of the rectangle is : " + r.getArea());
        System.out.println("The perimeter of the rectangle is : " + r.getPerimeter());
        r.draw();
        System.out.println();

        System.out.println("The area of the circle is : " + c.getArea());
        System.out.println("The perimeter of the circle is : " + c.getPerimeter());
        c.draw();
        System.out.println();

        System.out.println("The area of the square is: " + sq.getArea());
        System.out.println("The perimeter of teh square is: " + sq.getPerimeter());
        sq.draw();
    }
}
