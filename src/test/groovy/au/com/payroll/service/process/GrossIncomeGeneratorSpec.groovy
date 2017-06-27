package au.com.payroll.service.process

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class GrossIncomeGeneratorSpec extends Specification {

    GrossIncomeGenerator grossIncomeGenerator

    def setup(){
        grossIncomeGenerator = new GrossIncomeGenerator(new EmployeePaySlipGenerator())
    }

    def "test generatePaySlip, should calculate and set gross income from employee annual salary and return PaySlip instance"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe")
                .setAnnualSalary(60050).build()

        when:
        PaySlip paySlip = grossIncomeGenerator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

        then:
        paySlip

        paySlip.grossIncome == Math.round(60050/12)
    }
}
