package com.varna.firstjobapp.job;

import com.varna.firstjobapp.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//base url
@RequestMapping("/varna")
public class JobController {

    @Autowired
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
       // Company c = job.getCompany();
        return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

//    @DeleteMapping("/jobs/{id}")
//    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
//        jobService.deleteJobById(id);
//        return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
//    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted =  jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/jobs/{id}")
    //CAN ALSO DEFINE LIKE BELOW
    //@RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
