package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public interface MxRepository extends CrudRepository<MxTask, Long> {
    @Query(value="SELECT * FROM mx WHERE sensors LIKE %:searchsensor%", nativeQuery = true)
    Iterable<MxTask> findBySensor(@PathVariable String searchsensor);

    @Query(value="SELECT * FROM mx WHERE " +
            "mx_id LIKE %:searchstring% OR " +
            "mx_title LIKE %:searchstring% OR " +
            "description LIKE %:searchstring% " +
            "OR sensors LIKE %:searchstring% " +
            "OR type LIKE %:searchstring%", nativeQuery = true)
    Iterable<MxTask> doSearch(@RequestParam String searchstring);
}
