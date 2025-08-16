package com.varna.firstjobapp.job.imp;

import com.varna.firstjobapp.job.Job;
import com.varna.firstjobapp.job.JobRepository;
import com.varna.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<Job>();
    JobRepository jobRepository;

    private long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {

        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextId++);
        //jobs.add(job);
        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {
//        for (Job job : jobs){
//            if(job.getId() == id){
//                return job;
//            }
//        }
//        return null;
         return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
//        Iterator<Job> itr = jobs.iterator();
//        while(itr.hasNext()){
//            Job job = itr.next();
//            if(job.getId() == id){
//                itr.remove();
//                return true;
//            }
//        }
//
//        return false;
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;

        }

    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }
        return false;
    }

//    @Override
//    public void deleteJobById(Long id) {
//        jobs.removeIf(job -> job.getId() == id);
//    }
}
