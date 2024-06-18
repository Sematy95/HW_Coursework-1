public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 110_000);
        employees[1] = new Employee("Петров Александр Сергеевич", 1, 100_000);
        employees[2] = new Employee("Сидоров Михаил Андреевич", 3, 200_000);
        employees[3] = new Employee("Прохоров Степан Андреевич", 4, 250_000);
        employees[4] = new Employee("Степанова Лидия Петровна", 5, 92_000);
        employees[5] = new Employee("Иванова Виктория Владирировна", 5, 90_000);
        employees[6] = new Employee("Карелина Юлия Олеговна", 3, 220_000);
        employees[7] = new Employee("Высильев Михаил Николанвич", 3, 350_000);
        employees[8] = new Employee("Мокроусов Олег Игнатович", 3, 250_000);
        employees[9] = new Employee("Мокроусов Олег Игнатович", 3, 250_000);
        printAllEmployees();
        System.out.println("findMaxSalaryEmp(employees) = " + findMaxSalaryEmp());
        System.out.println("findMinSalaryEmp(employees) = " + findMinSalaryEmp());
        showSalarySum();
        showSalaryAverage();
        System.out.println("employees[2].getSalary() = " + employees[2].getSalary());
        System.out.println("employees[2].getId() = " + employees[2].getId());
        System.out.println("employees[2].getDepartment() = " + employees[2].getDepartment());
        System.out.println("employees[2].getName() = " + employees[2].getName());
        employees[2].setDepartment(4);
        System.out.println("employees[2].getDepartment() = " + employees[2].getDepartment());
        employees[2].setSalary(250_000);
        System.out.println("employees[2].getSalary() = " + employees[2].getSalary());
        showSalarySum();

    }

    public static void printAllEmployees() {
        System.out.println("Список сотрудников:");
        for (Employee employee : employees)
            System.out.println(employee);
    }

    public static Employee findMaxSalaryEmp() {
        int maxSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary()) maxSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length; i++)
            if (maxSalary == employees[i].getSalary()) {
                return employees[i];
            }
        return null;
    }

    public static Employee findMinSalaryEmp() {
        int minSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary()) minSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length; i++) {
            if (minSalary == employees[i].getSalary()) {
                return employees[i];
            }
        }
        return null;
    }

    public static void showSalarySum() {
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        System.out.println("Сумма затрат на ЗП в месяц - " + totalSalary + " рублей");
    }

    public static void showSalaryAverage() {
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        float averageSalary = (float) totalSalary / employees.length;
        System.out.println("Среднее значение зарплат - " + averageSalary + " рублей");
    }
}






