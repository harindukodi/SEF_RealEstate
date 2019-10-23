package Domain;

import java.util.ArrayList;

public class Buyer extends PropertyDemander{

    public Buyer(String CustId, String Password, String Name, String Email, Customer.Type Type, ArrayList<String> favSuburbs){
        super(CustId, Password, Name, Email, Type, favSuburbs);
    }
}
