package Domain;

import Domain.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Renter extends Customer {

    private double Income;
    private String Occupation;

    public Renter(String CustId, String Password, String Name, String Email, Customer.Type Type, double Income, String Occupation) {
        super(CustId, Password, Name, Email, Type);
        this.Income = Income;
        this.Occupation = Occupation;
    }
    public void applyApplication(String applicationId, String pId, int weeklyRental, int contractDuration,HashMap rentalApplications){
        rentalApplications.put(applicationId, new RentalApplication(applicationId,pId,super.getCustId(), weeklyRental, contractDuration, Income, Occupation, RentalApplication.Status.Processing));
    }


    public  void withdrawApplication(RentalApplication application){
        application.setStatus(RentalApplication.Status.Withdrew);
    }

    public void payBond(){}

    public double getIncome() {
        return Income;
    }

    public void setIncome(double income) {
        Income = income;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

}
