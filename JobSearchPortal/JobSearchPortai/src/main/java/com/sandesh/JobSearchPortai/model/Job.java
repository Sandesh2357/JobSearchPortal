package com.sandesh.JobSearchPortai.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Job {
   @Id
   private Long jobId;

   @NotNull
   @Size(min = 3, max = 100)
   private String jobTitle;

   @NotBlank
   private String jobDescription;

   @NotBlank
   private String jobLocation;

   @Positive
   private Double jobSalary;

   @NotBlank
   private String jobCompanyName;

   @NotBlank
   @Email
   private String jobCompanyEmail;

   @NotBlank
   private String jobEmployerName;

   @NotNull
   private JobType jobType;

}
