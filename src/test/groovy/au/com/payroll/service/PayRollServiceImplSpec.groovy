package au.com.payroll.service

import au.com.payroll.dto.Employee
import au.com.payroll.dto.PaySlip
import au.com.payroll.service.handler.PayPeriodDecorator
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by rnadeera on 26/6/17.
 */
class PayRollServiceImplSpec extends Specification {

    PayRollService payRollService

    def setup(){
        payRollService = PayRollServiceImpl.getInstance()
    }

    def cleanup(){
        PayPeriodDecorator.metaClass = null
    }

    def "test generatePaySlip, should throw IllegalArgumentException when employee param is null"(){
        when:
        payRollService.generatePaySlip(null)

        then:
        def e       = thrown(IllegalArgumentException)
        e.message   == "employee details required"
    }

    @Unroll
    def "test generatePaySlip, should throw an IllegalArgumentException when firstName #firstName, lastName #lastName, salary #salary, super #superRate and pay period #payPeriod"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setFirstName(firstName).setLastName(lastName)
                                        .setAnnualSalary(salary).setSuperRate(superRate).setPayPeriod(payPeriod).build()

        when:
        payRollService.generatePaySlip(employee)

        then:
        def e       = thrown(IllegalArgumentException)
        e.message   == errorMessage

        where:
        firstName   | lastName  | salary    | superRate | payPeriod | errorMessage
        null        | "Doe"     | 60500     | 9         | "03/2017" | "Employee first name is required"
        ""          | "Doe"     | 60500     | 9         | "03/2017" | "Employee first name is required"
        "John"      | null      | 60500     | 9         | "03/2017" | "Employee last name is required"
        "John"      | ""        | 60500     | 9         | "03/2017" | "Employee last name is required"
        "John"      | "Doe"     | -12       | 9         | "03/2017" | "Employee annual salary should be a positive value"
        "John"      | "Doe"     | 60050     | -9        | "03/2017" | "Employee superannuation rate should be a positive value"
        "John"      | "Doe"     | 60050     | 9         | null      | "Employee pay paid is required"
        "John"      | "Doe"     | 60050     | 9         | ""        | "Employee pay paid is required"
        "John"      | "Doe"     | 60050     | 9         | "20/2017" | "Invalid pay period. Pay period should be in numeric MM/YYYY format"
        "John"      | "Doe"     | 60050     | 9         | "3/17"    | "Invalid pay period. Pay period should be in numeric MM/YYYY format"
    }
}
