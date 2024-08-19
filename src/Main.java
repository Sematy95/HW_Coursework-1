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
        employees[9] = new Employee("Смагин Олег Витальевич", 3, 150_000);
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
        increaseSalaryForAll(10);
        printAllEmployees();
        System.out.println("findMinSalaryEmpDep(3) = " + findMinSalaryEmpDep(3));
        System.out.println("findMaxSalaryEmpDep(3) = " + findMaxSalaryEmpDep(3));
        showSalarySumDep(3);
        showSalaryAverageDep(5);
        printAllEmployeesDep(1);
        increaseSalaryForDep(10, 1);
        printAllEmployeesDep(1);
        showAllWithLowerSalary(150_000);
        showAllWithUpperSalary(250_000);


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

    public static void increaseSalaryForAll(int percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }

    public static Employee findMinSalaryEmpDep(int department) {
        int minSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                minSalary = employees[i].getSalary();
                break;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary() && employees[i].getDepartment() == department)
                minSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length; i++) {
            if (minSalary == employees[i].getSalary() && employees[i].getDepartment() == department) {
                return employees[i];
            }
        }
        return null;
    }

    public static Employee findMaxSalaryEmpDep(int department) {
        int maxSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                maxSalary = employees[i].getSalary();
                break;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary() && employees[i].getDepartment() == department)
                maxSalary = employees[i].getSalary();
        }
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary == employees[i].getSalary() && employees[i].getDepartment() == department) {
                return employees[i];
            }
        }
        return null;
    }

    public static void showSalarySumDep(int department) {
        int totalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) totalSalary += employees[i].getSalary();
        }
        System.out.println("Сумма затрат на ЗП в месяц в отделе " + department + " составляет " + totalSalary + " рублей");
    }

    public static void showSalaryAverageDep(int department) {
        int totalSalary = 0;
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                totalSalary += employees[i].getSalary();
                counter++;
            }
        }
        float averageSalary = (float) totalSalary / counter;
        System.out.println("Средняя зарплата в отделе " + department + " составляет " + averageSalary + " рублей");
    }

    public static void increaseSalaryForDep(int percent, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() / 100 * percent);
            }
        }
    }

    public static void printAllEmployeesDep(int department) {
        System.out.println("Список сотрудников отдела " + department + " :");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("ID: " + employees[i].getId() + ", ФИО: " + employees[i].getName() + ", ЗП: " + employees[i].getSalary() + " рублей");
            }
        }
    }

    public static void showAllWithLowerSalary(int limit) {
        System.out.println("Список сотрудников c ЗП меньше " + limit + " рублей:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < limit) System.out.println(employees[i]);
        }
    }

    public static void showAllWithUpperSalary(int limit) {
        System.out.println("Список сотрудников c ЗП больше " + limit + " рублей:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= limit) System.out.println(employees[i]);
        }
    }
}






