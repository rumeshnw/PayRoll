package au.com.payroll.repository;


import au.com.payroll.domain.IncomeTax;
import au.com.payroll.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @see {@link IncomeTaxRespository}
 *
 * @author rnadeera
 */
public class IncomeTaxRepositoryImpl implements IncomeTaxRespository, Transactional {

    @Override
    public IncomeTax findByIncomeBracket(int income) {
        List<IncomeTax> results = new ArrayList();
        withTransaction((Session session) -> {
            Query<IncomeTax> query = session.createQuery("from IncomeTax t where t.incomeFrom <= :income and t.incomeTo >= :income", IncomeTax.class);
            query.setParameter("income", income);
            results.add(query.getSingleResult());
        });
        return results.isEmpty() ? null : results.get(0);
    }
}
