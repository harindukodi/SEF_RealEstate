public class RentalApplication {
    private double weeklyRental;
    private double contractDuration;

    RentalApplication(double WeeklyRental, double ContractDuration){}

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
}