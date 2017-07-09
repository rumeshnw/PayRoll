package au.com.payroll.service.process

import au.com.payroll.domain.IncomeTax
import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import au.com.payroll.repository.IncomeTaxRepositoryImpl
import spock.lang.Specification

/**
 * @author rnadeera
 */
class IncomeTaxGeneratorSpec extends Specification {

    IncomeTaxGenerator incomeTaxGenerator

    def setup(){
        incomeTaxGenerator = new IncomeTaxGenerator(new EmployeePaySlipGenerator())
    }

    def "test generatePaySlip, should set tax value and zero when annual salary is not in taxable margin"(){
        given:
        IncomeTax incomeTax = Mock(IncomeTax){
            1 * isTaxable() >> false
        }

        and:
        incomeTaxGenerator.incomeTaxRespository = Mock(IncomeTaxRepositoryImpl){
            1 * findByIncomeBracket(_) >> Optional.of(incomeTax)
        }

        and:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe")
                .setAnnualSalary(60050).build()

        when:
        PaySlip paySlip = incomeTaxGenerator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

        then:
        paySlip.incomeTax == 0
    }

    def "test generatePaySlip, should calculate and set income tax base on annual salary and tax details for the salary group"(){
        given:
        IncomeTax incomeTax = Spy(IncomeTax){
            1 * isTaxable() >> true
        }

        incomeTax.marginalTax   = 3572
        incomeTax.threshold     = 37000
        incomeTax.unitRate      = 0.325

        and:
        incomeTaxGenerator.incomeTaxRespository = Mock(IncomeTaxRepositoryImpl){
            1 * findByIncomeBracket(_) >> Optional.of(incomeTax)
        }

        and:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe")
                .setAnnualSalary(60050).build()

        when:
        PaySlip paySlip = incomeTaxGenerator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

        then:
        paySlip.incomeTax == 922
    }
}
