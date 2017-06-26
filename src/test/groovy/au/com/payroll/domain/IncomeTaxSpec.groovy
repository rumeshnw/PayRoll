package au.com.payroll.domain

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author rnadeera
 */
class IncomeTaxSpec extends Specification {

    @Unroll
    def "test isTaxable, should return #booleanVal when marginalTax is #marginalTax and unitRate is #unitRate"(){
        when:
        boolean isTaxable = new IncomeTax(marginalTax: marginalTax, unitRate: unitRate).isTaxable()

        then:
        isTaxable == booleanVal

        where:
        marginalTax | unitRate  | booleanVal
        10          | 0         | true
        0           | 0.34      | true
        0           | 0         | false
    }
}
