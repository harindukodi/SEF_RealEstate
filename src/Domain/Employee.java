package Domain;

public class Employee {

    private String empId;
    private String password;
    private String name;
    private double salary;
    private boolean isFullTime = true;

    public Employee(String empId, String password, String name, double salary, boolean isFullTime) {
        this.empId = empId;
        this.password = password;
        this.name = name;
        this.salary = salary;
        this.isFullTime = isFullTime;
    }

    public String getEmpId() {
        return empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    @Override
    public String toString() {
        return name;
    }
}
