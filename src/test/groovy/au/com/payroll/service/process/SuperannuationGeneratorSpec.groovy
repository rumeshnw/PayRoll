package au.com.payroll.service.process

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class SuperannuationGeneratorSpec extends Specification {

    SuperannuationGenerator superannuationGenerator

    def setup(){
        superannuationGenerator = new SuperannuationGenerator(new EmployeePaySlipGenerator())
    }

    def "test generatePaySlip, should calculate and set super amount based on gross income and super rate"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setSuperRate(9).build()

        and:
        PaySlip.PaySlipBuilder paySlipBuilder = new PaySlip.PaySlipBuilder().setGrossIncome(5004)

        when:
        PaySlip paySlip = superannuationGenerator.generatePaySlip(paySlipBuilder, employee)

        then:
        paySlip.superannuation == 450
    }
}
