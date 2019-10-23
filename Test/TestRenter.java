//import Domain.Customer;
//import Domain.Renter;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestRenter {
//
//    private static String CustId;
//    private static String Name;
//    private static String Email;
//    private static Customer.Type Type;
//    private static double Income;
//    private static String Occupation;
//    private static Renter renter;
//    List<RentalApplication> rentalApplications;
//
//    @BeforeAll
//    static void setup(){
//        //Fixtures
//        CustId = "C_001";
//        Name = "Jack Silva";
//        Email = "jack@gmail.com";
//        Type = Customer.Type.Renter;
//        Income = 20000.0;
//        Occupation  = "Doctor";
//        renter = new Renter(CustId,Name,Email,Type,Income,Occupation);
//
//    }
//
//    @Test
//    void testApplyProperty(){
//
//        //Actions
//        double weeklyRental = 1000.0;
//        double contractDuration = 1.0;
//        RentalApplication newApplication = renter.applyProperty(weeklyRental, contractDuration);
//        rentalApplications.add(newApplication);
//
//        //Actual Result
//        int actualResult = rentalApplications.size(); //Get the size of the arrayList RentalApplications
//
//        //Expected Results
//        int expectedResult = 1;
//
//        //Assertions
//        assertEquals(1, actualResult);
//    }
//
//    @Test
//    void testWithdrawApplication(){
//        //Actions
//        double weeklyRental = 1000;
//        double contractDuration = 1;
//        renter.applyProperty(weeklyRental, contractDuration);
//
//        //Actual Results
//        int actualResult = renter.getSize(); //Get the size of the array RentalApplications
//
//        //Expected Results
//        int expectedResult = 1;
//
//        //Assertions
//        assertEquals(1, actualResult);
//    }
//
//    @Test
//    void payBond(){
//
//    }
//}
