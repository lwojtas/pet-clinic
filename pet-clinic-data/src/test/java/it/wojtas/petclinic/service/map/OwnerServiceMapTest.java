package it.wojtas.petclinic.service.map;

import it.wojtas.petclinic.model.Owner;
import it.wojtas.petclinic.service.PetService;
import it.wojtas.petclinic.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class OwnerServiceMapTest {

    @Mock
    PetTypeService petTypeService;

    @Mock
    PetService petService;

    @InjectMocks
    OwnerServiceMap underTest;
    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().lastName("lastName").address("address").city("city").build();
        underTest.map.put(1L, owner);
    }

    @Test
    void findById() {
        Owner owner = underTest.findById(1L);
        assertThat(owner.getLastName()).isEqualTo("lastName");

    }

    @Test
    void shouldSave() {
        //given
        Owner owner = Owner.builder().address("address").firstName("name").lastName("surname").build();
        //when
        Owner saved = underTest.save(owner);
        //then
        assertThat(saved.getId()).isNotNull();
        assertThat(underTest.map).containsKeys(saved.getId());
    }

    @Test
    void shouldDelete() {
        //given
        Owner owner = underTest.map.get(1L);

        //when
        underTest.delete(owner);

        //then
        assertThat(underTest.map).doesNotContainKeys(owner.getId());
    }

    @Test
    void deleteById() {
        //when
        underTest.deleteById(1L);

        //then
        assertThat(underTest.map).doesNotContainKeys(1L);
    }

    @Test
    void findAll() {
       //when
        Set<Owner> owners = underTest.findAll();

        //then
        assertThat(owners).hasSize(1).containsExactly(owner);


    }

    @Test
    void findByLastName() {
        //when
        Owner found = underTest.findByLastName("lastName");

        //then
        assertThat(found).isEqualTo(owner);
    }
}