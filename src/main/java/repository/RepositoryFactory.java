package repository;

import java.sql.SQLException;


public class RepositoryFactory {
    
    public static CustomerRepository getCustomerRepository() throws SQLException {
        return new CustomerRepository(DataSourceFactory.getDataSource());
    }
    
    public static MicroMarketRepository getMicroMarketRepository() throws SQLException {
        return new MicroMarketRepository(DataSourceFactory.getDataSource());
    }
    
    public static PurchaseOrderRepository getPurchaseOrderRepository() throws SQLException {
        return new PurchaseOrderRepository(DataSourceFactory.getDataSource());
    }
}
