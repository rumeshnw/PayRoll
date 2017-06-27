package au.com.payroll.service.process

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class EmployeePaySlipGeneratorSpec extends Specification {

    private EmployeePaySlipGenerator employeePaySlipGenerator

    def setup(){
        employeePaySlipGenerator = new EmployeePaySlipGenerator()
    }

    def "test generatePaySlip, should generate PaySlip with first name and last name assigned from employee instance"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe").build()

        when:
        PaySlip paySlip = employeePaySlipGenerator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

        then:
        paySlip.getFirstName() == employee.getFirstName()
        paySlip.getLastName()  == employee.getLastName()
    }
}
