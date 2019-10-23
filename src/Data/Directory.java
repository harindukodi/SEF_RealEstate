package Data;

import Domain.Customer;
import Domain.Employee;

import java.util.HashMap;

//import Domain.Customer;

/**
 * The class holding the entire data collections of the S&E Real State Company.
 *
 * @author Harindu Kodituwakku
 */

public class Directory {
    /**
     * Creating an HashMap to store all the customers
     */
    private final HashMap<String, Customer> customerCollection = new HashMap<String, Customer>();
    private final HashMap<String, Employee> employeeCollection = new HashMap<String, Employee>();

    public HashMap<String, Customer> getCustomerCollection() {
        return customerCollection;
    }

    public HashMap<String, Employee> getEmployeeCollection() {
        return employeeCollection;
    }
}
