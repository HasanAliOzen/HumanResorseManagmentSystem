package com.travula.hrms.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
@Table(name = "users")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_user_id100",allocationSize = 1)
    @GeneratedValue(generator = "seq_user_id100",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email",nullable = false,unique = true,length = 50)
    private String email;

    @Column(name = "password",nullable = false,length = 60)
    private String password;

    @Column(name = "is_email_enabled")
    private boolean isEmailEnabled;

    @Column(name = "verification",updatable = false,nullable = false)
    private int verificationCode;

}
