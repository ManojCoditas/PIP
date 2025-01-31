import java.util.*;
import java.util.stream.Collectors;


/*
* Input ;-> List<Employee> employees = Arrays.asList(
        new Employee("Alice", "IT", 60000),
        new Employee("Bob", "HR", 50000),
        new Employee("Charlie", "IT", 70000),
        new Employee("David", "Finance", 55000)
    );
    *
 output :-> {IT=[Alice, Charlie], HR=[Bob], Finance=[David]}
* */
class Employee {
    String name;
    String department;
    int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

public class _8_Group_Employees_by_Department {

    public static Map<String, List<String>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 60000),
                new Employee("Bob", "HR", 50000),
                new Employee("Charlie", "IT", 70000),
                new Employee("David", "Finance", 55000)
        );

        Map<String, List<String>> groupedEmployees = groupByDepartment(employees);
        System.out.println(groupedEmployees);
    }
}
