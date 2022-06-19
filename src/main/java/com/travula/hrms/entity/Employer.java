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
@Table(name = "employers")
public class Employer {
    @Id
    @SequenceGenerator(name = "seq_employer_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_employer_id",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "company_name",nullable = false,length = 50)
    private String companyName;

    @Column(name = "web_page",nullable = false,length = 50)
    private String webPage;

    @Column(name = "phone_number",nullable = false,length = 11)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
