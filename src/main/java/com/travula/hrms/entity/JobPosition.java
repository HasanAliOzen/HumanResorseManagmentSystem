package com.travula.hrms.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@Table(name = "job_position")
public class JobPosition {
    @Id
    /*@SequenceGenerator(name = "seq_job_id",allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_name",unique = true,nullable = false,length = 50)
    private String jobName;
}
