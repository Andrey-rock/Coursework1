public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Иванов Иван Иванович", 1, 100000);
        employees[1] = new Employee("Сидоров Александр Сергеевич", 2, 200000);
        employees[2] = new Employee("Петров Петр Петрович", 3, 300000);
        employees[3] = new Employee("Сидорова Мария Ивановна", 3, 400000);
        employees[4] = new Employee("Жук Владимир Владимирович", 5, 500000);
        employees[5] = new Employee("Михайлов Андрей Сергеевич", 4, 600000);
        employees[6] = new Employee("Фёдоров Александр Алексееевич", 1, 70000);
        employees[7] = new Employee("Макаров Алексей Андреевич", 3, 85001);
        employees[8] = new Employee("Свиридов Андрей Андреевич", 2, 90000);
        employees[9] = new Employee("Комарова Ксеня Сергеевна", 5, 110000);

        System.out.println("Список сотрудников:");
        printEmployees(employees);
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц: " + sumSalary(employees));
        System.out.println("Сотрудник с максимальной зарплатой: " + maxEmployee(employees));
        System.out.println("Сотрудник с минимальной зарплатой: " + minEmployee(employees));
        System.out.println("Среднее значение зарплаты в месяц: " + averageSalary(employees));
        System.out.println();
        System.out.println("Список ФИО сотрудников:");
        printEmployeesFullName(employees);
    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int sumSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee maxEmployee(Employee[] employees) {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > max.getSalary()) {
                max = employee;
            }
        }
        return max;
    }

    public static Employee minEmployee(Employee[] employees) {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < min.getSalary()) {
                min = employee;
            }
        }
        return min;
    }

    public static float averageSalary(Employee[] employees) {

        return (float) sumSalary(employees) / employees.length;
    }

    public static void printEmployeesFullName(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }


}
