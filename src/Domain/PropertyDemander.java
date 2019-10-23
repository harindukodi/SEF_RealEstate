package Domain;

import java.util.ArrayList;
import java.util.HashMap;

public class PropertyDemander extends Customer {

    private ArrayList<String> favSuburbs = new ArrayList<>();

    public PropertyDemander(String CustId, String Password, String Name, String Email, Type Type, ArrayList<String> favSuburbs) {
        super(CustId, Password, Name, Email, Type);
        this.favSuburbs = favSuburbs;
    }

    public ArrayList<String> getFavSuburbs() {
        return favSuburbs;
    }

    public void setFavSuburbs(ArrayList<String> favSuburbs) {
        this.favSuburbs = favSuburbs;
    }
}


