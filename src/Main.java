public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("John Doe", 1, 100000);
        employees[1] = new Employee("Peter Parker", 2, 200000);
        employees[2] = new Employee("Mary Jane", 5, 300000);
        employees[3] = new Employee("Jane Smith", 3, 400000);
        employees[4] = new Employee("Mike Anderson", 5, 500000);
        employees[5] = new Employee("Jim Morrison", 4, 600000);
        employees[6] = new Employee("Jill Young", 1, 70000);
        employees[7] = new Employee("Bob Dean", 3, 80000);
        employees[8] = new Employee("Chunk Norris", 2, 90000);
        employees[9] = new Employee("Jim Halpern", 5, 110000);

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }


    }
}