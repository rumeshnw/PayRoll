package au.com.payroll.service

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import au.com.payroll.factory.ResourceFactory
import au.com.payroll.service.process.EmployeePaySlipGenerator
import spock.lang.Specification

/**
 * Created by rnadeera on 26/6/17.
 */
class PayrollServiceImplSpec extends Specification {

    PayrollService payRollService

    def setup(){
        payRollService = ResourceFactory.getPayrollService()
    }

    def cleanup(){
        ResourceFactory.metaClass = null
    }

    def "test generatePaySlip, should throw IllegalArgumentException when employee param is null"(){
        when:
        payRollService.generatePaySlip(null)

        then:
        def e       = thrown(IllegalArgumentException)
        e.message   == "employee details required"
    }

    def "test generatePaySlip, should return generated PaySlip instance when validate Employee instance is provided"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe").build()

        and:
        EmployeePaySlipGenerator employeePaySlipGenerator = Spy(EmployeePaySlipGenerator){
            1 * generatePaySlip(*_) >> new PaySlip.PaySlipBuilder().setFirstName(employee.firstName).setLastName(employee.lastName).build()
        }

        and:
        ResourceFactory.metaClass.static.getPaySlipGenerator = employeePaySlipGenerator

        when:
        PaySlip paySlip = payRollService.generatePaySlip(employee)

        then:
        paySlip.firstName   == employee.firstName
        paySlip.lastName    == employee.lastName
    }
}
