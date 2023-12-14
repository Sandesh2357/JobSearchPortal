package com.sandesh.JobSearchPortai.repository;
import com.sandesh.JobSearchPortai.model.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Integer> {

    @Query(value ="SELECT * FROM job WHERE company_name = :companyName", nativeQuery = true)
    List<Job> findJobsByCompanyName(String companyName);

    @Query(value ="SELECT * FROM job WHERE salary > :salary", nativeQuery = true)
    List<Job> findJobsWithSalaryAbove(Double salary);
}
