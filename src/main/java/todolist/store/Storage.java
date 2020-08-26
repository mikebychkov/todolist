package todolist.store;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Storage {

    // HIBERNATE SESSION FACTORY

    private final StandardServiceRegistry registry;
    private final SessionFactory sf;

    private Storage() {
        System.out.println("Starting Hibernate initializing====================");
        registry = new StandardServiceRegistryBuilder().configure().build();
        System.out.println("Registry is builded====================");
        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        System.out.println("Session factory is builded====================");
    }

    private static class Holder {
        private static Storage st = new Storage();
    }

    public static Storage getInstance() {
        return Holder.st;
    }

    public SessionFactory getSessionFactory() {
        return sf;
    }

    public ServiceRegistry getServiceRegistry() {
        return registry;
    }
}
