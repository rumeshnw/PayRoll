# Company Pay Roll

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
    
    
Test coverage report can be found under /PayRoll/build/reports/coverage/index.html