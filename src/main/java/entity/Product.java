package entity;


public class Product {
    
    private Integer id;
    private Manufacturer manufacturer;
    private ProductCode code;
    private float purchaseCost;
    private Integer quantity;
    private float markup;
    private Boolean available;
    private String description;
    
    // Constructor
    public Product(Integer id, Manufacturer manufacturer, ProductCode code, float purchaseCost, Integer quantity, float markup, Boolean available, String description) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.code = code;
        this.purchaseCost = purchaseCost;
        this.quantity = quantity;
        this.markup = markup;
        this.available = available;
        this.description = description;
    }
    
    // Getters && Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductCode getCode() {
        return code;
    }

    public void setCode(ProductCode code) {
        this.code = code;
    }

    public float getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(float purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getMarkup() {
        return markup;
    }

    public void setMarkup(float markup) {
        this.markup = markup;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
