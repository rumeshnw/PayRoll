package au.com.payroll.dto;

import au.com.payroll.util.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Data transfer objects holds employee pay roll data
 *
 * @author rnadeera
 */
public class Employee {

    //private static final Pattern payPeriodValidator = Pattern.compile("((0)?[1-9]|1[0-2])/20\\d{2}");

    @NotNull(message = "Employee first name is required")
    private String firstName;

    @NotNull(message = "Employee last name is required")
    private String lastName;

    @Min(value = 1, message = "Employee annual salary should be a positive value")
    private int annualSalary;

    @Min(value = 0, message = "Employee superannuation rate should be a positive value")
    private double superRate;

    @NotNull(message = "Employee pay paid is required")
    @Pattern(regexp = "((0)?[1-9]|1[0-2])/20\\d{2}", message = "Invalid pay period. Pay period should be in numeric MM/YYYY format")
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

    public void validate(){
        Validator.validate(this);
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
