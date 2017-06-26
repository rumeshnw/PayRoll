package au.com.payroll.service.handler

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import spock.lang.Specification

/**
 * @author rnadeera
 */
class SuperannuationDecoratorSpec extends Specification {

    SuperannuationDecorator superannuationDecorator

    def setup(){
        superannuationDecorator = new SuperannuationDecorator(new EmployeePaySlip())
    }

    def "test generatePaySlip, should calculate and set super amount based on gross income and super rate"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setSuperRate(9).build()

        and:
        PaySlip.PaySlipBuilder paySlipBuilder = new PaySlip.PaySlipBuilder().setGrossIncome(5004)

        when:
        PaySlip paySlip = superannuationDecorator.generatePaySlip(paySlipBuilder, employee)

        then:
        paySlip.superannuation == 450
    }
}
