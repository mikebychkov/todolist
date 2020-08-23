package todolist.store;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Storage {

    // HIBERNATE FACTORY

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private Storage() {
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
}
