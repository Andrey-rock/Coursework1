public class EmployeeBook {

    //Объявление статического массива - список сотрудников
    private static final Employee[] employees = new Employee[10];

    // Добавление нового сотрудника
    public boolean addEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return true;
            }
        }
        return false;
    }

    //Метод удаления сотрудника
    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                System.out.println("Сотрудник удален");
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }

    //Метод получения сотрудника
    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    //Метод вывода списка сотрудников
    public void printEmployees() {
        boolean flag = false;
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Список сотрудников пуст");
        }
    }

    //Метод получения суммы затрат на ЗП
    public int sumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //Метод получения сотрудника с максимальной зарплатой
    public Employee maxEmployee() {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() > max.getSalary())) {
                max = employee;
            }
        }
        return max;
    }

    //Метод получения сотрудника с минимальной зарплатой
    public Employee minEmployee() {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() < min.getSalary())) {
                min = employee;
            }
        }
        return min;
    }

    //Метод получения среднего значения зарплаты
    public float averageSalary() {
        int countEmployee = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                countEmployee++;
            }
        }
        if (countEmployee > 0) {
            return (float) sumSalary() / countEmployee;
        } else {
            return 0;
        }
    }

    //Метод вывода списка ФИО сотрудников
    public void printEmployeesFullName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    //Метод индексации зарплаты
    public void indexSalary(int addPercentage) {
        if (addPercentage < 0) {
            System.out.println("Процент индексации не может быть отрицательным");
            return;
        }
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * addPercentage / 100);
            }
        }
        System.out.println("Индексация завершена");
    }

    //Инициализация первого сотрудника в поиске по отделу
    public Employee firstEmployeeDepartmentInSearch(int department) {
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                return employee;
            }
        }
        return null;
    }

    //Метод получения сотрудника с максимальной зарплатой в отделе
    public Employee maxEmployeeDepartment(int department) {
        if (department > Employee.getQuantityDepartment()) {
            System.out.println("Отдел не найден");
            return null;
        }
        Employee max = firstEmployeeDepartmentInSearch(department);
        if (max == null) {
            return null;
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
    public Employee minEmployeeDepartment(int department) {
        if (department > Employee.getQuantityDepartment()) {
            System.out.println("Отдел не найден");
            return null;
        }
        Employee min = firstEmployeeDepartmentInSearch(department);
        if (min == null) {
            System.out.println("В отделе нет сотрудников");
            return null;
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
    public int sumSalaryDepartment(int department) {
        if (department > Employee.getQuantityDepartment()) {
            System.out.println("Отдел не найден");
            return 0;
        }
        int sum = 0;
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //Метод получения среднего значения зарплаты в отделе
    public float averageSalaryDepartment(int department) {
        if (department > Employee.getQuantityDepartment()) {
            System.out.println("Отдел не найден");
            return 0;
        }
        int count = 0;
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                count++;
            }
        }
        if (count > 0) {
            return (float) sumSalaryDepartment(department) / count;
        } else {
            return 0;
        }
    }

    //Метод индексации зарплаты в отделе
    public void indexSalaryDepartment(int department, int addPercentage) {
        if (department > Employee.getQuantityDepartment()) {
            System.out.println("Отдел не найден");
            return;
        }
        if (addPercentage < 0) {
            System.out.println("Процент индексации не может быть отрицательным");
            return;
        }
        int countEmployeesInDepartment = 0;
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * addPercentage / 100);
                countEmployeesInDepartment++;
            }
        }
        if (countEmployeesInDepartment == 0) {
            System.out.println("В отделе нет сотрудников");
        } else {
            System.out.println("Индексация завершена");
        }
    }

    //Метод вывода списка сотрудников в отделе
    public void printEmployeesDepartment(int department) {
        if (department > Employee.getQuantityDepartment()) {
            System.out.println("Отдел не найден");
            return;
        }
        int countEmployeesInDepartment = 0;
        for (Employee employee : employees) {
            if ((employee != null) && (department == employee.getDepartment())) {
                System.out.println("Сотрудник № " + employee.getId() + ", ФИО : " + employee.getFullName()
                        + ", \tзарплата = " + employee.getSalary());
                countEmployeesInDepartment++;
            }
        }
        if (countEmployeesInDepartment == 0) {
            System.out.println("В отделе нет сотрудников");
        }
    }

    //Метод вывода списка сотрудников с зп ,больше заданного числа
    public void printEmployeesSalaryMore(int salary) {
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() > salary)) {
                System.out.println(employee);
            }
        }
    }

    //Метод вывода списка сотрудников с зп меньше заданного числа
    public void printEmployeesSalaryLess(int salary) {
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getSalary() < salary)) {
                System.out.println(employee);
            }
        }
    }
}

