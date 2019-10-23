package Domain;

import java.util.HashMap;

public abstract class PropertySupplier extends Customer{

    public PropertySupplier(String CustId, String Password, String Name, String Email, Type Type){
        super(CustId, Password, Name, Email, Type);
    }

    public abstract void addProperty(String propertyId, String address, String suburb, int numOfBedrooms, int numOfBathrooms,
                                     int numOfCarSpaces, String type, PropertySupplier loggedInCustomer, double weeklyRental,
                                     double contractDuration, HashMap propertyCollection);
}
