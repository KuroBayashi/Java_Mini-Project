package repository;

import entity.Contact;
import entity.Customer;
import entity.DiscountCode;
import entity.Location;
import entity.Manufacturer;
import entity.MicroMarket;
import entity.Product;
import entity.ProductCode;
import entity.PurchaseOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;
import javax.sql.DataSource;


public class PurchaseOrderRepository {
    
    private final DataSource dataSource;
    
    // Constructor
    public PurchaseOrderRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    // Methods
    public PurchaseOrder findByCustomerAndNum(Customer customer, Integer num) throws RepositoryException {
        
        List<PurchaseOrder> purchaseOrderList = new LinkedList<>();
        
        String sql = "SELECT quantity, shipping_cost, sales_date, shipping_date, freight_company,"
                + "    product.product_id, product.purchase_cost, product.quantity_on_hand, product.markup, product.available, product.description AS product_description,"
                + "    manufacturer.manufacturer_id, manufacturer.name, manufacturer.addressline1, manufacturer.addressline2, manufacturer.city, manufacturer.state, manufacturer.phone, manufacturer.fax, manufacturer.email, manufacturer.rep,"
                + "    micro_market.zip_code, micro_market.radius, micro_market.area_length, micro_market.area_width,"
                + "    product_code.prod_code, product_code.description AS product_code_description,"
                + "    discount_code.discount_code, discount_code.rate"
                + " FROM purchase_order"
                + " LEFT JOIN product ON purchase_order.product_id = product.product_id"
                + " LEFT JOIN manufacturer ON product.manufacturer_id = manufacturer.manufacturer_id"
                + " LEFT JOIN micro_market ON manufacturer.zip = micro_market.zip_code"
                + " LEFT JOIN product_code ON product.product_code = product_code.prod_code"
                + " LEFT JOIN discount_code ON product_code.discount_code = discount_code.discount_code"
                + " WHERE customer_id = ? AND order_num = ?";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setInt(1, customer.getId());
            stmt.setInt(2, num);

            try (
                ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    return new PurchaseOrder(
                        num,
                        customer,
                        new Product(
                            rs.getInt("product_id"),
                            new Manufacturer(
                                rs.getInt("manufacturer_id"),
                                rs.getString("name"),
                                new Location(
                                    rs.getString("addressline1"),
                                    rs.getString("addressline2"),
                                    new MicroMarket(
                                        rs.getString("zip_code"),
                                        rs.getFloat("radius"),
                                        rs.getFloat("area_length"),
                                        rs.getFloat("area_width")
                                    ),
                                    rs.getString("city"),
                                    rs.getString("state")
                                ),
                                new Contact(
                                    rs.getString("email"),
                                    rs.getString("phone"),
                                    rs.getString("fax")
                                ),
                                rs.getString("rep")
                            ),
                            new ProductCode(
                                rs.getString("prod_code"),
                                new DiscountCode(
                                    rs.getString("discount_code").charAt(0),
                                    rs.getFloat("rate")
                                ),
                                rs.getString("product_code_description")
                            ),
                            rs.getFloat("purchase_cost"),
                            rs.getInt("quantity_on_hand"),
                            rs.getFloat("markup"),
                            rs.getBoolean("available"),
                            rs.getString("product_description")
                        ),
                        rs.getInt("quantity"),
                        rs.getFloat("shipping_cost"),
                        rs.getDate("sales_date"),
                        rs.getDate("shipping_date"),
                        rs.getString("freight_company")
                    );
                }
                else {
                    throw new SQLException("Purchase order not found.");
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("MicroMarketRepository:findByCustomerAndNum - " + e.getMessage());
        }
    }
    
    public List<PurchaseOrder> findAllByCustomer(Customer customer) throws RepositoryException {
        
        List<PurchaseOrder> purchaseOrderList = new LinkedList<>();
        
        String sql = "SELECT order_num, quantity, shipping_cost, sales_date, shipping_date, freight_company,"
                + "    product.product_id, product.purchase_cost, product.quantity_on_hand, product.markup, product.available, product.description AS product_description,"
                + "    manufacturer.manufacturer_id, manufacturer.name, manufacturer.addressline1, manufacturer.addressline2, manufacturer.city, manufacturer.state, manufacturer.phone, manufacturer.fax, manufacturer.email, manufacturer.rep,"
                + "    micro_market.zip_code, micro_market.radius, micro_market.area_length, micro_market.area_width,"
                + "    product_code.prod_code, product_code.description AS product_code_description,"
                + "    discount_code.discount_code, discount_code.rate"
                + " FROM purchase_order"
                + " LEFT JOIN product       ON purchase_order.product_id = product.product_id"
                + " LEFT JOIN manufacturer  ON product.manufacturer_id = manufacturer.manufacturer_id"
                + " LEFT JOIN micro_market  ON manufacturer.zip = micro_market.zip_code"
                + " LEFT JOIN product_code  ON product.product_code = product_code.prod_code"
                + " LEFT JOIN discount_code ON product_code.discount_code = discount_code.discount_code"
                + " WHERE customer_id = ?";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setInt(1, customer.getId());

            try (
                ResultSet rs = stmt.executeQuery();
            ) {
                while (rs.next()) {
                    purchaseOrderList.add(new PurchaseOrder(
                        rs.getInt("order_num"),
                        customer,
                        new Product(
                            rs.getInt("product_id"),
                            new Manufacturer(
                                rs.getInt("manufacturer_id"),
                                rs.getString("name"),
                                new Location(
                                    rs.getString("addressline1"),
                                    rs.getString("addressline2"),
                                    new MicroMarket(
                                        rs.getString("zip_code"),
                                        rs.getFloat("radius"),
                                        rs.getFloat("area_length"),
                                        rs.getFloat("area_width")
                                    ),
                                    rs.getString("city"),
                                    rs.getString("state")
                                ),
                                new Contact(
                                    rs.getString("email"),
                                    rs.getString("phone"),
                                    rs.getString("fax")
                                ),
                                rs.getString("rep")
                            ),
                            new ProductCode(
                                rs.getString("prod_code"),
                                new DiscountCode(
                                    rs.getString("discount_code").charAt(0),
                                    rs.getFloat("rate")
                                ),
                                rs.getString("product_code_description")
                            ),
                            rs.getFloat("purchase_cost"),
                            rs.getInt("quantity_on_hand"),
                            rs.getFloat("markup"),
                            rs.getBoolean("available"),
                            rs.getString("product_description")
                        ),
                        rs.getInt("quantity"),
                        rs.getFloat("shipping_cost"),
                        rs.getDate("sales_date"),
                        rs.getDate("shipping_date"),
                        rs.getString("freight_company")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("MicroMarketRepository:findAllByCustomer - " + e.getMessage());
        }
        
        return purchaseOrderList;
    }
    
    public void save(PurchaseOrder purchaseOrder) throws RepositoryException {
        
        String sql = "UPDATE purchase_order"
                + " SET quantity = ?, shipping_date = ?"
                + " WHERE order_num = ?";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setInt(1, purchaseOrder.getQuantity());
            stmt.setDate(2, purchaseOrder.getShippingDate());
            stmt.setInt(3, purchaseOrder.getNum());

            if (1 != stmt.executeUpdate())
                throw new SQLException("Failed to save PurchaseOrder.");
                    
        } catch (SQLException e) {
            throw new RepositoryException("MicroMarketRepository:save - " + e.getMessage());
        }
    }
    
    public void delete(Customer customer, Integer num) throws RepositoryException {
        
        String sql = "DELETE FROM purchase_order WHERE order_num = ? AND customer_id = ?";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setInt(1, num);
            stmt.setInt(2, customer.getId());

            if (1 != stmt.executeUpdate())
                throw new SQLException("Failed to delete PurchaseOrder.");
                    
        } catch (SQLException e) {
            throw new RepositoryException("MicroMarketRepository:delete - " + e.getMessage());
        }
    }

    public List<Pair<Float, ProductCode>> findAllGroupByProductCode() throws RepositoryException {
        List<Pair<Float, ProductCode>> productCodeList = new LinkedList<>();
        
        String sql = "SELECT SUM(shipping_cost + quantity * purchase_cost) AS total, prod_code, product_code.discount_code, description, rate"
                + " FROM purchase_order"
                + " LEFT JOIN product ON purchase_order.product_id = product.product_id"
                + " LEFT JOIN product_code ON product.product_code = product_code.prod_code"
                + " LEFT JOIN discount_code ON product_code.discount_code = discount_code.discount_code"
                + " GROUP BY prod_code"
                + " WHERE shipping_date BETWEEN ? AND ?";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            try (
                ResultSet rs = stmt.executeQuery();
            ) {
                while (rs.next()) {
                    productCodeList.add(
                        new Pair<>(
                            rs.getFloat("total"),
                            new ProductCode(
                                rs.getString("prod_code"),
                                new DiscountCode(
                                    rs.getString("discount_code").charAt(0),
                                    rs.getFloat("rate")
                                ),
                                rs.getString("description")
                            )
                        )
                    );
                }
                
                return productCodeList;
            }
        } catch (SQLException e) {
            throw new RepositoryException("MicroMarketRepository:findByCustomerAndNum - " + e.getMessage());
        }
    }
}
