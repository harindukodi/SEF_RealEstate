package Domain;

import java.util.List;

public class RentalApplication {

    private String applicationId;
    private String propertyId;
    private String renterId;
    private int weeklyRental;
    private int contractDuration;
    private double income;
    private String occupation;
    public enum Status {Processing, Rejected, Accepted, Withdrew}
    private Status status;

    public RentalApplication(String applicationId, String propertyId, String renterId,int weeklyRental, int contractDuration, double income, String occupation, Status status) {
        this.applicationId = applicationId;
        this.propertyId = propertyId;
        this.renterId = renterId;
        this.weeklyRental = weeklyRental;
        this.contractDuration = contractDuration;
        this.income = income;
        this.occupation = occupation;
        this.status = status;
    }

    public String getDetails() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("----------------------------------------------------\n"));
        builder.append(String.format("Application ID:                %s\n", applicationId));
        builder.append(String.format("Property ID:                   %s\n", propertyId));
        builder.append(String.format("Applicant ID:                  %s\n", renterId));
        builder.append(String.format("Requested weekly rental:       %s\n", weeklyRental));
        builder.append(String.format("Requested contract duration:   %s\n", contractDuration));
        builder.append(String.format("Applicant monthly income:      %s\n", income));
        builder.append(String.format("Applicant Occupation:          %s\n", occupation));
        builder.append(String.format("Application Status:            %s\n", status));
        return builder.toString();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public int getWeeklyRental() {
        return weeklyRental;
    }

    public void setWeeklyRental(int weeklyRental) {
        this.weeklyRental = weeklyRental;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
