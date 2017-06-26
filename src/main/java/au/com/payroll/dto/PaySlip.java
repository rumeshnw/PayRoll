package au.com.payroll.dto;

/**
 * Data transfer object holds employee payslip data
 *
 * @author rnadeera
 */
public class PaySlip {

    private String firstName;
    private String lastName;
    private String payPeriod;
    private long grossIncome;
    private long incomeTax;
    private long netIncome;
    private long superannuation;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public long getGrossIncome() {
        return grossIncome;
    }

    public long getIncomeTax() {
        return incomeTax;
    }

    public long getNetIncome() {
        return netIncome;
    }

    public long getSuperannuation() {
        return superannuation;
    }

    @Override
    public String toString() {
        return "------------ Pay Slip ------------" + "\n" +
                "Pay Period:     " + payPeriod + "\n" +
                "Employee:       " + firstName + " " + lastName + "\n" +
                "Gross Income:   " + grossIncome + "\n" +
                "Income Tax:     " + incomeTax + "\n" +
                "Net Income:     " + netIncome + "\n" +
                "Superannuation: " + superannuation + "\n";
    }

    public static class PaySlipBuilder {
        private String firstName;
        private String lastName;
        private String payPeriod;
        private long grossIncome;
        private long incomeTax;
        private long netIncome;
        private long superannuation;

        public PaySlipBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PaySlipBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PaySlipBuilder setPayPeriod(String payPeriod) {
            this.payPeriod = payPeriod;
            return this;
        }

        public PaySlipBuilder setGrossIncome(long grossIncome) {
            this.grossIncome = grossIncome;
            return this;
        }

        public PaySlipBuilder setIncomeTax(long incomeTax) {
            this.incomeTax = incomeTax;
            return this;
        }

        public PaySlipBuilder setNetIncome(long netIncome) {
            this.netIncome = netIncome;
            return this;
        }

        public PaySlipBuilder setSuperannuation(long superannuation) {
            this.superannuation = superannuation;
            return this;
        }

        public long getGrossIncome() {
            return grossIncome;
        }

        public long getIncomeTax() {
            return incomeTax;
        }

        public PaySlip build(){
            PaySlip paySlip         = new PaySlip();
            paySlip.firstName       = this.firstName;
            paySlip.lastName        = this.lastName;
            paySlip.payPeriod       = this.payPeriod;
            paySlip.grossIncome     = this.grossIncome;
            paySlip.incomeTax       = this.incomeTax;
            paySlip.netIncome       = this.netIncome;
            paySlip.superannuation  = this.superannuation;

            return paySlip;
        }
    }
}
