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
    private Integer incomeFrom;

    @Column(nullable = false)
    private Integer incomeTo;

    @Column(nullable = false)
    private Integer marginalTax;

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

    public Integer getIncomeFrom() {
        return incomeFrom;
    }

    public void setIncomeFrom(Integer incomeFrom) {
        this.incomeFrom = incomeFrom;
    }

    public Integer getIncomeTo() {
        return incomeTo;
    }

    public void setIncomeTo(Integer incomeTo) {
        this.incomeTo = incomeTo;
    }

    public Integer getMarginalTax() {
        return marginalTax;
    }

    public void setMarginalTax(Integer marginalTax) {
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

    public IncomeTax(Integer incomeFrom, Integer incomeTo, Integer marginalTax, Double unitRate, Double threshold) {
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
