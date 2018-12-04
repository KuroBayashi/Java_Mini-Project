package repository;

import exception.RepositoryException;
import entity.Contact;
import entity.DiscountCode;
import entity.Location;
import entity.Manufacturer;
import entity.MicroMarket;
import entity.Product;
import entity.ProductCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;


public class ProductRepository {
    
    private final DataSource dataSource;
    
    private final static String SQL_SELECT = ""
        + " SELECT "
        + "     p.product_id, p.purchase_cost, p.quantity_on_hand, p.markup, p.available, p.description AS product_description, "
        + "     m.manufacturer_id, m.name, m.addressline1, m.addressline2, m.city, m.state, m.phone, m.fax, m.email, m.rep, "
        + "     mm.zip_code, mm.radius, mm.area_length, mm.area_width, "
        + "     pc.prod_code, pc.description AS product_code_description, "
        + "     dc.discount_code, dc.rate "
        + " FROM product p "
        + " LEFT JOIN manufacturer  m  ON m.manufacturer_id = p.manufacturer_id "
        + " LEFT JOIN micro_market  mm ON mm.zip_code = m.zip "
        + " LEFT JOIN product_code  pc ON pc.prod_code = p.product_code "
        + " LEFT JOIN discount_code dc ON dc.discount_code = pc.discount_code "
    ;
    
    private final static String SQL_INSERT = ""
        + " INSERT INTO product "
        + "     (manufacturer_id, product_code, purchase_cost, quantity_on_hand, markup, available, description) "
        + " VALUES "
        + "     (?, ?, ?, ?, ?, ?, ?) "
    ;
    
    // Constructor
    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    // Private Methods
    private Product getProduct(ResultSet rs) throws SQLException {
        return new Product(
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
        );
    }
    
    // Public Methods
    public List<Product> findAll() throws RepositoryException {
        
        List<Product> products = new LinkedList<>();
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(ProductRepository.SQL_SELECT);
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next())
                products.add(this.getProduct(rs));
        } 
        catch (SQLException e) {
            throw new RepositoryException("ProductRepository:findAll - " + e.getMessage());
        }
            
        return products;
    }
}
