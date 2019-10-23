package Domain;

public class BranchManager extends Employee {

    public BranchManager(String empId, String password, String name, double salary, boolean isFullTime){
        super(empId, password, name, salary, isFullTime);
    }

    public void assignEmployee(Property property, Employee employee) {
        property.setAssignedEmployee(employee);
    }

    public void verifyProperty(Property property) {
        property.setVerified(true);
    }
}