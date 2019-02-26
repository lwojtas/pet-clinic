package it.wojtas.petclinic.service.map;

import it.wojtas.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T t) {
        if (t != null && t.getId() == null) {
            t.setId(getNextId());
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        map.put(t.getId(), t);
        return t;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId() {
        return map.isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }

}
