package com.travula.hrms.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
@Table(name = "candidates")
public class Candidate {
    @Id
    @SequenceGenerator(name = "seq_candidate_id100",allocationSize = 1)
    @GeneratedValue(generator = "seq_candidate_id100",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;

    @Column(name = "nationality_id",nullable = false,length = 50,unique = true)
    private String nationalityId;

    @Column(name = "birth_year",nullable = false,length = 4)
    private int birthYear;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
