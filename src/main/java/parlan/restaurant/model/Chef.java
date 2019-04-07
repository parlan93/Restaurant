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
@Table(name = "chef")
public class Chef extends Employee {

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Contract.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "contract_id", unique = true)
    private Contract contract;

    @Column(nullable = true, length = 32)
    private String speciality;

    public Chef() {
    }

    public Chef(Contract contract, String speciality, String firstname, String lastname, Date birthDate, String addressStreet, String addressBuilding, String addressFlat, String addressCity, String addressPostcode, Employee supervisor) {
        super(firstname, lastname, birthDate, addressStreet, addressBuilding, addressFlat, addressCity, addressPostcode, supervisor);
        this.contract = contract;
        this.speciality = speciality;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
