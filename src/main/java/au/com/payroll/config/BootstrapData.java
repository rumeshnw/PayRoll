package au.com.payroll.config;


import au.com.payroll.domain.IncomeTax;
import au.com.payroll.transaction.Transactional;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Class uses to bootstrap initial data required by the application
 *
 * @author rnadeera
 */
public class BootstrapData implements Transactional {

    public void initData(){
        initIncomeTaxData();
    }

    private void initIncomeTaxData(){
        withTransaction((Session session) -> {
            List<IncomeTax> incomeTaxes = new ArrayList<>();
            incomeTaxes.add(new IncomeTax(0, 18200, 0, 0.0, 0.0));
            incomeTaxes.add(new IncomeTax(18201, 37000, 0, 0.19, 18200.0));
            incomeTaxes.add(new IncomeTax(37001, 80000, 3572, 0.325, 37000.0));
            incomeTaxes.add(new IncomeTax(80001, 180000, 17547, 0.37, 80000.0));
            incomeTaxes.add(new IncomeTax(1800001, 999999999, 54547, 0.45, 180000.0));

            incomeTaxes.forEach(incomeTax -> session.save(incomeTax));
        });
    }
}
