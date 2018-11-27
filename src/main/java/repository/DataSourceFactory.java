package repository;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientDataSource;

public class DataSourceFactory {

    public static DataSource getDataSource() throws SQLException {
        ClientDataSource ds = new ClientDataSource();

        ds.setDatabaseName("sample");
        ds.setUser("app");
        ds.setPassword("app");
        ds.setServerName("localhost");
        ds.setPortNumber(1527);

        return ds;
    }
}