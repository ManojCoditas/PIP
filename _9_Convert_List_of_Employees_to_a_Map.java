import java.util.*;
import java.util.stream.Collectors;

class Employe {
    String name;
    int salary;

    public Employe(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}

public class _9_Convert_List_of_Employees_to_a_Map {
    public static void main(String[] args) {
        // Example list of employees
        List<Employe> employees = Arrays.asList(
                new Employe("Alice", 50000),
                new Employe("Bob", 60000),
                new Employe("Charlie", 55000)
        );

        // Convert List<Employee> to Map<String, Integer> using Java Streams
        Map<String, Integer> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employe::getName, Employe::getSalary));

        // Print the result
        System.out.println(employeeMap);
    }
}
