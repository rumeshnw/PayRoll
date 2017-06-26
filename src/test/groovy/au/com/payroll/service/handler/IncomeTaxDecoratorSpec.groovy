package au.com.payroll.service.handler

import au.com.payroll.domain.IncomeTax
import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import au.com.payroll.repository.IncomeTaxRepositoryImpl
import spock.lang.Specification

/**
 * @author rnadeera
 */
class IncomeTaxDecoratorSpec extends Specification {

    IncomeTaxDecorator incomeTaxDecorator

    def setup(){
        incomeTaxDecorator = new IncomeTaxDecorator(new EmployeePaySlip())
    }

    def "test generatePaySlip, should set tax value and zero when annual salary is not in taxable margin"(){
        given:
        IncomeTax incomeTax = Mock(IncomeTax){
            1 * isTaxable() >> false
        }

        and:
        incomeTaxDecorator.incomeTaxRespository = Mock(IncomeTaxRepositoryImpl){
            1 * findByIncomeBracket(_) >> incomeTax
        }

        and:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe")
                .setAnnualSalary(60050).build()

        when:
        PaySlip paySlip = incomeTaxDecorator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

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
        incomeTaxDecorator.incomeTaxRespository = Mock(IncomeTaxRepositoryImpl){
            1 * findByIncomeBracket(_) >> incomeTax
        }

        and:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe")
                .setAnnualSalary(60050).build()

        when:
        PaySlip paySlip = incomeTaxDecorator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

        then:
        paySlip.incomeTax == 922
    }
}
