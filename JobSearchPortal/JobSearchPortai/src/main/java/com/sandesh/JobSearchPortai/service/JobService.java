package com.sandesh.JobSearchPortai.service;

import com.sandesh.JobSearchPortai.model.Job;
import com.sandesh.JobSearchPortai.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
     IJobRepo jobRepo;


    public String addjobs(List<Job> jobs) {
        jobRepo.saveAll(jobs);
        return jobs.size() +" "+ "jobs are added!!";
    }



    public Job getJobById(Integer id) {
        Optional<Job> existingJob = jobRepo.findById(id);
        if(existingJob.isPresent()){
            Job job = existingJob.get();
            return job;
        }
        else{
            return null;
        }
    }


    public String updateJobById(Integer id, Job updateJob) {
        Job job = jobRepo.findById(id).orElse(null);
            job.setJobEmployerName(updateJob.getJobEmployerName());
            job.setJobLocation(updateJob.getJobLocation());
            job.setJobDescription(updateJob.getJobDescription());
            job.setJobCompanyEmail(updateJob.getJobCompanyEmail());
            job.setJobSalary(updateJob.getJobSalary());
            job.setJobTitle(updateJob.getJobTitle());
            job.setJobType(updateJob.getJobType());
            job.setJobCompanyName(updateJob.getJobCompanyName());
            jobRepo.save(job);
            return "job details updated!!!";
        }

    public List<Job> getAllJobs() {
        return (List<Job>) jobRepo.findAll();
    }

    public String removeById(Integer id) {
        Job job = jobRepo.findById(id).orElse(null);
        jobRepo.deleteById(id);
        return "job removed";
    }

    public String getJobByCompany(String companyName) {
        List<Job> jobs = jobRepo.findJobsByCompanyName(companyName);
        return "search result :" + jobs.toString();
    }

    public String getJobBySalaryAbove(Double salary) {
        List<Job> job = jobRepo.findJobsWithSalaryAbove(salary);
        return "Search result: " + job.toString();
    }
}

