package au.com.payroll.transaction;

import au.com.payroll.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Functional interface to manage hibernate session
 *
 * @author rnadeera
 */
public interface Transactional {

    default void withTransaction(Consumer<Session> sessionConsumer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            sessionConsumer.accept(session);
            tx.commit();
        } catch (Exception e){
            Optional.of(tx).ifPresent(t -> t.rollback());
        } finally {
            session.close();
        }
    }
}
