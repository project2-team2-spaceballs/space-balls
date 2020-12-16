package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface LogHistoryRepository extends CrudRepository<LogHistory, Long> {
    Iterable<LogHistory> findByLogId(Long log_id);
}
