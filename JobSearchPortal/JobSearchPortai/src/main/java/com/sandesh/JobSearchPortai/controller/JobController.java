package com.sandesh.JobSearchPortai.controller;

import com.sandesh.JobSearchPortai.model.Job;
import com.sandesh.JobSearchPortai.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("jobs")
    public String addjobs(@RequestBody List<Job> jobs){
        return jobService.addjobs(jobs);
    }
    @GetMapping("job/id/{id}")
    public Job getJobById(@PathVariable Integer id){

        return jobService.getJobById(id);
    }
    @PutMapping("job/id/{id}")
    public String updateJobById(@PathVariable Integer id, @RequestBody Job updateJob){
        return jobService.updateJobById(id,updateJob);
    }
    @GetMapping("jobs/")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    @DeleteMapping
    public String removeById(@PathVariable Integer id){
        return jobService.removeById(id);
    }
    @GetMapping("job/company_name")
    public String getJobByCompanyName(@RequestParam String companyName){
        return jobService.getJobByCompany(companyName);
    }
    @GetMapping("job/salary")
    public String getJobBySalaryAbove(@RequestParam Double salary){
        return jobService.getJobBySalaryAbove(salary);
    }
}
