package todolist.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import todolist.model.Item;

import java.util.List;
import java.util.function.Function;

public class ItemDB {

    private ItemDB() {
    }

    private static SessionFactory sf() {
        return Storage.getInstance().getSessionFactory();
    }

    public static Item save(Item item) {
/*
        Session session = sf().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
*/
        tx(session -> session.save(item));
        return item;
    }

    public static Item update(Item item) {
/*
        Session session = sf().openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
*/
        tx(session -> {session.update(item); return 0;});
        return item;
    }

    public static Item saveOrUpdate(Item item) {
/*
        Session session = sf().openSession();
        session.beginTransaction();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
        session.close();
*/
        tx(session -> {session.saveOrUpdate(item); return 0;});
        return item;
    }

    public static Item getItem(int id) {
/*
        Session session = sf().openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
*/
        return tx(session -> session.get(Item.class, id));
    }

    public static List<Item> getItemList() {
//        Session session = sf().openSession();
//        session.beginTransaction();
//        List result = session.createQuery("FROM todolist.model.Item").list();
//        session.getTransaction().commit();
//        session.close();
//        return result;
        return tx(session -> session.createQuery("FROM todolist.model.Item").list());
    }

    public static List<Item> getActualItemList() {
//        Session session = sf().openSession();
//        session.beginTransaction();
//        List result = session.createQuery("FROM todolist.model.Item WHERE done = null").list();
//        session.getTransaction().commit();
//        session.close();
//        return result;
        return tx(session -> session.createQuery("FROM todolist.model.Item WHERE done = null").list());
    }

    private static <T> T tx(final Function<Session, T> command) {
        final Session session = sf().openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
