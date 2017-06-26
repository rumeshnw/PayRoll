package au.com.payroll.service.handler

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class EmployeePaySlipSpec extends Specification {

    private EmployeePaySlip employeePaySlip

    def setup(){
        employeePaySlip = new EmployeePaySlip()
    }

    def "test generatePaySlip, should generate PaySlip with first name and last name assigned from employee instance"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe").build()

        when:
        PaySlip paySlip = employeePaySlip.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

        then:
        paySlip.getFirstName() == employee.getFirstName()
        paySlip.getLastName()  == employee.getLastName()
    }
}
