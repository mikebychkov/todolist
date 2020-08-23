package todolist.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import todolist.model.Item;

import java.util.List;

public class ItemDB {

    private ItemDB() {
    }

    private static SessionFactory sf() {
        return Storage.getInstance().getSessionFactory();
    }

    public static Item save(Item item) {
        Session session = sf().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static Item update(Item item) {
        Session session = sf().openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static Item saveOrUpdate(Item item) {
        Session session = sf().openSession();
        session.beginTransaction();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static Item getItem(int id) {
        Session session = sf().openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static List<Item> getItemList() {
        Session session = sf().openSession();
        session.beginTransaction();
        List result = session.createQuery("FROM todolist.model.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
