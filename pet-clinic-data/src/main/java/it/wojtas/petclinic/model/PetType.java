package it.wojtas.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "types")
@Entity
public class PetType extends BaseEntity {
    private String name;
}
