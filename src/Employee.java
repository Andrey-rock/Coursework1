public class Employee {
    //Объявление полей класса
    private final int id;
    private String fullName;
    private int department;
    private int salary;
    private static int count = 0;

    //Конструктор класса
    public Employee(String fullName, int department, int salary) {
        this.id = ++count;
        this.fullName = fullName;
        int quantityDepartment = 5;
        if (department <= quantityDepartment) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Введён неверный номер отдела");
        }
        this.salary = salary;
    }

    //Геттеры и сеттеры

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    //Переопределение метода toString
    @Override
    public String toString() {
        return "Сотрудник № " + id + ": ФИО - " + fullName + ", \tотдел - " +
                department + ", \tзарплата = " + salary;
    }

    //Переопределение методов equals и hashCode
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
