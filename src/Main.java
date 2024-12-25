public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[11];
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
        EmployeeBook employeeBook = new EmployeeBook(employees);

        employeeBook.printAllEmployees();
        System.out.println("employeeBook.addNewEmployee(\"Прохор\", 3, 90000) = " + employeeBook.addNewEmployee("Прохор", 2, 90000));
        employeeBook.printAllEmployees();
        //System.out.println("employeeBook.deleteEmployee(11) = " + employeeBook.deleteEmployee(11));
        employeeBook.printAllEmployees();
        employeeBook.findMaxSalaryEmployee();
        employeeBook.findMinSalaryEmployee();
        employeeBook.showSalarySum();
        employeeBook.showSalaryAverage();
        employeeBook.increaseSalaryForAll(10);
        employeeBook.findMinSalaryEmployeeInDepartment(1);
        employeeBook.findMaxSalaryEmployeeInDepartment(1);
        employeeBook.showSalarySumInDepartment(1);
        employeeBook.increaseSalaryForDepartment(5,1);
        employeeBook.printAllEmployeesInDepartment(1);
        employeeBook.showAllWithLowerSalary(100_000);
        employeeBook.showAllWithUpperSalary(400_000);
        employeeBook.addNewEmployee("sam", 3, 150_000);
        employeeBook.deleteEmployee(1);
    }
}






