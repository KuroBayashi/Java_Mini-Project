package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ApplicationListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        if (!databaseExists()) {
//            initializeDatabase();
//        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
