public class EmployeeManagementSystem {
    public static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        public void display() {
            System.out.println("Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
        }
    }

    public static class EmployeeManagement {
        private Employee[] employees;
        private int size;

        public EmployeeManagement(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        public void addEmployee(Employee employee) {
            if (size < employees.length) {
                employees[size++] = employee;
            } else {
                System.out.println("Array is full. Cannot add more employees.");
            }
        }
        public Employee searchEmployee(String employeeId) {
            for (int i = 0; i < size; i++) {
                if(employees[i].getEmployeeId().equals(employeeId)) {
                    return employees[i];
                }
            }
            return null;
        }

        public void display() {
            if (size == 0) {
                System.out.println("No employees to display.");
                return;
            }
            for (int i = 0; i < size; i++) {
                employees[i].display();
            }
        }

        public void delete(String employeeId) {
            int f = -1;
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    f = i;
                    break;
                }
            }

            if (f == -1) {
                System.out.println("Employee not found.");
                return;
            }

            for (int i = f; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
        }
    }
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);

       
        em.addEmployee(new Employee("E1", "A", "Developer", 70000));
        em.addEmployee(new Employee("E2", "B", "Manager", 90000));
        em.addEmployee(new Employee("E3", "C", "Analyst", 60000));

       
        System.out.println("All Employees:");
        em.display();

       
        System.out.println("\nSearching for employee E2:");
        Employee emp = em.searchEmployee("E2");
        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee not found.");
        }

       
        System.out.println("\nDeleting employee E2:");
        em.delete("E2");

       
        System.out.println("\nAll Employees after deletion:");
        em.display();
    }
}
