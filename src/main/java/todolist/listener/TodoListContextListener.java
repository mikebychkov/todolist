package todolist.listener;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import todolist.store.Storage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TodoListContextListener implements ServletContextListener {

    private static final Logger logger = LogManager.getLogger(TodoListContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("=== contextInitialized === BEGIN ===");
        System.out.println(Storage.getInstance());
        logger.info("=== contextInitialized === END ===");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("=== contextDestroyed === BEGIN ===");
        Storage.getInstance().getSessionFactory().close();
        Storage.getInstance().getServiceRegistry().close();
        logger.info("=== contextDestroyed === END ===");
    }
}
