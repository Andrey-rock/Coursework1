public class Main {

    public static void main(String[] args) {

        //Инициализация книги сотрудников
        EmployeeBook book = new EmployeeBook();

        //Попробуем вывестиписок сотрудников
        book.printEmployees();
        System.out.println();

        //Добавление сотрудников
        book.addEmployee("Иванов И.И", 1, 100_000);
        book.addEmployee("Петров П.П", 2, 200_000);
        book.addEmployee("Сидоров С.А", 3, 210_000);
        book.addEmployee("Сидорова А.Д", 4, 150_000);
        book.addEmployee("Романенко К.П", 5, 180_000);
        book.addEmployee("Соколов А.Д", 4, 220_000);
        book.addEmployee("Ермоленко А.А", 3, 70_000);
        book.addEmployee("Белякова А.В", 2, 330_000);
        book.addEmployee("Свиридов П.В", 1, 81_000);
        //С проверкой
        System.out.println(book.addEmployee("Харламов Р.А", 3, 120_000)); //True
        System.out.println(book.addEmployee("Романенко К.П", 4, 100_000)); //False

        //Вывод списка всех сотрудников
        book.printEmployees();
        System.out.println();

        //Вывод суммы зарплаты всех сотрудников за месяц
        System.out.println("Сумма зарплаты всех сотрудников за месяц: " + book.sumSalary());
        System.out.println();

        //Сотрудник с наименьшей зарплатой
        System.out.println("Сотрудник с наимньшей зарплатой - " + book.minEmployee());
        System.out.println();

        //Сотрудник с наибольшей зарплатой
        System.out.println("Сотрудник с наибольшей зарплатой - " + book.maxEmployee());
        System.out.println();

        //Среднее значение зарплаты
        System.out.println("Среднее значение зарплаты: " + book.averageSalary());
        System.out.println();

        //Распечатка ФИО
        System.out.println("ФИО сотрудников: ");
        book.printEmployeesFullName();
        System.out.println();

        //Индексирование зарплаты на 10%
        System.out.println("Индексирование зарплаты: ");
        book.indexSalary(10);

        //Вывод списка всех сотрудников
        book.printEmployees();
        System.out.println();

        //Проверка метдов для отдела №3
        System.out.println("В отделе 3:");

        //Сотрудник с наименьшей зарплатой
        System.out.println("Сотрудник с наимньшей зарплатой - " + book.minEmployeeDepartment(3));

        //Сотрудник с наибольшей зарплатой
        System.out.println("Сотрудник с наибольшей зарплатой - " + book.maxEmployeeDepartment(3));

        //Среднее значение зарплаты по отделу
        System.out.println("Среднее значение зарплаты: " + book.averageSalaryDepartment(3));
        System.out.println();

        //Повышение зарплаты на 10%
        System.out.println("Повышение зарплаты на 10%: ");
        book.indexSalaryDepartment(3, 10);

        //Распечатка сотрудников отдела
        book.printEmployeesDepartment(3);
        System.out.println();

        //Вывод сотрудников с зп > 200_000
        System.out.println("Сотрудники с зп > 200_000: ");
        book.printEmployeesSalaryMore(200_000);
        System.out.println();

        //Вывод сотрудников с зп < 100_000
        System.out.println("Сотрудники с зп < 100_000:");
        book.printEmployeesSalaryLess(100_000);
        System.out.println();

        //Удаление сотрудника
        book.deleteEmployee(3);
        book.deleteEmployee(6);
        book.deleteEmployee(8);
        book.deleteEmployee(9);
        book.deleteEmployee(8); //Не будет найден
        System.out.println();

        //Вывод списка всех сотрудников
        book.printEmployees();
        System.out.println();

        //Получение сотрудника по id
        System.out.println(book.getEmployee(5));
        System.out.println();
        System.out.println(book.getEmployee(10));
        System.out.println();

        //Удалим пятого сотрудника и попробуем вывести сотрудников пятого отдела
        book.deleteEmployee(5);
        book.printEmployeesDepartment(5);
        System.out.println(book.maxEmployeeDepartment(5));
        System.out.println(book.minEmployeeDepartment(5));
        System.out.println(book.averageSalaryDepartment(5));
        book.indexSalaryDepartment(5, 15);
        System.out.println();

        //Проверим реакцию на орецательный процент
        book.indexSalaryDepartment(1, -15);
        book.indexSalary(-10);
        System.out.println();

        //Проверим реакцию на несуществующий отдел
        book.printEmployeesDepartment(10);
        book.maxEmployeeDepartment(10);
        System.out.println(book.minEmployeeDepartment(10)); //Выдаст null
        book.averageSalaryDepartment(10);
        book.indexSalaryDepartment(10, 10);
        System.out.println();

        /*Что бы все методы попробовать представим, что Ермоленко вышла замуж за Харламова.
         Ей сменим фамилию, а Харламову повысим ЗП. И преведем их в 5 отдел*/
        book.getEmployee(7).setFullName("Харламова А.А.");
        book.getEmployee(10).setSalary(100_000);
        book.getEmployee(10).setDepartment(5);
        book.getEmployee(7).setDepartment(5);

        //Вывод списка всех сотрудников
        book.printEmployees();
        System.out.println();
    }
}

