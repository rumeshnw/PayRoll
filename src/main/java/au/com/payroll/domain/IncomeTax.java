package au.com.payroll.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Hold income tax data
 *
 * @author rnadeera
 */
@Entity
public class IncomeTax {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long incomeFrom;

    @Column(nullable = false)
    private Long incomeTo;

    @Column(nullable = false)
    private Long marginalTax;

    @Column(nullable = false)
    private Double unitRate;

    @Column(nullable = false)
    private Double threshold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIncomeFrom() {
        return incomeFrom;
    }

    public void setIncomeFrom(Long incomeFrom) {
        this.incomeFrom = incomeFrom;
    }

    public Long getIncomeTo() {
        return incomeTo;
    }

    public void setIncomeTo(Long incomeTo) {
        this.incomeTo = incomeTo;
    }

    public Long getMarginalTax() {
        return marginalTax;
    }

    public void setMarginalTax(Long marginalTax) {
        this.marginalTax = marginalTax;
    }

    public Double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(Double unitRate) {
        this.unitRate = unitRate;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public IncomeTax() {
    }

    public IncomeTax(Long incomeFrom, Long incomeTo, Long marginalTax, Double unitRate, Double threshold) {
        this.incomeFrom = incomeFrom;
        this.incomeTo = incomeTo;
        this.marginalTax = marginalTax;
        this.unitRate = unitRate;
        this.threshold = threshold;
    }

    public boolean isTaxable(){
        return this.marginalTax > 0 || this.unitRate > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IncomeTax)) return false;

        IncomeTax incomeTax = (IncomeTax) o;

        return new EqualsBuilder()
                .append(id, incomeTax.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(9, 27)
                .append(id)
                .toHashCode();
    }
}
