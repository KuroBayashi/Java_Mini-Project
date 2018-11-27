package entity;


public class Customer {

    private Integer id;

    private String name;
    private DiscountCode discountCode;
    private Integer credit;

    private Location location;
    private Contact contact;

    // Constructor
    public Customer(Integer id, String name, DiscountCode discountCode, Integer credit, Location location, Contact contact) {
        this.id = id;

        this.name = name;
        this.discountCode = discountCode;
        this.credit = credit;

        this.location = location;
        this.contact = contact;
    }

    // Getters && Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
