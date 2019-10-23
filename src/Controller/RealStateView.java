package Controller;

import Exceptions.PropertyException;

public class RealStateView {

    /**
     * Prints the S&E View.RealState main menu
     */
    public void PrintMainMenu() {
        System.out.println("======================================================================");
        System.out.println("           ****  S&E Real State Agency - MAIN MENU  ****");
        System.out.println("======================================================================");
        System.out.println("Login:                                            1");
        System.out.println("Register:                                         2");
        System.out.println("Exit Program:                                     3");
        System.out.print("Enter your choice: ");
    }

    public void printLoginMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Login as a Customer:                              1");
        System.out.println("Login as an Employee:                             2");
        System.out.println("Go back to the main menu:                         3");
        System.out.print("Enter your choice: ");
    }

    public void printRegisterMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Register as a Customer:                           1");
        System.out.println("Go back to the main menu:                         2");
        System.out.print("Enter your choice: ");
    }

    public void printRenterMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("View rental properties in favourite suburbs:      1");
        System.out.println("Apply for a Rental property:                      2");
        System.out.println("Add a favourite suburb for the watchlist:         3");
        System.out.println("Check notifications:                              4");
        System.out.println("Withdraw an application:                          5");
        System.out.println("Go back to the main menu:                         6");
        System.out.print("Enter your choice: ");
    }

    public void printBuyerMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Make an offer for a Sales property:               1");
        System.out.println("Add a favourite suburb for the watchlist:         2");
        System.out.println("Check notifications:                              3");
        System.out.println("Withdraw an offer:                                4");
        System.out.println("Go back to the main menu:                         5");
        System.out.print("Enter your choice: ");
    }

    public void printLandlordMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Add a Rental property:                            1");
        System.out.println("View rental applications:                         2");
        System.out.println("Accept / Reject applications:                     3");
        System.out.println("Calculate Management Fee:                         4");
        System.out.println("Go back to the main menu:                         5");
        System.out.print("Enter your choice: ");
    }

    public void printVendorMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Add a Sales property:                             1");
        System.out.println("View sales applications:                          2");
        System.out.println("Go back to the main menu:                         3");
        System.out.print("Enter your choice: ");
    }

    public void printPropertyManagerMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Conduct Inspection:                               1");
        System.out.println("Check Maintenance:                                2");
        System.out.println("Perform Maintenance:                              3");
        System.out.println("Advertise Property:                               4");
        System.out.println("Pay Bills:                                        5");
        System.out.println("Calculate Management Fee:                         6");
        System.out.println("Go back to the main menu:                         7");
        System.out.print("Enter your choice: ");
    }

    public void printBranchManagerMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Verify a Property:                                1");
        System.out.println("Assign an employee to a Property:                 2");
        System.out.println("Approve work hours of employee                    3");
        System.out.println("Go back to the main menu:                         4");
        System.out.print("Enter your choice: ");
    }

    public void printBranchAdminMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Calculate salary for staff:                       1");
        System.out.println("Calculate commissions on property sales:          2");
        System.out.println("Calculate payments for landlords:                 3");
        System.out.println("Go back to the main menu:                         4");
        System.out.print("Enter your choice: ");
    }

    public void printSalesConsultantMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Advertise sales properties:                       1");
        System.out.println("Conduct property inspections:                     2");
        System.out.println("Go back to the main menu:                         3");
        System.out.print("Enter your choice: ");
    }
}

