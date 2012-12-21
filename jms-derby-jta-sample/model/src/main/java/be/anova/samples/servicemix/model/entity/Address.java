package be.anova.samples.servicemix.model.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Hans Couder
 * Date: 12/21/12
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address")
@XmlRootElement(name = "address")
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    @XmlElement(required = true)
    @Column(name = "NAME")
    private String name;

    @XmlElement(required = true)
    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "CODE")
    private String code;

    @Column(name = "PHONE")
    private long phone;

    @Column(name = "EMAIL")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
