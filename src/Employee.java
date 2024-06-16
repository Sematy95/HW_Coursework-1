import java.util.Objects;

public class Employee {

    private final String name;
    private int department;
    private int salary;
    private static int counter;
    private int ID = 0;



    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.ID = ID;
        ID = ++counter;
    }

    @Override
    public String toString() {
        return
                "ФИО: " + name +
                        ", отдел: " + department +
                        ", зарплата: " + salary + " рублей" +
                        ", ID сотрудника: " + ID;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getID() {
        return ID;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary);
    }
}


