package com.example.prkt5upseva.Repository;
import com.example.prkt5upseva.Models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository  extends CrudRepository<Job, Long> {
    Job findByNameContaining(String name);
}