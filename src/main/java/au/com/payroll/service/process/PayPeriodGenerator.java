package au.com.payroll.service.process;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

/**
 * Concrete decorator to add payment period
 *
 * @author rnadeera
 */
public class PayPeriodGenerator extends PaySlipDecorator {

    public PayPeriodGenerator(PaySlipGenerator paySlipGenerator) {
        super(paySlipGenerator);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        setPayPeriod(paySlipBuilder, employee);
        return super.generatePaySlip(paySlipBuilder, employee);
    }

    public void setPayPeriod(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee){
        String[] payPeriodDetails = employee.getPayPeriod().split("/");

        LocalDate localDate = LocalDate.of(Integer.parseInt(payPeriodDetails[1]), Integer.parseInt(payPeriodDetails[0]), 1);
        String month        = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        paySlipBuilder.setPayPeriod(String.format("Month of %s (%d %s to %d %s)", month,
                localDate.with(firstDayOfMonth()).getDayOfMonth(), month,
                localDate.with(lastDayOfMonth()).getDayOfMonth(), month));
    }
}
