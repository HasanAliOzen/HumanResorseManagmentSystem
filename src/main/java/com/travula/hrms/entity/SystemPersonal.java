package com.travula.hrms.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "system_personal")
public class SystemPersonal {

    @Id
    @SequenceGenerator(name = "seq_sys_personal_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_sys_personal_id",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
