package entity;


public class ProductCode {
    
    private String code;
    private DiscountCode discountCode;
    private String description;
    
    // Constructor
    public ProductCode(String code, DiscountCode discountCode, String description) {
        this.code = code;
        this.discountCode = discountCode;
        this.description = description;
    }
    
    // Getters && Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
