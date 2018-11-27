package entity;


public class DiscountCode {
    
    private char code;
    private float rate;
    
    // Constructor
    public DiscountCode(char code, float rate) {
        this.code = code;
        this.rate = rate;
    }
    
    // Getters && Setters
    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
    
}
