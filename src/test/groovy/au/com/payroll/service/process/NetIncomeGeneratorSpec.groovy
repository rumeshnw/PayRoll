package au.com.payroll.service.process

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class NetIncomeGeneratorSpec extends Specification {

    NetIncomeGenerator netIncomeGenerator

    def setup(){
        netIncomeGenerator = new NetIncomeGenerator(new EmployeePaySlipGenerator())
    }

    def "test generatePaySlip, should calculate and set net income from gross income and income tax in pay slip builder"(){
        given:
        PaySlip.PaySlipBuilder paySlipBuilder = new PaySlip.PaySlipBuilder().setGrossIncome(5004).setIncomeTax(922)

        when:
        PaySlip paySlip = netIncomeGenerator.generatePaySlip(paySlipBuilder, new Employee.EmployeeBuilder().build())

        then:
        paySlip.netIncome == 4082
    }
}
