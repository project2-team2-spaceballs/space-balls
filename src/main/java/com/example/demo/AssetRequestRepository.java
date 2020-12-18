package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface AssetRequestRepository extends CrudRepository<AssetRequest, Long> {
    @Query(value = "select * from asset_request where user_id = :userId", nativeQuery = true)
    Iterable<AssetRequest> findByUserId(@Param("userId") Long userId);
}
