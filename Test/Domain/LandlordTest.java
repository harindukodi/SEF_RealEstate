//package Domain;
//
//import Controller.RealState;
//import Exceptions.PropertyException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.ByteArrayOutputStream;
//
//import static org.junit.Assert.*;
//
//public class LandlordTest {
//
//    //protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    Landlord landlordObject = new Landlord("L002","123", "Harindu", "harindu@gmail.com", Customer.Type.LandLord);
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @Test
//    public void addProperty() throws PropertyException {
//        RealState testRealState = new RealState();
//        String propertyId = "RP001";
//        String result = landlordObject.addProperty("RP001","33 Sandover drive", "Boxhill", 3, 2,2,
//                "Flat",landlordObject, 1000,1);
//
//        assertEquals("Property successfully added to the system!",result);
//    }
//
//    @Test(expected = PropertyException.class)
//    public void addAPropertyWithoutWeeklyRental() throws PropertyException {
//        String result = landlordObject.addProperty("RP001","33 Sandover drive", "Boxhill", 3, 2,2,
//                "Flat",landlordObject, 0,1);
//    }
//
//    @Test(expected = PropertyException.class)
//    public void addAPropertyWithoutContractDuration() throws PropertyException {
//        String result = landlordObject.addProperty("RP001","33 Sandover drive", "Boxhill", 3, 2,2,
//                "Flat",landlordObject, 100,0);
//    }
//}