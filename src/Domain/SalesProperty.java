package Domain;

import java.util.HashMap;

public class SalesProperty extends Property {

    private int salesCommissionRate;
    private double salesPrice;
    private double minSalesPrice;
    private boolean isSection32Ready = false;


    public SalesProperty(String propertyId, String address, String suburb, int numOfBedrooms, int numOfBathrooms, int numOfCarSpaces,
                         Type type, Status status, boolean isVerified, Customer owner, Employee assignedEmployee, int salesCommissionRate, double salesPrice,
                         double minSalesPrice, boolean isSection32Ready) {
        super(propertyId, address, suburb, numOfBedrooms, numOfBathrooms, numOfCarSpaces, type, status, isVerified, owner, assignedEmployee);
        this.salesCommissionRate = salesCommissionRate;
        this.salesPrice = salesPrice;
        this.minSalesPrice = minSalesPrice;
        this.isSection32Ready = isSection32Ready;
    }

    public int getSalesCommissionRate() {
        return salesCommissionRate;
    }

    public void setSalesCommissionRate(int salesCommissionRate) {
        this.salesCommissionRate = salesCommissionRate;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getMinSalesPrice() {
        return minSalesPrice;
    }

    public void setMinSalesPrice(double minSalesPrice) {
        this.minSalesPrice = minSalesPrice;
    }

    public boolean isSection32Ready() {
        return isSection32Ready;
    }

    public void setSection32Ready(boolean section32Ready) {
        isSection32Ready = section32Ready;
    }

    public double calcSalesCommission(double salesCommissionRate, double soldPrice) {

        double comm = salesCommissionRate * soldPrice;

        return comm;

    }

    //    public void viewSalesProperty(HashMap propertyCollection) {
//
//        try {
//
//            for (String Property : propertyCollection.keySet()) {
//
//                System.out.println(Property + propertyCollection.get(Property));
//
//            }
//
//        } catch (Exception viewException) {
//
//            System.out.println("Exception thrown:" + viewException);
//        }
//
//    }
    public void checkSalesStatus(Status status) throws Exception {

        if (Property.Status.UnderContract.equals(getStatus())) {

            System.out.println("This Sales Property have not rented yet");

        } else if (Property.Status.Available.equals(getStatus())) {

            System.out.println("This Sales Property is already sold out");

        } else if (Property.Status.let.equals(getStatus())) {

            System.out.println("This Sales Property is in let");

        } else {

            throw new Exception();
        }


    }
}
