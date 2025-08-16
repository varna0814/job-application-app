package com.varna.firstjobapp.job;


import java.util.List;

//to support lose coupling created as interface.
public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
