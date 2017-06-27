package au.com.payroll.service

import au.com.payroll.BaseIntegrationSpec
import au.com.payroll.config.BootstrapData
import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import au.com.payroll.factory.ResourceFactory
import au.com.payroll.transaction.Transactional
import org.springframework.test.annotation.Rollback

/**
 * @author rnadeera
 */
@Rollback
class PayrollServiceImplIntegrationSpec extends BaseIntegrationSpec implements Transactional {

    PayrollService payRollService

    def setup(){
        payRollService = ResourceFactory.getPayrollService()
    }

    def "test generatePaySlip, should return generated PaySlip instance when valid employee instance is provided"(){
        given:
        new BootstrapData().initData()

        and:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe")
                .setAnnualSalary(60050).setSuperRate(9).setPayPeriod("04/2017").build()

        when:
        PaySlip paySlip = payRollService.generatePaySlip(employee)

        then:
        paySlip
        paySlip.firstName       == employee.firstName
        paySlip.lastName        == employee.lastName
        paySlip.payPeriod       == "Month of April (1 April to 30 April)"
        paySlip.grossIncome     == 5004
        paySlip.incomeTax       == 922
        paySlip.netIncome       == 4082
        paySlip.superannuation  == 450
    }
}

