package entity;


public class Location {
    
    private String addressLine_1;
    private String addressLine_2;
    private MicroMarket microMarket;
    private String city;
    private String state;
    
    // Constructor
    public Location(String addressLine_1, String addressLine_2, MicroMarket microMarket, String city, String state) {
        this.addressLine_1 = addressLine_1;
        this.addressLine_2 = addressLine_2;
        this.microMarket = microMarket;
        this.city = city;
        this.state = state;
    }
    
    // Getters && Setters
    public String getAddressLine_1() {
        return addressLine_1;
    }

    public void setAddressLine_1(String addressLine_1) {
        this.addressLine_1 = addressLine_1;
    }

    public String getAddressLine_2() {
        return addressLine_2;
    }

    public void setAddressLine_2(String addressLine_2) {
        this.addressLine_2 = addressLine_2;
    }

    public MicroMarket getMicroMarket() {
        return microMarket;
    }

    public void setMicroMarket(MicroMarket microMarket) {
        this.microMarket = microMarket;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
