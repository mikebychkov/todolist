package todolist.store;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.Function;

public class ModelDB {

    public static <T> T tx(final Function<Session, T> command) {
        final Session session = Storage.getInstance().getSessionFactory().openSession();
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
