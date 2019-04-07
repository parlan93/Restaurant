package parlan.restaurant.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
@Table(name = "contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ContractType.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "contract_type_id")
    private ContractType contractType;

    @Column(name = "date_from", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Column(name = "date_to", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal salary;

    public Contract() {
    }

    public Contract(ContractType contractType, Date dateFrom, Date dateTo, BigDecimal salary) {
        this.contractType = contractType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
