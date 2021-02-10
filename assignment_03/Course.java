import java.util.LinkedHashSet;
import java.util.Set;

public class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity = 100;
    private int professorId;
    private int credits;
    private int[] studentIds;
    private int currentCapacity;

    public Course(int courseId) {
        this.courseId = courseId;
        this.studentIds = new int[maxCapacity];
    }

    public Course(int courseId, int professorId) {
        this.courseId = courseId;
        this.professorId = professorId;
        this.studentIds = new int[maxCapacity];
    }

    public Course(int courseId, int professorId, int credits) {
        this.courseId = courseId;
        this.professorId = professorId;
        this.credits = credits;
        this.studentIds = new int[maxCapacity];
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        if (courseId <= 0) { // validation for setting the courseId
            System.out.println("courseId should not be negative or 0");
        }
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName.length() < 10 || courseName.length() > 60) { // validation for setting the course name
            System.out.println("Course name should atleast have 10 charecters and should not exceed 60 charecters");
            return;
        }
        this.courseName = courseName;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity < 10 || maxCapacity > 100) { // validation for setting capacity
            System.out.println("Class capacity should be above 10 and below 100");
            return;
        }
        this.maxCapacity = maxCapacity;
    }

    public int getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(int professorId) {
        int professorIdLength = String.valueOf(professorId).length();
        if (professorIdLength != 6) {
            System.out.println("Professor Id should be a 6 digit integer");
            return;
        }
        this.professorId = professorId;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        if (credits <= 0 || credits > 9) { // validating the number of credits
            System.out.println("credits should be a single digit but greater than 0");
        }
        this.credits = credits;
    }

    public int[] getStudentIds() {
        return this.studentIds;
    }

    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

    // registerStudent method should store all ids in studentIds array
    public void registerstudent(int studentId) {
        if (this.currentCapacity + 1 > maxCapacity) {
            System.out.println("Registering new student is exceeding the maxCapacity. Trying to remove any duplicates");
            this.studentIds = removeDuplicate(this.studentIds);
            // Check again if current capacity exceeds max capacity after trying to remove
            // duplicates
            if (this.currentCapacity + 1 > maxCapacity) {
                System.out.println("This course has already reached max capacity.");
                return;
            }
        }
        this.studentIds[this.currentCapacity++] = studentId;
    }

    // Problem 3:
    // removes the the duplicated elements in the array
    public int[] removeDuplicate(int[] array) {
        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        for (int element : array) {
            linkedHashSet.add(element);
        }
        int[] arrayWithDuplicatesRemoved = new int[array.length];
        int index = 0;
        for (int element : linkedHashSet) {
            arrayWithDuplicatesRemoved[index++] = element;
        }
        // Also setting the current capacity to the length after removing the duplicates
        this.currentCapacity = linkedHashSet.size();
        return arrayWithDuplicatesRemoved;
    }

    // Problem 4:
    // Find number of pairs of studentsIds whose sum is even
    // Sum can be even only in two cases
    // 1. Sum of two odd numbers
    // 2. Sum of two even numbers
    // So, the problem can be reduced to sum of number of combinations of 2 of odd
    // numbers and number of combinations of 2 of even numbers
    // Using 2 private helper methods to calculate nCr and factorial.
    public int groupsOfStudents(int[] studentIds) {
        int numberOfEvens = 0;
        int numberOfOdds = 0;
        for (int studentId : studentIds) {
            if (studentId % 2 == 0) {
                ++numberOfEvens;
            } else {
                ++numberOfOdds;
            }
        }
        int groupsOfTwo = nCr(numberOfEvens, 2) + nCr(numberOfOdds, 2);
        return groupsOfTwo;
    }

    private int nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    public static void main(String[] args) {
        Course courseINFO500 = new Course(12, 123456, 4);
        courseINFO500.setMaxCapacity(100);

        // Create 80 students
        for (int studentId = 1; studentId <= 80; ++studentId) {
            courseINFO500.registerstudent(studentId);
        }

        // Create 40 more students so that it exceeds the max capacity.
        for (int studentId = 1; studentId <= 40; ++studentId) {
            courseINFO500.registerstudent(studentId);
        }

        System.out.println("\nPrinting all registered student ids");
        for (int studentId : courseINFO500.getStudentIds()) {
            System.out.print(studentId + " ");
        }

        System.out.println("\n\nGroups of students of pairs of studentsIds whose sum is even: "
                + courseINFO500.groupsOfStudents(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }
}
