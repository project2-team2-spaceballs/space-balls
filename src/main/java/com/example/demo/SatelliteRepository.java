package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface SatelliteRepository extends CrudRepository<Satellite, Integer> {
    Iterable<Satellite> getSatById(int id);
}
