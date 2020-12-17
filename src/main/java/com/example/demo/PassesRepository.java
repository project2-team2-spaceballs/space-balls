package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PassesRepository extends CrudRepository<Passes, Integer> {
    Iterable<Passes> getPassesBySatId(int sat_id);
}
