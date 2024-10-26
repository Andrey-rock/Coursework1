public class Main {

    //Объявление статического массива - список сотрудников
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        //Заполнение спискасотрудников
        employees[0] = new Employee("Иванов Иван Иванович", 1, 100_000);
        employees[1] = new Employee("Сидоров Александр Сергеевич", 2, 200_000);
        employees[2] = new Employee("Петров Петр Петрович", 3, 300_000);
        employees[3] = new Employee("Сидорова Мария Ивановна", 2, 400_000);
        employees[4] = new Employee("Жук Владимир Владимирович", 5, 500_000);
        employees[5] = new Employee("Михайлов Андрей Сергеевич", 4, 150_000);
        employees[6] = new Employee("Фёдоров Александр Алексееевич", 1, 70_000);
        employees[7] = new Employee("Макаров Алексей Андреевич", 3, 85_010);
        employees[8] = new Employee("Свиридов Андрей Андреевич", 2, 90_000);
        employees[9] = new Employee("Комарова Ксеня Сергеевна", 5, 110_000);

        //Проверка работы всех методов
        System.out.println("Список сотрудников:");
        printEmployees();
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц: " + sumSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + maxEmployee());
        System.out.println("Сотрудник с минимальной зарплатой: " + minEmployee());
        System.out.println("Среднее значение зарплаты в месяц: " + averageSalary());
        System.out.println();
        System.out.println("Список ФИО сотрудников:");
        printEmployeesFullName();
        System.out.println();
        indexSalary(10);
        System.out.println("После повышения зарплаты");
        printEmployees();
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц в отделе 3: " + sumSalaryDepartment(3));
        System.out.println("Сотрудник с максимальной зарплатой в отделе 3: " + maxEmployeeDepartment(3));
        System.out.println("Сотрудник с минимальной зарплатой в отделе 3: " + minEmployeeDepartment(3));
        System.out.println("Среднее значение зарплаты в месяц в отделе 3: " + averageSalaryDepartment(3));
        indexSalaryDepartment(3, 10);
        System.out.println("После повышения зарплаты в отделе 3");
        printEmployeesDepartment(3);
    }

    //Базовый уровень сложности

    //Метод вывода списка сотрудников
    public static void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    //Метод получения суммы затрат на ЗП
    public static int sumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //Метод получения сотрудника с максимальной зарплатой
    public static Employee maxEmployee() {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() > max.getSalary())) {
                max = employee;
            }
        }
        return max;
    }

    //Метод получения сотрудника с минимальной зарплатой
    public static Employee minEmployee() {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() < min.getSalary())) {
                min = employee;
            }
        }
        return min;
    }

    //Метод получения среднего значения зарплаты
    public static float averageSalary() {

        return (float) sumSalary() / Employee.getCount();
    }

    //Метод вывода списка ФИО сотрудников
    public static void printEmployeesFullName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    //Средний уровень сложности

    //Метод индексации зарплаты
    public static void indexSalary(int addPercentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * addPercentage / 100);
            }
        }
    }

    //Метод получения сотрудника с максимальной зарплатой в отделе
    public static Employee maxEmployeeDepartment(int department) {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                max = employee;
                break;
            }
        }
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() > max.getSalary()) &&
                    (employee.getDepartment() == department)) {
                max = employee;
            }
        }
        return max;
    }

    //Метод получения сотрудника с минимальной зарплатой в отделе
    public static Employee minEmployeeDepartment(int department) {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                min = employee;
                break;
            }
        }
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() < min.getSalary()) &&
                    (employee.getDepartment() == department)) {
                min = employee;
            }
        }
        return min;
    }

    //Метод получения суммы затрат на ЗП в отделе
    public static int sumSalaryDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //Метод получения среднего значения зарплаты в отделе
    public static float averageSalaryDepartment(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                count++;
            }
        }
        return (float) sumSalaryDepartment(department) / count;
    }

    //Метод индексации зарплаты в отделе
    public static void indexSalaryDepartment(int department, int addPercentage) {
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * addPercentage / 100);
            }
        }
    }

    //Метод вывода списка сотрудников в отделе
    public static void printEmployeesDepartment(int department) {
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                System.out.println("Сотрудник № " + employee.getId() + ", ФИО : " + employee.getFullName()
                        + ", \tзарплата = " + employee.getSalary());
            }
        }
    }

}

