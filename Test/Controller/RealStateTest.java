//package Controller;
//
//import Domain.Customer;
//import Exceptions.PropertyException;
//import org.junit.Test;
//import Domain.Renter;
//
//import java.io.ByteArrayOutputStream;
//
//import static org.junit.Assert.*;
//
//public class RealStateTest {
//
//    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    protected  String out;
//
//    RealState testRealEstate = new RealState();
////    Customer testRnter = new Renter("ddd", "123", "Harindu", "harindu@gmail.com", Customer.Type.Renter, 12321,
////            "Doctor");
//
//    @Test (expected = PropertyException.class)
//    public void registerCustomer() throws PropertyException{
//        String custId = "ddd";
//        testRealEstate.customerCollection.put(custId,new Renter("ddd", "123", "Harindu", "harindu@gmail.com",
//                Customer.Type.Renter, 12321, "Doctor"));
//    }
//
//    @Test
//    public void validateCustomer(){
//        String CustomerId = "L001";
//        testRealEstate.validateCustomer(CustomerId);
//        //assertEquals("Invalid Customer!");
//    }
//}