package it.wojtas.petclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "pets")
@Data
@Entity
@Getter
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String phone, Set<Pet> pets) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
    }

    private String address;

    private String city;

    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Override
    public String toString() {
        return getFirstName();
    }
}
