import java.util.*;

/*Inuput :-> Map<String, Integer> employees ={ "Alice": 5000, "Bob": 7000, "Charlie": 7000, "David": 6000}*/
/*Output :-> ["Bob", "Charlie"]*/

public class _7_Find_Employees_with_Maximum_Salary {

    public static List<String> findEmployeesWithMaxSalary(Map<String, Integer> employees) {
        int maxSalary = Collections.max(employees.values());
        List<String> maxSalaryEmployees = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            if (entry.getValue() == maxSalary) {
                maxSalaryEmployees.add(entry.getKey());
            }
        }

        return maxSalaryEmployees;
    }

    public static void main(String[] args) {
        Map<String, Integer> employees = new HashMap<>();
        employees.put("Alice", 5000);
        employees.put("Bob", 7000);
        employees.put("Charlie", 7000);
        employees.put("David", 6000);

        System.out.println(findEmployeesWithMaxSalary(employees));
    }
}
