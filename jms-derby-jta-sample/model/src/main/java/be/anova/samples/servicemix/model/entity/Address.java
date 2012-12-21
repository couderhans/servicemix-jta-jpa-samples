package be.anova.samples.servicemix.model.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address")
@XmlRootElement(name = "Address")
@Access(value = AccessType.FIELD)
@Embeddable
public class Address {
    @Basic
    private String street;
    @Basic
    private String city;
    @Basic
    private String state;
    @Basic
    private Integer zip;

    // Relationship from an Embeddable to an Entity
    @XmlTransient
    @ManyToOne(cascade = CascadeType.ALL)
    Coordinates coordinates;

    public Address() {

    }

    public Address(String street, String city, String state, Integer zip, Coordinates c) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        coordinates = c;
    }

    public String toString() {
        return street + " " + city + ", " + state + " " + zip;
    }
}