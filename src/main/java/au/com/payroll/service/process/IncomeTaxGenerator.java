package au.com.payroll.service.process;

import au.com.payroll.domain.IncomeTax;
import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;
import au.com.payroll.factory.ResourceFactory;
import au.com.payroll.repository.IncomeTaxRespository;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Concrete decorator to calculate income tax
 *
 * @author rnadeera
 */
public class IncomeTaxGenerator extends AbstractPaySlipGenerator {

    IncomeTaxRespository incomeTaxRespository;

    public IncomeTaxGenerator(PaySlipGenerator paySlipGenerator) {
        super(paySlipGenerator);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setIncomeTax(calculateTax(employee));
        return super.generatePaySlip(paySlipBuilder, employee);
    }

    public void setIncomeTaxRespository(IncomeTaxRespository incomeTaxRespository) {
        this.incomeTaxRespository = incomeTaxRespository;
    }

    private long calculateTax(Employee employee){

        Optional<IncomeTax> incomeTax = incomeTaxRespository.findByIncomeBracket(employee.getAnnualSalary());
        Assert.isTrue(incomeTax.isPresent(), "Tax definition not available");

        if(incomeTax.get().isTaxable()){
            return Math.round((incomeTax.get().getMarginalTax() + (employee.getAnnualSalary() - incomeTax.get().getThreshold()) * incomeTax.get().getUnitRate()) / 12);
        }

        return 0;
    }
}
