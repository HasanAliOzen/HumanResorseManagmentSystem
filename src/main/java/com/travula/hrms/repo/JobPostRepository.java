package com.travula.hrms.repo;

import com.travula.hrms.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost,Long> {
    List<JobPost> getJobPostsByStatus (boolean status);

    List<JobPost> getJobPostsByStatusOrderByPublicationDateAsc(boolean status);

    List<JobPost> getJobPostsByStatusAndEmployer_CompanyName(boolean status, String employeName);

    JobPost getById (Long postId);
}
