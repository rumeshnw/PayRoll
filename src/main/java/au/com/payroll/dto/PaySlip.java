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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setPayPeriod(String payPeriod) {
            this.payPeriod = payPeriod;
        }

        public void setGrossIncome(long grossIncome) {
            this.grossIncome = grossIncome;
        }

        public void setIncomeTax(long incomeTax) {
            this.incomeTax = incomeTax;
        }

        public void setNetIncome(long netIncome) {
            this.netIncome = netIncome;
        }

        public void setSuperannuation(long superannuation) {
            this.superannuation = superannuation;
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
