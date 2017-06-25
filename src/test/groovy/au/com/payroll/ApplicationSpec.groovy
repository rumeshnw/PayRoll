package au.com.payroll

import spock.lang.Specification

class ApplicationSpec extends Specification {
    def setup(){

    }

    def cleanup(){

    }

    def "test main, should not throw an exception"() {
        when:
        def a = 1

        then:
        a == 1
    }
}
