### Explain Encapsulation with an example.

**Encapsulation** in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through the methods of their current class. Therefore, it is also known as **data hiding**.
To achieve encapsulation in Java:
- Declare the variables of a class as private.
- Provide public setter and getter methods to modify and view the variables values.
```java
import java.util.Date;
public class Student {
    private int id;
    private String name;
    private Date dateOfBirth;
    private int heightInCM;
    public Student() {
    }
    public Student(int id, String name, Date dateOfBirth, int heightInCM) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.heightInCM = heightInCM;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getHeightInCM() {
        return this.heightInCM;
    }
    public void setHeightInCM(int heightInCM) {
        this.heightInCM = heightInCM;
    }
}
class Client {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Soumya");
        System.out.println("Student's name is: " + student1.getName());
        student1.setHeightInCM(166);
        System.out.println("Student's height is: " + student1.getHeightInCM());
    }
}
```
The getter and setter methods are also called,
- getter `=>` accessor
- setter `=>` mutator
### Why encapsulation is necessary
Suppose if the fields in the above class Student are not private. Then client can set any invalid value for each field. For example.
```java
student1.dateOfBirth = new Date(2150, 5, 10);
```
or
```java
student.heightInCM = 0;
```
With explicit setters, it is possible to do some basic validation, for example
```java
public void setHeightInCM(int heightInCM) {
    if (heightInCM > 100) {
        this.heightInCM = heightInCM;
    }
}
```
Also, Even though the methods don't really add new functionality, the cool thing is that you can change your mind later. you can come back and make a method safer, faster, better. 
Information hiding is important for many reasons, most of which stem from the fact that it decouples the modules that compromise a system, allowing them to be developed, tested, optimized, used, understood, and modified in isolation.
### Final Rule of thumb
1. Mark your instance variables private
2. Provide public getters and setters for access control