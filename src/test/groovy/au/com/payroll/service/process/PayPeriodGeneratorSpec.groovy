package au.com.payroll.service.process

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class PayPeriodGeneratorSpec extends Specification {

    PayPeriodGenerator payPeriodGenerator

    def setup(){
        payPeriodGenerator = new PayPeriodGenerator(new EmployeePaySlipGenerator())
    }

    def "test generatePaySlip, should generate pay period string based on user input pay period format"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setPayPeriod("03/2017").build()

        when:
        PaySlip paySlip = payPeriodGenerator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee)

        then:
        paySlip.payPeriod == "Month of March (1 March to 31 March)"
    }
}
