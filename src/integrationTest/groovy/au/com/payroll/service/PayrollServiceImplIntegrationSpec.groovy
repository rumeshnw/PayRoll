package au.com.payroll.service

import au.com.payroll.BaseIntegrationSpec
import au.com.payroll.domain.IncomeTax
import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import au.com.payroll.factory.ResourceFactory
import au.com.payroll.transaction.Transactional

/**
 * @author rnadeera
 */
class PayrollServiceImplIntegrationSpec extends BaseIntegrationSpec implements Transactional {

    PayrollService payRollService

    def setup(){
        initTaxData()
        payRollService = ResourceFactory.getPayrollService()
    }

    def "test generatePaySlip, should return generated PaySlip instance when valid employee instance is provided"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setFirstName("John").setLastName("Doe")
                .setAnnualSalary(60050).setSuperRate(9).setPayPeriod("03/2017").build()


        when:
        PaySlip paySlip = payRollService.generatePaySlip(employee)

        then:
        paySlip
        paySlip.firstName       == employee.firstName
        paySlip.lastName        == employee.lastName
        paySlip.payPeriod       == "Month of March (1 March to 31 March)"
        paySlip.grossIncome     == 5004
        paySlip.incomeTax       == 922
        paySlip.netIncome       == 4082
        paySlip.superannuation  == 450
    }

    def initTaxData(){
        System.out.println("Calling initTaxData")
        withTransaction({ session ->
            List<IncomeTax> incomeTaxes = new ArrayList<>()
            incomeTaxes.add(new IncomeTax(0l, 18200l, 0l, 0.0, 0.0))
            incomeTaxes.add(new IncomeTax(18201l, 37000l, 0l, 0.19, 18200.0))
            incomeTaxes.add(new IncomeTax(37001l, 80000l, 3572l, 0.325, 37000.0))
            incomeTaxes.add(new IncomeTax(80001l, 180000l, 17547l, 0.37, 80000.0))
            incomeTaxes.add(new IncomeTax(1800001l, 99999999999l, 54547l, 0.45, 180000.0))

            incomeTaxes.each({
                def a = session.save(it)
                System.out.println("SAVED::: " + a.dump())
            })
        })
    }
}

