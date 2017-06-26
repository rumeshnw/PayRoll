package au.com.payroll.service.handler

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class NetIncomeDecoratorSpec extends Specification {

    NetIncomeDecorator netIncomeDecorator

    def setup(){
        netIncomeDecorator = new NetIncomeDecorator(new EmployeePaySlip())
    }

    def "test generatePaySlip, should calculate and set net income from gross income and income tax in pay slip builder"(){
        given:
        PaySlip.PaySlipBuilder paySlipBuilder = new PaySlip.PaySlipBuilder().setGrossIncome(5004).setIncomeTax(922)

        when:
        PaySlip paySlip = netIncomeDecorator.generatePaySlip(paySlipBuilder, new Employee.EmployeeBuilder().build())

        then:
        paySlip.netIncome == 4082
    }
}
