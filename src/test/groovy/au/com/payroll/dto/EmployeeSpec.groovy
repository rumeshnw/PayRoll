package au.com.payroll.dto

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author rnadeera
 */
class EmployeeSpec extends Specification {

    @Unroll
    def "test validate, should throw an IllegalArgumentException when firstName #firstName, lastName #lastName, salary #salary, super #superRate and pay period #payPeriod"(){
        given:
        Employee employee = new Employee.EmployeeBuilder().setFirstName(firstName).setLastName(lastName)
                .setAnnualSalary(salary).setSuperRate(superRate).setPayPeriod(payPeriod).build()

        when:
        employee.validate()

        then:
        def e       = thrown(IllegalArgumentException)
        e.message   == errorMessage

        where:
        firstName   | lastName  | salary    | superRate | payPeriod | errorMessage
        null        | "Doe"     | 60500     | 9         | "03/2017" | "Employee first name is required"
        "John"      | null      | 60500     | 9         | "03/2017" | "Employee last name is required"
        "John"      | "Doe"     | -12       | 9         | "03/2017" | "Employee annual salary should be a positive value"
        "John"      | "Doe"     | 60050     | -9        | "03/2017" | "Employee superannuation rate should be a positive value"
        "John"      | "Doe"     | 60050     | 9         | null      | "Employee pay paid is required"
        "John"      | "Doe"     | 60050     | 9         | "20/2017" | "Invalid pay period. Pay period should be in numeric MM/YYYY format"
        "John"      | "Doe"     | 60050     | 9         | "3/17"    | "Invalid pay period. Pay period should be in numeric MM/YYYY format"
    }
}
