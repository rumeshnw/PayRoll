package au.com.payroll.service

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import au.com.payroll.factory.ResourceFactory
import au.com.payroll.service.process.EmployeePaySlipGenerator
import au.com.payroll.service.process.PaySlipGenerator
import org.junit.Rule
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.modules.junit4.rule.PowerMockRule
import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges

/**
 * Created by rnadeera on 26/6/17.
 */
class PayrollServiceImplSpec extends Specification {

    PayrollServiceImpl payRollService

    def setup(){
        payRollService = ResourceFactory.getPayrollService()
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
        payRollService.paySlipGenerator = Mock(EmployeePaySlipGenerator){
            1 * generatePaySlip(*_) >> new PaySlip.PaySlipBuilder().setFirstName(employee.firstName).setLastName(employee.lastName).build()
        }

        when:
        PaySlip paySlip = payRollService.generatePaySlip(employee)

        then:
        paySlip.firstName   == employee.firstName
        paySlip.lastName    == employee.lastName
    }
}
