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
        double tempSalary = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(tempSalary);
    }

    public double socialSecurityTax(Employee employee) {
        double tax;
        if (employee.getSalary() < 8900.0) {
            tax = (employee.getSalary() * 6.2) / 100;
            return tax;
        } else {
            tax = (106800 * 6.2) / 100;
            return tax;
        }
    }

    public static double insuranceCoverage(Employee employee) {
        int employeeAge = employee.getAge();
        double rate;
        if (employeeAge < 35) {
            rate = (3 * employee.getSalary()) / 100;
            return rate;
        } else if (employeeAge >= 35 || employeeAge <= 50) {
            rate = (4 * employee.getSalary()) / 100;
            return rate;
        } else if (employeeAge > 50 || employeeAge < 60) {
            rate = (5 * employee.getSalary()) / 100;
            return rate;
        } else {
            rate = (6 * employee.getSalary()) / 100;
            return rate;
        }
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        Employee employee1 = new Employee(1, "Joe", 27, 3478.67);
        Employee employee2 = new Employee(2, "Monica", 26, 5312.8);
        Employee employee3 = new Employee(3, "Pheobee", 30, 7432.0);
        Employee employee4 = new Employee(4, "Ross", 45, 4999.9);
        Employee employee5 = new Employee(5, "Chandler", 63, 9832.9);
        Employee employee6 = new Employee(15, "Rachel", 52, 4321.76);
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

        System.out.println("Befoer swapping : First Employee salary :" + employee1.getSalary()
                + " & Second Employee salary : " + employee2.getSalary());
        problem4.swap(employee1, employee2);
        System.out.println("After swapping : First Employee salary :" + employee1.getSalary()
                + " & Second Employee salary : " + employee2.getSalary());

        double socialSecurityTaxCalculator = problem4.socialSecurityTax(employee1);
        System.out.println(
                "The tax of the employee " + employee1.getFirstName() + " is : " + socialSecurityTaxCalculator);

        socialSecurityTaxCalculator = problem4.socialSecurityTax(employee5);
        System.out.println(
                "The tax of the employee " + employee5.getFirstName() + " is : " + socialSecurityTaxCalculator);

        double rate = insuranceCoverage(employee1);
        System.out.println("The insurance rate of the employee is : " + rate);
        rate = insuranceCoverage(employee5);
        System.out.println("The insurance rate of the employee is : " + rate);
        rate = insuranceCoverage(employee6);
        System.out.println("The insurance rate of the employee is : " + rate);

    }
}
