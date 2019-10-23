package Domain;
import Controller.RealState;
import Exceptions.PropertyException;
import javafx.application.Application;

import java.util.HashMap;

public class Landlord extends PropertySupplier{

    public Landlord(String CustId, String Password, String Name, String Email, Type Type){
        super(CustId, Password, Name, Email, Type);
    }

    @Override
    public void addProperty(String propertyId, String address, String suburb, int numOfBedrooms, int numOfBathrooms,
                              int numOfCarSpaces, String type, PropertySupplier loggedInCustomer, double weeklyRental,
                              double contractDuration, HashMap propertyCollection) throws PropertyException{
        propertyCollection.put(propertyId, new RentalProperty(propertyId, address, suburb, numOfBedrooms, numOfBathrooms, numOfCarSpaces,
                Property.Type.Flat, Property.Status.Available, false, loggedInCustomer,null, weeklyRental, contractDuration));
    }

    public void acceptApplication(RentalApplication application){
        application.setStatus(RentalApplication.Status.Accepted);
    }

    public void rejectApplication(RentalApplication application){
        application.setStatus(RentalApplication.Status.Rejected);
    }
}
