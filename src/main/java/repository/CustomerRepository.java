package repository;

import entity.Contact;
import entity.DiscountCode;
import entity.Location;
import entity.MicroMarket;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;


public class CustomerRepository {
    
    private final DataSource dataSource;
    
    // Constructor
    public CustomerRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Customer find(String login, Integer password) throws RepositoryException {

        String sql = "SELECT customer_id, discount_code.discount_code AS discount_code, rate, "
                + "    zip, name, addressline1, addressline2, city, state, phone, fax, email, "
                + "    credit_limit, radius, area_length, area_width"
                + " FROM customer"
                + " INNER JOIN discount_code ON customer.discount_code = discount_code.discount_code"
                + " INNER JOIN micro_market ON customer.zip = micro_market.zip_code"
                + " WHERE email = ? AND customer_id = ?";
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setString(1, login);
            stmt.setInt(2, password);

            try (
                ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    return new Customer(
                        rs.getInt("customer_id"), 
                        rs.getString("name"),
                        new DiscountCode(
                            rs.getString("discount_code").charAt(0),
                            rs.getFloat("rate")
                        ),
                        rs.getInt("credit_limit"),
                        new Location(
                            rs.getString("addressline1"), 
                            rs.getString("addressline2"), 
                            new MicroMarket(
                                rs.getString("zip"),
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
                        )
                    );
                }
                else
                    throw new SQLException("User not found.");
            }
        } catch (SQLException e) {
            throw new RepositoryException("CustomerRepository:find - " + e.getMessage());
        }
    }
    
    public void save(Customer user) throws RepositoryException {
        String sql = "UPDATE customer"
                + " SET name = ?, credit_limit = ?,"
                + "    addressline1 = ?, addressline2 = ?, zip = ?, city = ?, state = ?,"
                + "    email = ?, phone = ?, fax = ?"
                + " WHERE customer_id = ?";
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setString(1,  user.getName());
            stmt.setInt(   2,  user.getCredit());
            
            stmt.setString(3,  user.getLocation().getAddressLine_1());
            stmt.setString(4,  user.getLocation().getAddressLine_2());
            stmt.setString(5,  user.getLocation().getMicroMarket().getZipCode());
            stmt.setString(6,  user.getLocation().getCity());
            stmt.setString(7,  user.getLocation().getState());
            
            stmt.setString(8,  user.getContact().getEmail());
            stmt.setString(9,  user.getContact().getPhone());
            stmt.setString(10, user.getContact().getFax());
            
            stmt.setInt(11, user.getId());

            if (1 != stmt.executeUpdate())
                throw new SQLException("Failed to save User.");
            
        } catch (SQLException e) {
            throw new RepositoryException("CustomerRepository:save - " + e.getMessage());
        }
    }
}
