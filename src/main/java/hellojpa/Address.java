package hellojpa;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.util.Objects;

@Embeddable
public class Address {
    private String city;
    private String zipcode;
    private String street;

    public Address() {
    }

    public Address(String city, String zipcode, String street) {
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!Objects.equals(city, address.city)) return false;
        if (!Objects.equals(zipcode, address.zipcode)) return false;
        return Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }

    public String getCity() {
        return city;
    }


    public String getZipcode() {
        return zipcode;
    }


    public String getStreet() {
        return street;
    }

}
