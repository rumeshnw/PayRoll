package au.com.payroll.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Util class to get Hibernate Session Factory
 *
 * @author rnadeera
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
