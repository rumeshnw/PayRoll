package au.com.payroll.dto;

/**
 * Data transfer objects holds employee pay roll data
 *
 * @author rnadeera
 */
public class Employee {

    private String firstName;
    private String lastName;
    private int annualSalary;
    private double superRate;
    private String payPeriod;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public double getSuperRate() {
        return superRate;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public static class EmployeeBuilder {
        private String firstName;
        private String lastName;
        private int annualSalary;
        private double superRate;
        private String payPeriod;

        public EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder setAnnualSalary(int annualSalary) {
            this.annualSalary = annualSalary;
            return this;
        }

        public EmployeeBuilder setSuperRate(double superRate) {
            this.superRate = superRate;
            return this;
        }

        public EmployeeBuilder setPayPeriod(String payPeriod) {
            this.payPeriod = payPeriod;
            return this;
        }

        public Employee build(){
            Employee employee = new Employee();
            employee.firstName      = this.firstName;
            employee.lastName       = this.lastName;
            employee.annualSalary   = this.annualSalary;
            employee.superRate      = this.superRate;
            employee.payPeriod      = this.payPeriod;

            return employee;
        }
    }
}
