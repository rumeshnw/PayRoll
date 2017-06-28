# Company Payroll

This system uses Gradle build system(version 3.1). However, to use this application or run any of the below commands, you do not need Gradle to be installed.

**Prerequisite**:
- In order to use the system Java 8 should be installed.

**Commands**

1. Run Unit Tests
    - Unix      : _./gradlew clean test_
    - Windows   : _gradlew clean test_
    
2. Run Integration Tests
   - Unix      : _./gradlew clean integrationTest_
   - Windows   : _gradlew clean integrationTest_
       
3. Run Code Coverage
   - Unix      : _./gradlew clean test integrationTest jacocoTestReport_
   - Windows   : _gradlew clean test integrationTest jacocoTestReport_
       
4. Run System
    - Unix      : _./gradlew clean run_
    - Windows   : _gradlew clean run_
    
Once user execute the Run System command, system will boot up and show list of options with following operations,
    
    1. Generate employee pay slip
    99. Exit the system
    
Once user proceed with Generate employee payslip, system will request multiple inputs in an interactive CLI to generate the pay slip. 
        
Generated payslip will be printed as follows,
    
    ------------ Pay Slip ------------
    Pay Period:     Month of March (1 March to 31 March)
    Employee:       David Rudd
    Gross Income:   5004
    Income Tax:     922
    Net Income:     4082
    Superannuation: 450

    
Test coverage report can be found under _/Payroll/build/reports/coverage/index.html_

Assumptions:

    1. Superannuation percentage can either be defined as an integer value or a double value with up to two decimal places. Eg: both 9 and 9.00 is considered as a valid super percentage
    2. Pay period should be defined as MM/YYYY format. Month can be defined with or without preceding zero. Eg: both 03/2017 and 3/2017 will be considered as a valid pay period