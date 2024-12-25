import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {

    private Employee[] employees = new Employee[11];

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Objects.deepEquals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }

    public void printAllEmployees() {
        System.out.println("Список сотрудников:");
        for (int i = 0; i < employees.length; i++)
            if (employees[i] != null) System.out.println(employees[i]);
    }

    public void findMaxSalaryEmployee() {
        int maxSalary = Integer.MIN_VALUE;
        Employee employee = null;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (maxSalary < employees[i].getSalary()) maxSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (maxSalary == employees[i].getSalary()) {
                employee = employees[i];
            }
        }
        System.out.println("Сотрудник с самой высокой зарплатой - " + employee);

    }

    public void findMinSalaryEmployee() {
        int minSalary = Integer.MAX_VALUE;
        Employee employee = null;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (minSalary > employees[i].getSalary()) minSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (minSalary == employees[i].getSalary()) {
                employee = employees[i];
            }
        }
        System.out.println("Сотрудник с самой низкой зарплатой - " + employee);

    }

    public void showSalarySum() {
        int totalSalary = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {

            totalSalary += employees[i].getSalary();
        }
        System.out.println("Сумма затрат на ЗП в месяц - " + totalSalary + " рублей");
    }

    public void showSalaryAverage() {
        int totalSalary = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            totalSalary += employees[i].getSalary();
        }
        float averageSalary = (float) totalSalary / employees.length;
        System.out.println("Среднее значение зарплат - " + averageSalary + " рублей");
    }

    public void increaseSalaryForAll(int percent) {
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() / 100 * percent);
        }
        System.out.println("Зарплата всех сотрудников увеличена на " + percent + " процентов");
    }

    public void findMinSalaryEmployeeInDepartment(int department) {
        int minSalary = 0;
        Employee employee = null;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                minSalary = employees[i].getSalary();
                break;
            }
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (minSalary > employees[i].getSalary() && employees[i].getDepartment() == department)
                minSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (minSalary == employees[i].getSalary() && employees[i].getDepartment() == department) {
                employee = employees[i];
            }
        }
        if (employee == null)
            System.out.println("Нет сотрудников в отделе " + department + ", значение минимальной зарплаты - 0");
        else System.out.println("Сотрудник с самой низкой зарплатой в отделе " + department + " - " + employee);
    }

    public void findMaxSalaryEmployeeInDepartment(int department) {
        int maxSalary = 0;
        Employee employee = null;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                maxSalary = employees[i].getSalary();
                break;
            }
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (maxSalary < employees[i].getSalary() && employees[i].getDepartment() == department)
                maxSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (maxSalary == employees[i].getSalary() && employees[i].getDepartment() == department) {
                employee = employees[i];
            }
        }
        if (employee == null)
            System.out.println("Нет сотрудников в отделе " + department + ", значение максимальной зарплаты - 0");
        else System.out.println("Сотрудник с самой высокой зарплатой в отделе " + department + " - " + employee);
    }

    public void showSalarySumInDepartment(int department) {
        int totalSalary = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) totalSalary += employees[i].getSalary();
        }
        System.out.println("Сумма затрат на ЗП в месяц в отделе " + department + " составляет " + totalSalary + " рублей");
    }

    public void showSalaryAverageDep(int department) {
        int totalSalary = 0;
        int counter = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                totalSalary += employees[i].getSalary();
                counter++;
            }
        }
        float averageSalary = (float) totalSalary / counter;
        System.out.println("Средняя зарплата в отделе " + department + " составляет " + averageSalary + " рублей");
    }

    public void increaseSalaryForDepartment(int percent, int department) {
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() / 100 * percent);
            }
        }
        System.out.println("Зарплата всех сотрудников в отделе " + department + " увеличена на " + percent + " процентов");
    }

    public void printAllEmployeesInDepartment(int department) {
        System.out.println("Список сотрудников отдела " + department + " :");
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("ID: " + employees[i].getId() + ", ФИО: " + employees[i].getName() + ", ЗП: " + employees[i].getSalary() + " рублей");
            }
        }
    }

    public void showAllWithLowerSalary(int limit) {
        System.out.println("Список сотрудников c ЗП меньше " + limit + " рублей:");
        int counter = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getSalary() < limit) {
                System.out.println(employees[i]);
                counter++;
            }
        }
        if (counter == 0) System.out.println("Таких сотрудников нет");
    }

    public void showAllWithUpperSalary(int limit) {
        System.out.println("Список сотрудников c ЗП больше " + limit + " рублей:");
        int counter = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getSalary() >= limit) {
                System.out.println(employees[i]);
                counter++;
            }
        }
        if (counter == 0) System.out.println("Таких сотрудников нет");
    }

    public boolean addNewEmployee(String name, int department, int salary) {
        System.out.println("Добавление нового сотрудника");
        boolean isNull = false;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                employees[i] = new Employee(name, department, salary);
                isNull = true;
                break;
            }
        }
        if (!isNull) {
            System.out.println("Нет пустой ячейки для добавления сотрудника");
        } else {
            System.out.println("Сотрудник добавлен");
        }
        return isNull;
    }

    public boolean deleteEmployee(int id) {
        System.out.println("Удаление сотрудника по id");
        boolean isExist = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Сотрудника с id " + id + " нет в массиве");
        } else {
            System.out.println("Сотрудник удален");
        }
        return isExist;
    }
}
