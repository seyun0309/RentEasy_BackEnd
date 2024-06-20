package Capston.RentEasy_BackEnd.domain.member.domain;

import Capston.RentEasy_BackEnd.global.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseEntity {

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(length = 16, nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;
}
