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

    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        Employee employeeWithHighestSalary;
        Employee employeeWithLowestSalary;
        Employee EmployeeWithIntermediateSalary;
        // First find the employee with highest salary
        if (e1.getSalary() > e2.getSalary() && e1.getSalary() > e3.getSalary()) {
            employeeWithHighestSalary = e1;
        } else if (e2.getSalary() > e1.getSalary() && e2.getSalary() > e3.getSalary()) {
            employeeWithHighestSalary = e2;
        } else {
            employeeWithHighestSalary = e3;
        }
        // Find the employee with lowest salary
        if (e1.getSalary() < e2.getSalary() && e1.getSalary() < e3.getSalary()) {
            employeeWithLowestSalary = e1;
        } else if (e2.getSalary() < e1.getSalary() && e2.getSalary() < e3.getSalary()) {
            employeeWithLowestSalary = e2;
        } else {
            employeeWithLowestSalary = e3;
        }
        // Find the employee with intermediate salary
        if ((employeeWithHighestSalary == e1 && employeeWithLowestSalary == e2)
                || (employeeWithHighestSalary == e2 && employeeWithLowestSalary == e1)) {
            EmployeeWithIntermediateSalary = e3;
        } else if ((employeeWithHighestSalary == e1 && employeeWithLowestSalary == e3)
                || (employeeWithHighestSalary == e3 && employeeWithLowestSalary == e1)) {
            EmployeeWithIntermediateSalary = e2;
        } else {
            EmployeeWithIntermediateSalary = e1;
        }
        System.out.println(employeeWithLowestSalary.getFirstName() + " " + EmployeeWithIntermediateSalary.getFirstName()
                + " " + employeeWithHighestSalary.getFirstName());
    }

    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        int i = 0;
        for (String employeeStr : employeesStr) {
            String[] employeeStrSplitted = employeeStr.split(",");
            int id = Integer.parseInt(employeeStrSplitted[0]);
            String name = employeeStrSplitted[1];
            int age = Integer.parseInt(employeeStrSplitted[2]);
            double salary = Double.parseDouble(employeeStrSplitted[3]);
            Employee employee = new Employee(id, name, age, salary);
            employees[i++] = employee;
        }
        return employees;
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

        problem4.sortSalary(employee3, employee4, employee5);

        String[] employeesString = new String[] { "1,John,24,7500", "2,Hail,28,7899.90" };
        Employee[] employeesCreatedFromString = problem4.createEmployees(employeesString);
        System.out.println("Employees created from the employeesString are:");
        for (Employee employeeCreatedFromString : employeesCreatedFromString) {
            System.out.println("id: " + employeeCreatedFromString.getId());
            System.out.println("name: " + employeeCreatedFromString.getFirstName());
            System.out.println("age: " + employeeCreatedFromString.getAge());
            System.out.println("salary: " + employeeCreatedFromString.getSalary());
            System.out.println("**********************************************************");
        }
    }
}
