package parlan.restaurant.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 32)
    private String firstname;

    @Column(nullable = false, length = 64)
    private String lastname;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "address_street", nullable = true, length = 128)
    private String addressStreet;

    @Column(name = "address_building", nullable = true, length = 8)
    private String addressBuilding;

    @Column(name = "address_flat", nullable = true, length = 8)
    private String addressFlat;

    @Column(name = "address_city", nullable = true, length = 128)
    private String addressCity;

    @Column(name = "address_postcode", nullable = true, length = 8)
    private String addressPostcode;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "supervisor_id")
    private Employee supervisor;

    public Employee() {
    }

    public Employee(String firstname, String lastname, Date birthDate, String addressStreet, String addressBuilding, String addressFlat, String addressCity, String addressPostcode, Employee supervisor) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.addressStreet = addressStreet;
        this.addressBuilding = addressBuilding;
        this.addressFlat = addressFlat;
        this.addressCity = addressCity;
        this.addressPostcode = addressPostcode;
        this.supervisor = supervisor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressBuilding() {
        return addressBuilding;
    }

    public void setAddressBuilding(String addressBuilding) {
        this.addressBuilding = addressBuilding;
    }

    public String getAddressFlat() {
        return addressFlat;
    }

    public void setAddressFlat(String addressFlat) {
        this.addressFlat = addressFlat;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(String addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

}
