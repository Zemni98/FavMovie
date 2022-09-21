package com.youjin.domain.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table
public class User {
    @Id
    @GeneratedValue
    private long userSeq;

    @Column(unique = true)
    @NotBlank(message = "ID를 입력해주세요.")
    private String userId;

    @NotBlank(message = "PW를 입력해주세요.")
    private String password;
}