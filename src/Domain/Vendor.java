package Domain;

import java.util.HashMap;

public class Vendor extends PropertySupplier{
    public Vendor(String CustId, String Password, String Name, String Email, Type Type){
        super(CustId, Password, Name, Email, Type);
    }

    @Override
    public void addProperty(String propertyId, String address, String suburb, int numOfBedrooms, int numOfBathrooms,
                            int numOfCarSpaces, String type, PropertySupplier loggedInCustomer, double salesAmount,
                            double minSettlement, HashMap propertyCollection) {

        propertyCollection.put(propertyId, new RentalProperty(propertyId, address, suburb, numOfBedrooms, numOfBathrooms, numOfCarSpaces,
                Property.Type.Flat, Property.Status.Available, false, loggedInCustomer,null, salesAmount, minSettlement));

    }
}
