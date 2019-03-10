package it.wojtas.petclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "specialities")
@Data
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @Builder
    public Vet(String firstName, String lastName, Set<Speciality> specialities) {
        super(firstName, lastName);
        this.specialities = specialities;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet();

    @Override
    public String toString() {
        return getFirstName();
    }
}
