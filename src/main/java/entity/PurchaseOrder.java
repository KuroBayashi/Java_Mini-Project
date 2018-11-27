package entity;

import java.sql.Date;


public class PurchaseOrder {
    
    private Integer num;
    private Customer customer;
    private Product product;
    private Integer quantity;
    private float shippingCost;
    private Date salesDate;
    private Date shippingDate;
    private String freightCompany;
    
    // Constructor
    public PurchaseOrder(Integer num, Customer customer, Product product, Integer quantity, float shippingCost, Date salesDate, Date shippingDate, String freightCompany) {
        this.num = num;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.shippingCost = shippingCost;
        this.salesDate = salesDate;
        this.shippingDate = shippingDate;
        this.freightCompany = freightCompany;
    }
    
    // Getters && Setters
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getFreightCompany() {
        return freightCompany;
    }

    public void setFreightCompany(String freightCompany) {
        this.freightCompany = freightCompany;
    }
    
}
