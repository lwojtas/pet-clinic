package it.wojtas.petclinic.service;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T T);

    void delete(T t);

    void deleteById(ID id);

    Set<T> findAll();
}
