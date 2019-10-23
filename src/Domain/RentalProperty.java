package Domain;

import java.util.HashMap;

public class RentalProperty extends Property {

    private int managementFee = 8;
    private double weeklyRental;
    private double contractDuration;

    public RentalProperty(String propertyId, String address, String suburb, int numOfBedrooms, int numOfBathrooms, int numOfCarSpaces,
                          Type type, Status status, boolean isVerified, Customer owner, Employee assignedEmployee, double weeklyRental,
                          double contractDuration){
        super(propertyId, address, suburb, numOfBedrooms, numOfBathrooms, numOfCarSpaces, type, status, isVerified, owner, assignedEmployee);
        int managementFee = 8;
        this.weeklyRental = weeklyRental;
        this.contractDuration = contractDuration;
    }

    public int getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(int managementFee) {
        this.managementFee = managementFee;
    }

    public double getWeeklyRental() {
        return weeklyRental;
    }

    public void setWeeklyRental(double weeklyRental) {
        this.weeklyRental = weeklyRental;
    }

    public double getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(double contractDuration) {
        this.contractDuration = contractDuration;
    }

    public int calManagementFee(double rentalAmount,int count) {
        if(count == 1) {
            System.out.println("The management Fee are: " );
            return managementFee = (int) (0.08 * weeklyRental);
        }else if (count == 2) {
            System.out.println("The management Fee are: " );
            return managementFee = (int) (0.07 * weeklyRental);
        }else if (count >= 3) {
            System.out.println("The management Fee are: " );
            return managementFee = (int) (0.07 * weeklyRental);

        }
        return managementFee;

    }

    //  an initial method of calculate the management fees

    public int calManagementFee(String propertyId, HashMap propertyCollection, HashMap customerCollection){
        int count = 0;
        // there are 3 conditions need to be satisfied: 1.property isVerified 2.Status equals UnderContract 3. correct propertyID
        if(isVerified() == true && Property.Status.UnderContract.equals(getStatus()) && propertyCollection.containsKey(propertyId) ) {
            for (Object Property : propertyCollection.keySet()) {
                if (customerCollection.get(getAssignedEmployee().equals(propertyCollection.get(getOwner()))) != null ){
                    count ++;
                }
            }
        }
        return count;
    }


//    public void viewRentalProperty(HashMap propertyCollection) {
//        try {
//            for(Property Property : propertyCollection.keySet()) {
//                System.out.println( Property + propertyCollection.get(Property));
//            }
//        }
//        catch (Exception viewException) {
//            System.out.println("Exception thrown:" + viewException);}
//    }


    //    check the Status of the Rental Property
    public void checkRentalStatus(Status status) throws Exception{
        if (Property.Status.UnderContract.equals(getStatus())) {
            System.out.println("This Rental Property have not rented yet");
        } else if (Property.Status.Available.equals(getStatus())){
            System.out.println("This Rental Property is already rented");
        } else if (Property.Status.let.equals(getStatus())){
            System.out.println("This Rental Property is in let");
        }else {
            throw new Exception();
        }
    }

    //  check if the property is Verified or not
    public  void checkVerified(boolean isVerified) throws Exception{
        if(isVerified() == true) {
            return;
        }else {System.out.println("This property have not been verified yet!");}

    }


}
