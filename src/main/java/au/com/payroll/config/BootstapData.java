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
public class BootstapData implements Transactional {

    public void initData(){
        initIncomeTaxData();
    }

    private void initIncomeTaxData(){
        withTransaction((Session session) -> {
            List<IncomeTax> incomeTaxes = new ArrayList<>();
            incomeTaxes.add(new IncomeTax(0l, 18200l, 0l, 0.0, 0.0));
            incomeTaxes.add(new IncomeTax(18201l, 37000l, 0l, 0.19, 18200.0));
            incomeTaxes.add(new IncomeTax(37001l, 80000l, 3572l, 0.325, 37000.0));
            incomeTaxes.add(new IncomeTax(80001l, 180000l, 17547l, 0.37, 80000.0));
            incomeTaxes.add(new IncomeTax(1800001l, 99999999999l, 54547l, 0.45, 180000.0));

            incomeTaxes.forEach(incomeTax -> session.save(incomeTax));
        });
    }
}
