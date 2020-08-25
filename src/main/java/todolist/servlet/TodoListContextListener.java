package todolist.servlet;

import todolist.store.Storage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TodoListContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener#contextInitialized BEGIN");
        Storage.getInstance();
        System.out.println("ServletContextListener#contextInitialized END");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
