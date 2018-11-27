package entity;


public class MicroMarket {
    
    private String zipCode;
    private float radius;
    private float areaLength;
    private float areaWidth;
    
    // Constructor
    public MicroMarket(String zipCode, float radius, float areaLength, float areaWidth) {
        this.zipCode = zipCode;
        this.radius = radius;
        this.areaLength = areaLength;
        this.areaWidth = areaWidth;
    }
    
    // Getters && Setters
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(float areaLength) {
        this.areaLength = areaLength;
    }

    public float getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(float areaWidth) {
        this.areaWidth = areaWidth;
    }
    
}
