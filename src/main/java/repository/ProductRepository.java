package repository;

import entity.Manufacturer;
import entity.Product;
import entity.ProductCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class ProductRepository {
    
    private DataSource dataSource;
    
    // Constructor
    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    // Methods
    
    public List<Product> findAll() throws RepositoryException {
        
        List<Product> productList = new ArrayList<>();
        
        String sql = "SELECT ";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ) {
            
            while (rs.next()) {
                productList.add(new Product(
                    rs.getInt("product_id"),
                    new Manufacturer(), 
                    new ProductCode(), 
                    0.0f, 
                    0, 
                    0.0f, 
                    false, 
                    ""
                ));
            }
            
            return productList;
        } 
        catch (SQLException e) {
            throw new RepositoryException("ProductRepository:findAll - " + e.getMessage());
        }
        
    }
}
