package parlan.restaurant.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "waiter")
public class Waiter extends Employee {

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Contract.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "contract_id", unique = true)
    private Contract contract;

    @Column(name = "foreign_languages")
    @ElementCollection(targetClass = String.class)
    private List<String> foreignLanguages;

    public Waiter() {
    }

    public Waiter(Contract contract, List<String> foreignLanguages, String firstname, String lastname, Date birthDate, String addressStreet, String addressBuilding, String addressFlat, String addressCity, String addressPostcode, Employee supervisor) {
        super(firstname, lastname, birthDate, addressStreet, addressBuilding, addressFlat, addressCity, addressPostcode, supervisor);
        this.contract = contract;
        this.foreignLanguages = foreignLanguages;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<String> getForeignLanguages() {
        return foreignLanguages;
    }

    public void setForeignLanguages(List<String> foreignLanguages) {
        this.foreignLanguages = foreignLanguages;
    }

}
