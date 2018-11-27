package repository;

import entity.MicroMarket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;


public class MicroMarketRepository {
    
    private final DataSource dataSource;
    
    // Constructor
    public MicroMarketRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public MicroMarket find(String zipCode) throws RepositoryException {

        String sql = "SELECT zip_code, radius, area_length, area_width FROM micro_market WHERE zip_code = ?";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
        ) {
            stmt.setString(1, zipCode);

            try (
                ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    return new MicroMarket(
                        rs.getString("zip_code"),
                        rs.getFloat("radius"),
                        rs.getFloat("area_length"),
                        rs.getFloat("area_width")
                    );
                }
                else
                    throw new SQLException("MicroMarket not found.");
            }
        } catch (SQLException e) {
            throw new RepositoryException("MicroMarketRepository:find - " + e.getMessage());
        }
    }
    
    public List<MicroMarket> findAll() throws RepositoryException {
        List<MicroMarket> microMarketList = new LinkedList<>();

        String sql = "SELECT zip_code, radius, area_length, area_width FROM micro_market";
        
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);   
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                microMarketList.add(new MicroMarket(
                    rs.getString("zip_code"),
                    rs.getFloat("radius"),
                    rs.getFloat("area_length"),
                    rs.getFloat("area_width")
                ));
            }
        } catch (SQLException e) {
            throw new RepositoryException("MicroMarketRepository:findAll - " + e.getMessage());
        }

        return microMarketList;
    }
}
