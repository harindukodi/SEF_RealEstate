package Domain;

public abstract class  Customer {
    private String CustId;
    private String Password;
    private String Name;
    private String Email;
    public enum Type {Renter, Buyer, LandLord, Vendor}
    private Type Type;

    public Customer(String CustId, String Password, String Name, String Email, Type Type){
        this.CustId = CustId;
        this.Password = Password;
        this.Name = Name;
        this.Email = Email;
        this.Type = Type;
    }

    public String getCustId() {
                return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Customer.Type getType() {
        return Type;
    }

    public void setType(Customer.Type type) {
        Type = type;
    }

    public String getPassword() {
        return Password;
    }

}
