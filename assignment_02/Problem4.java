public class Problem4 {
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sumOfSalariesGreaterThanFiveThousand = 0.0;
        for (Employee employee : employees) {
            double employeeSalary = employee.getSalary();
            if (employeeSalary > 5000.0) {
                sumOfSalariesGreaterThanFiveThousand = sumOfSalariesGreaterThanFiveThousand + employeeSalary;
            }
        }
        return sumOfSalariesGreaterThanFiveThousand;
    }

    public void fizzBuzz(Employee employee) {
        if (employee.getId() % 3 == 0 && employee.getId() % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (employee.getId() % 3 == 0) {
            System.out.println("Fizz");
        } else if (employee.getId() % 5 == 0) {
            System.out.println("Buzz");
        }
    }

    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // Write your code here
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        Employee employee1 = new Employee(1, "Joe", 27, 3478.67);
        Employee employee2 = new Employee(2, "Monica", 26, 5312.8);
        Employee employee3 = new Employee(3, "Pheobee", 30, 7432.0);
        Employee employee4 = new Employee(4, "Ross", 32, 4999.9);
        Employee employee5 = new Employee(5, "Chandler", 31, 9832.9);
        Employee employee6 = new Employee(15, "Rachel", 27, 4321.76);
        Employee[] employees = { employee1, employee2, employee3, employee4, employee5, employee6 };
        double sumOfSalariesGreaterThanFiveThousand = problem4.salaryGreaterThanFiveThousand(employees);
        System.out.println("The sum of salaries of employees whose salary is above 5000 is: "
                + sumOfSalariesGreaterThanFiveThousand);
        problem4.fizzBuzz(employee1);
        problem4.fizzBuzz(employee2);
        problem4.fizzBuzz(employee3);
        problem4.fizzBuzz(employee4);
        problem4.fizzBuzz(employee5);
        problem4.fizzBuzz(employee6);
    }
}
