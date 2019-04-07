package parlan.restaurant.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Entity
@Table(name = "supplier")
public class Supplier extends Employee {

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Contract.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "contract_id", unique = true)
    private Contract contract;

    @Column(length = 64)
    private String company;

    @Column(name = "phone_number", length = 16)
    private String phoneNumber;

    public Supplier() {
    }

    public Supplier(Contract contract, String company, String phoneNumber, String firstname, String lastname, Date birthDate, String addressStreet, String addressBuilding, String addressFlat, String addressCity, String addressPostcode, Employee supervisor) {
        super(firstname, lastname, birthDate, addressStreet, addressBuilding, addressFlat, addressCity, addressPostcode, supervisor);
        this.contract = contract;
        this.company = company;
        this.phoneNumber = phoneNumber;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
