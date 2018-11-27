package entity;


public class Manufacturer {
    
    private Integer id;
    private String name;
    private Location location;
    private Contact contact;
    private String rep;
    
    // Constructor
    public Manufacturer(Integer id, String name, Location location, Contact contact, String rep) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.rep = rep;
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

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }
    
}
