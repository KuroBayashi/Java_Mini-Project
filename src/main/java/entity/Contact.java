package entity;


public class Contact {
        
    private String email;
    private String phone;
    private String fax;
    
    public Contact(String email, String phone, String fax) {
        this.email = email;
        this.phone = phone;
        this.fax = fax;
    }

    // Getters && Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    
}
