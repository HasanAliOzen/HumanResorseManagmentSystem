package com.travula.hrms.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "job_posts")
public class JobPost {
    @Id
    @SequenceGenerator(name = "seq_post_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_post_id",strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_position")
    private JobPosition jobPosition;

    @Column(name = "job_description",nullable = false,length = 500)
    private String jobDescription;

    @Column(name = "job_city",length = 25,nullable = false)
    private String jobCity;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;

    @Column(name = "empty_positions", nullable = false)
    private int emptyPositions;

    @Column(name = "deadline",nullable = false)
    private Date deadline;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
