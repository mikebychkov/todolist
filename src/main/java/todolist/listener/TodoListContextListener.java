package todolist.listener;

import org.hibernate.service.ServiceRegistry;
import todolist.store.Storage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TodoListContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener#contextInitialized BEGIN");
        System.out.println(Storage.getInstance());
        System.out.println("ServletContextListener#contextInitialized END");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("TodoListContextListener#contextDestroyed BEGIN");
        Storage.getInstance().getSessionFactory().close();
        Storage.getInstance().getServiceRegistry().close();
        System.out.println("TodoListContextListener#contextDestroyed END");
    }
}
