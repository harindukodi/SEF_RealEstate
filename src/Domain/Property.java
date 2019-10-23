package Domain;

public abstract class Property {

    private String propertyId;
    private String address;
    private String suburb;
    private int numOfBedrooms;
    private int numOfBathrooms;
    private int numOfCarSpaces;
    public enum Type {House, Unit, Flat, Townhouse, Studio}
    private Type type;
    public  enum Status {Available, UnderContract, let}
    private  Status status;
    private boolean isVerified = false;
    private Customer owner;
    private Employee assignedEmployee;

    public Property(String propertyId, String address, String suburb, int numOfBedrooms, int numOfBathrooms, int numOfCarSpaces,
                    Type type, Status status, boolean isVerified, Customer owner, Employee assignedEmployee){
        this.propertyId = propertyId;
        this.address = address;
        this.suburb = suburb;
        this.numOfBedrooms = numOfBedrooms;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfCarSpaces = numOfCarSpaces;
        this.type = type;
        this.status = status;
        this.isVerified = isVerified;
        this.owner = owner;
        this.assignedEmployee = null;
    }

    public String toString() {
        return propertyId + " "+ address + " " + suburb;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getDetails() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("----------------------------------------------------\n"));
        builder.append(String.format("Property ID:                %s\n", propertyId));
        builder.append(String.format("Property address:           %s\n", address));
        builder.append(String.format("Property suburb:            %s\n", suburb));
        builder.append(String.format("Number of bedrooms:         %s\n", numOfBedrooms));
        builder.append(String.format("Number of bathrooms:        %s\n", numOfBathrooms));
        builder.append(String.format("Number of car spaces:       %s\n", numOfCarSpaces));
        builder.append(String.format("Property type:              %s\n", type));
        builder.append(String.format("Property status:            %s\n", status));
        return builder.toString();
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public int getNumOfBathrooms() {
        return numOfBathrooms;
    }

    public void setNumOfBathrooms(int numOfBathrooms) {
        this.numOfBathrooms = numOfBathrooms;
    }

    public int getNumOfCarSpaces() {
        return numOfCarSpaces;
    }

    public void setNumOfCarSpaces(int numOfCarSpaces) {
        this.numOfCarSpaces = numOfCarSpaces;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }


}
