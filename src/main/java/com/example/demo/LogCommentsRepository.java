package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface LogCommentsRepository extends CrudRepository<LogComments, Long> {
    Iterable<LogComments> findByLogId(Long log_id);
}
