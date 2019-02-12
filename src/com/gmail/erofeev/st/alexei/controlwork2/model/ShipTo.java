package com.gmail.erofeev.st.alexei.controlwork2.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


public class ShipTo {
    private String name;
    private String address;
    private String city;
    private String country;

    public ShipTo() {
    }

    public ShipTo(String name, String address, String city, String country) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipTo person = (ShipTo) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(address, person.address) &&
                Objects.equals(city, person.city) &&
                Objects.equals(country, person.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, city, country);
    }

    @Override
    public String toString() {
        return "ShipTo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
