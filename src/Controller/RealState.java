package Controller;

import Domain.*;
import Exceptions.PropertyException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RealState {


    private String loggedInUser;
    private int numOfApplications = 0;
    private int numOfCustomers = 3;
    private int numOfProperties = 2;
    private final HashMap<String, Customer> customerCollection = new HashMap<String, Customer>();
    private final HashMap<String, Employee> employeeCollection = new HashMap<String, Employee>();
    private final HashMap<String, Property> propertyCollection = new HashMap<String, Property>();
    private HashMap<String, RentalApplication> rentalApplications = new HashMap<String, RentalApplication>();

    private static RealStateView realStateView = new RealStateView();

    private void initialiseEmployees(){
        employeeCollection.put("P001",new PropertyManager("P001","123","David Jones",10000,true));
        employeeCollection.put("A001",new BranchAdmin("A001","123","Jason Dwell",15000,true));
        employeeCollection.put("B001",new BranchManager("B001","123","Roger Federer",20000,true));
        employeeCollection.put("S001",new SalesConsultant("S001","123","Anna Powell",50000,true));
        customerCollection.put("L001",new Landlord("L001", "123", "Harindu", "harndu@gmail.com", Customer.Type.LandLord));
        customerCollection.put("V001",new Vendor("V001","123","Clark","clark@gmail.com", Customer.Type.Vendor));
        customerCollection.put("R001", new Renter("R001", "123", "Oli", "oli@gmail.com", Customer.Type.Renter,10000,"Doctor"));
        propertyCollection.put("RP001", new RentalProperty("RP001","57, Sandover drive","Essendon",3,2, 2, Property.Type.House, Property.Status.Available,false,customerCollection.get("L001"),null,500,12));
        propertyCollection.put("S001", new SalesProperty("S001","57 Essendon","Essendon",2,2,2, Property.Type.House, Property.Status.Available,false,customerCollection.get("V001"),null,2000,1000,100,false));
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public HashMap<String, Property> getPropertyCollection() {
        return propertyCollection;
    }

    public void Start() {
        Scanner input = new Scanner(System.in);
        String choice;
        boolean exit = false;
        initialiseEmployees();

        while (true) {
            realStateView.PrintMainMenu();

            choice = input.nextLine();
            try {
                switch (choice) {
                    case "1":
                        login();
                        break;
                    case "2":
                        register();
                        break;
                    case "3":
                        System.out.println("Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid entry, please choose another option.\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            if (exit) break;
        }
    }

    private void login() {
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            realStateView.printLoginMenu();
            choice = input.nextLine();
            boolean exit = false;

            switch (choice) {
                case "1": // login as a customer
                    customerLogin();
                    break;
                case "2": // login as an Employee
                    employeeLogin();
                    break;
                case "3": // returns to the main  menu
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    private void register() {
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            realStateView.printRegisterMenu();
            choice = input.nextLine();
            boolean exit = false;

            switch (choice) {
                case "1":
                    registerCustomer();
                    break;
                case "2":
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    public void customerLogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        String CustId = input.nextLine();
        setLoggedInUser(CustId);

        String choice;
        while (true) {
            try {
                validateCustomer(CustId.toUpperCase());
                Customer selectedCustomer = customerCollection.get(CustId);
                System.out.print("Enter Password:");
                String password = input.nextLine();

                validatePassword(selectedCustomer, password);
                char startsWith = CustId.charAt(0);
                switch (startsWith){
                    case 'R':
                        accessRenterController();
                        return;
                    case 'B':
                        accessBuyerController();
                        return;
                    case 'L':
                        accessLandlordController();
                        return;
                    case 'V':
                        accessVendorController();
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void employeeLogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String empId = input.nextLine();
        setLoggedInUser(empId);
        String choice;
        try {
            validateEmployee(empId.toUpperCase());
            Employee selectedEmployee = employeeCollection.get(empId);
            System.out.print("Enter Password:");
            String password = input.nextLine();
            validateEmpPassword(selectedEmployee, password);

            char startsWith = empId.charAt(0);
            switch (startsWith){
                case 'P':
                    accessPropertyManagerController();
                    return;
                case 'B':
                    accessBranchManagerController();
                    return;
                case 'L':
                    accessLandlordController();
                    return;
                case 'V':
                    accessVendorController();
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void assignEmployeeInput() {
        System.out.println("What type of property?\nSales Property:		1\nRental Property:	2");
        Scanner input = new Scanner(System.in);
        String entered = input.nextLine();
        int choice = Integer.parseInt(entered);
        if (choice == 1) {
            Property property;
            Employee employee = null;
            boolean validInput = false;
            do
            {
                System.out.println("Enter property id:\n");
                String enteredPid = input.nextLine();
                property = getSalesProperty(enteredPid);
                if (property == null) System.out.println("invalid property ID");
                else if (property.isVerified() == false) System.out.println("Property not verified.\n");
                else {
                    System.out.println(property);
                    System.out.println("Enter employee id:\n");
                    String enteredEid = input.nextLine();
                    employee = getSalesConsultant(enteredEid);
                    if (employee == null) System.out.println("invlalid employee ID");
                    else {
                        System.out.println(employee);
                        validInput = true;
                        BranchManager loggedInEmployee = (BranchManager) employeeCollection.get(getLoggedInUser());
                        loggedInEmployee.assignEmployee(property, employee);
                        System.out.println(property.getAssignedEmployee()+" has been assigned to "+property.getPropertyId());
                    }
                }
            }while (validInput = false);

        }
        else if (choice == 2) {
            //do for Rental Property
            Property property;
            Employee employee = null;
            boolean validInput = false;
            do
            {
                System.out.println("Enter property id:\n");
                String enteredPid = input.nextLine();
                property = getRentalProperty(enteredPid);
                if (property == null) System.out.println("invalid property ID");
                else if (property.isVerified() == false) System.out.println("Property not verified.\n");
                else {
                    System.out.println(property);
                    System.out.println("Enter employee id:\n");
                    String enteredEid = input.nextLine();
                    employee = getPropertyManager(enteredEid);
                    if (employee == null) System.out.println("invlalid employee ID");
                    else {
                        System.out.println(employee);
                        validInput = true;
                        BranchManager loggedInEmployee = (BranchManager) employeeCollection.get(getLoggedInUser());
                        loggedInEmployee.assignEmployee(property, employee);
                        System.out.println(property.getAssignedEmployee()+" has been assigned to "+property.getPropertyId());
                    }
                }
            }while (validInput = false);
        }
        else System.out.println("Not valid option");
    }

    public Property getProperty(String id) {
        if (propertyCollection.containsKey(id)) {
            Property property = propertyCollection.get(id);
            return property;
        }
        else return null;
    }

    public Employee getPropertyManager(String id) {
        if (employeeCollection.containsKey(id)) {
            Employee employee = employeeCollection.get(id);
            if (employee.getEmpId().toUpperCase().startsWith("P")) {
                return employee;
            }
            else {
                //System.out.println("its emp inner");
                return null;
            }
        }
        else {
            //System.out.println("its emp outer");
            return null;
        }
    }

    public Property getRentalProperty(String id) {
        if (propertyCollection.containsKey(id)) {
            Property property = propertyCollection.get(id);
            if (property.getPropertyId().toUpperCase().startsWith("R")) {
                return property;
            }
            else {
                //System.out.println("its prop inner");
                return null;
            }
        }
        else {
            //System.out.println("its prop outer");
            return null;
        }
    }

    public Property getSalesProperty(String id) {
        if (propertyCollection.containsKey(id)) {
            Property property = propertyCollection.get(id);
            if (property.getPropertyId().toUpperCase().startsWith("S")) {
                return property;
            }
            else return null;
        }
        else return null;
    }

    public Employee getSalesConsultant(String id) {
        if (employeeCollection.containsKey(id)) {
            Employee employee = employeeCollection.get(id);
            if (employee.getEmpId().toUpperCase().startsWith("S")) {
                return employee;
            }
            else return null;
        }
        else return null;
    }

    public void registerCustomer() throws PropertyException{
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("-------------------------------------------------------------");
            System.out.println("For Account Types, Please use the following notations.");
            System.out.println("Type Renters:'R' , Buyer: 'B', Vendors: 'V' , Landlords: 'L'");
            System.out.println("");
            System.out.print("Enter Your Preferred Account Type: ");
            String accountType = input.nextLine().toUpperCase();
            validateCustomerType(accountType);
            System.out.print("Enter preferred password: ");
            String password = input.nextLine();
            System.out.print("Enter your name: ");
            String name = input.nextLine();
            System.out.print("Enter your email: ");
            String email = input.nextLine();
            String custId = generateUserId((accountType.toUpperCase().charAt(0)));
            if (accountType.toUpperCase().startsWith("R")) {
                System.out.print("Enter your monthly income: ");
                double income = input.nextDouble();
                //System.out.print("Enter your occupation: ");
                String occupation = input.nextLine();
                customerCollection.put(custId, new Renter(custId, password, name, email, Customer.Type.Renter, income, occupation));
            } else if (accountType.toUpperCase().startsWith("B")) {
                System.out.println("Enter your favourite suburbs:");
                System.out.println("Enter '0' to exit entering favourite suburbs.");
                ArrayList<String> favSuburbs = new ArrayList<>();
                String favSuburb = "";
                while (!favSuburb.equals("0")){
                    favSuburb = input.nextLine();
                    favSuburbs.add(favSuburb.toUpperCase());
                }
                favSuburbs.remove(favSuburbs.size()-1);
                customerCollection.put(custId, new Buyer(custId, password, name, email, Customer.Type.Buyer, favSuburbs));
                //System.out.println("Fav Sub: " + favSuburbs);
            } else if (accountType.toUpperCase().startsWith("V")) {
                customerCollection.put(custId, new Vendor(custId, password, name, email, Customer.Type.Vendor));
            } else {
                customerCollection.put(custId, new Landlord(custId, password, name, email, Customer.Type.LandLord));
            }

            System.out.println("You have been successfully registered!");
            System.out.println("Your User ID is: " + custId);

            //System.out.println(customerCollection.size());
        }catch (PropertyException e){
            PrintAndHandleExceptions(input, e);
        }
    }

    public void validateCustomer(String CustId) {
        if (!customerCollection.containsKey(CustId)) {
            System.out.println("Invalid Customer!");
            //outContent.write("In");

        }
    }

    private void validateEmployee(String empId) {
        if (!employeeCollection.containsKey(empId)) {
            System.out.println("Invalid Employee!");
        }
    }

    private void validatePassword(Customer selectedCustomer, String password){
        if(!(selectedCustomer.getPassword().equals(password))){
            System.out.println("Invalid Password!");
        }
    }

    private void validateEmpPassword(Employee selectedEmployee, String password){
        if(!(selectedEmployee.getPassword().equals(password))){
            System.out.println("Invalid Password!");
        }
    }

    private void accessRenterController(){
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            realStateView.printRenterMenu();
            choice = input.nextLine();
            boolean exit = false;

            switch (choice) {
                case "1":
                    viewProperties();
                    break;
                case "2":
                    applyRentalProperty();
                    break;
                case "3":
                    break;
                case "4":
                    return;
                case "5":
                    withdrawApplication();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    private void accessBuyerController(){
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            realStateView.printBuyerMenu();
            choice = input.nextLine();
            boolean exit = false;

            switch (choice) {
                case "1":
                    makeOffer();
                    break;
                case "2":
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    private void accessLandlordController(){
        Scanner input = new Scanner(System.in);
        String choice;
        boolean exit = true;
        while (exit) {
            realStateView.printLandlordMenu();
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    addRentalProperty();
                    break;
                case "2":
                    viewRentalApplications();
                    break;
                case "3":
                    makeApplicationDecision();
                    break;
                case "4":
                    calManagmentFee();
                    break;
                case "5":
                    exit=false;
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    private void calManagmentFee() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Property ID:");
        String pId = input.nextLine();
        RentalProperty selectedProperty = (RentalProperty)propertyCollection.get(pId);

    }

    private void viewProperties(){
        for (Property value : propertyCollection.values()){
            System.out.println(value.getDetails());
        }
    }

    private void viewRentalApplications() {
        String userId =  getLoggedInUser();
        for (Property value : propertyCollection.values()) {
            if((value.getOwner().getCustId().equals(userId))) {
                for (RentalApplication val : rentalApplications.values()) {
                    if ((value.getPropertyId().equals(val.getPropertyId()))&&!(val.getStatus().equals(RentalApplication.Status.Rejected))){
                        System.out.println(val.getDetails());
                    }else{
                        System.out.println("No applications!");
                        }
                    }
                }else{
                System.out.println("No new applications!");
            }
        }
    }

    private void withdrawApplication(){
        Scanner input = new Scanner(System.in);
        Renter loggedInEmployee = (Renter) customerCollection.get(getLoggedInUser());
        System.out.print("Enter Application ID:");
        String applicationId = input.nextLine();
        RentalApplication application = rentalApplications.get(applicationId);
        System.out.print("Press 'Y' to withdraw the application or 'N' to go back: ");
        String choice = input.nextLine();
        switch (choice.toUpperCase()){
            case ("Y"):
                loggedInEmployee.withdrawApplication(application);
                System.out.println();
                System.out.println("Application withdrew successfully!");
                break;
            case ("N"):
                break;
            default:
                System.out.println("Invalid entry, please choose another option.\n");
                break;
        }
    }

    private void makeApplicationDecision() {
        Scanner input = new Scanner(System.in);
        Landlord loggedInEmployee = (Landlord) customerCollection.get(getLoggedInUser());
        System.out.print("Enter Application ID:");
        String applicationId = input.nextLine();
        RentalApplication application = rentalApplications.get(applicationId);
        boolean choice = true;
        while (choice == rentalApplications.containsKey(applicationId)) {
            {
                System.out.print("Enter 'Y' to Accept or 'N' to Reject the application: ");
                String decision = input.nextLine();
                if (decision.toUpperCase().equals("Y")) {
                    loggedInEmployee.acceptApplication(application);
                    System.out.println("Application "+applicationId+" accepted successfully!");
                    choice = false;
                    break;
                } else if (decision.toUpperCase().equals("N")) {
                    loggedInEmployee.rejectApplication(application);
                    System.out.println("Application "+applicationId+" rejected!");
                    choice = false;
                    break;
                } else {
                    System.out.println("Invalid input!");
                    choice = true;
                }
            }
            System.out.println("Enter a valid rental Application Id!");
        }
   }

    private void accessPropertyManagerController(){
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            realStateView.printPropertyManagerMenu();
            choice = input.nextLine();
            boolean exit = false;
            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    private void accessBranchManagerController(){
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            realStateView.printBranchManagerMenu();
            choice = input.nextLine();
            boolean exit = false;
            switch (choice) {
                case "1":
                    verifyPropertyInput();
                    break;
                case "2":
                    assignEmployeeInput();
                    break;
                case "3": //Approve work hours of employee
                    return;
                case "4": //Go back to the main menu
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    public void verifyPropertyInput() {
        System.out.println("Enter Property ID: \n");
        Scanner input = new Scanner(System.in);
        String enteredPid = input.nextLine();
        Property property = getProperty(enteredPid);
        if (property == null) System.out.println("No property found.\n");
        else {
            if (property.isVerified() == true) System.out.println("Property is already verified");
            else {
                System.out.println(property + "Verified: "+ property.isVerified());
                System.out.println("Verify Property:  y/n?\n");
                char choice = input.next().charAt(0);
                if (choice == 'n') {
                    System.out.println("Property was not verified.\n");
                }
                else if (choice == 'y') {
                    BranchManager loggedInEmployee = (BranchManager) employeeCollection.get(getLoggedInUser());
                    loggedInEmployee.verifyProperty(property);
                    System.out.println(property.getPropertyId()+" is verified: "+property.isVerified());
                }
                else System.out.println("Not valid option");
            }
        }
    }
    private void accessVendorController(){
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            realStateView.printVendorMenu();
            choice = input.nextLine();
            boolean exit = false;

            switch (choice) {
                case "1":
                    addSalesProperty();
                    break;
                case "2":
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid entry, please choose another option.\n");
                    break;
            }
        }
    }

    private void applyRentalProperty(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter property Id:");
        String pId = input.nextLine();
        System.out.print("Enter desired weekly rental: ");
        int weeklyRental = input.nextInt();
        System.out.print("Enter desired contract duration: ");
        int contractDuration = input.nextInt();
        Renter loggedInCustomer = (Renter) customerCollection.get(getLoggedInUser());
        String applicationId = generateApplicationId("A");
        loggedInCustomer.applyApplication(applicationId, pId, weeklyRental, contractDuration, rentalApplications);
        System.out.println("---------------------------------------------------------");
        System.out.println("Application " + applicationId + " submitted!");
    }

    public String generateApplicationId(String id){
        numOfApplications = numOfApplications+1;
        return String.format(id + "%03d", numOfApplications);
    }

    private void makeOffer(){}

    private void addRentalProperty(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter property address: ");
            String address = input.nextLine();
            System.out.print("Enter suburb: ");
            String suburb = input.nextLine();
            System.out.print("Number of bedrooms: ");
            int numOfBedrooms = input.nextInt();
            System.out.print("Number of bathrooms: ");
            int numOfBathrooms = input.nextInt();
            System.out.print("Number of car spaces: ");
            int numOfCarSpaces = input.nextInt();
            System.out.print("Enter weekly rental amount: ");
            double weeklyRental = input.nextDouble();
            validateWeeklyRental(weeklyRental);
            System.out.print("Enter contract duration: ");
            double contractDuration = input.nextDouble();
            validatecontractDuration(contractDuration);
            System.out.println("Property Type: ");
            String pType = input.nextLine();
            String propertyId = generatePropertyId("RP");
            PropertySupplier loggedInCustomer = (PropertySupplier) customerCollection.get(getLoggedInUser());
            loggedInCustomer.addProperty(propertyId, address, suburb, numOfBedrooms, numOfBathrooms, numOfCarSpaces, pType, loggedInCustomer,
                    weeklyRental, contractDuration, propertyCollection);
            System.out.println("Property "+propertyId+" added to the system!");
        } catch (PropertyException e){
            PrintAndHandleExceptions(input, e);
        }
    }

    private void validateCustomerType(String cType) throws PropertyException{
        if(cType.equals("R") || cType.equals("B") || cType.equals("V") || cType.equals("L")) return;
        else throw new PropertyException(String.format("Invalid Customer type!"));
    }

    private void addSalesProperty(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter property address: ");
            String address = input.nextLine();
            System.out.print("Enter suburb: ");
            String suburb = input.nextLine();
            System.out.print("Number of bedrooms: ");
            int numOfBedrooms = input.nextInt();
            System.out.print("Number of bathrooms: ");
            int numOfBathrooms = input.nextInt();
            System.out.print("Number of car spaces: ");
            int numOfCarSpaces = input.nextInt();
            System.out.print("Enter sales amount: ");
            double salesAmount = input.nextDouble();
            validateWeeklyRental(salesAmount);
            System.out.print("Enter minimum settlement amount: ");
            double minSettlement = input.nextDouble();
            System.out.print("Property Type: ");
            String pType = input.nextLine();

            String propertyId = generatePropertyId("SP");
            PropertySupplier loggedInCustomer = (PropertySupplier) customerCollection.get(getLoggedInUser());
            loggedInCustomer.addProperty(propertyId, address, suburb, numOfBedrooms, numOfBathrooms, numOfCarSpaces, pType, loggedInCustomer,
                    salesAmount, minSettlement, propertyCollection);
        } catch (PropertyException e){
            PrintAndHandleExceptions(input, e);
        }
    }

    private static void PrintAndHandleExceptions(Scanner input, PropertyException e) {
        System.out.println(e.getMessage());
    }

    public void validateWeeklyRental(double weeklyRental) throws PropertyException {
        if (weeklyRental > 0) return;
        else throw new PropertyException(String.format("Invalid rental amount!"));
    }

    public void validatecontractDuration(double contractDuration) throws PropertyException {
        if (contractDuration > 0) return;
        else throw new PropertyException(String.format("Invalid contract duration!"));
    }

    public String generatePropertyId(String id){
        numOfProperties = numOfProperties+1;
        return String.format(id + "%03d", numOfProperties);
    }

    public String generateUserId(char id){
        numOfCustomers = numOfCustomers+1;
        return String.format(id + "%03d", numOfCustomers);
    }
}
