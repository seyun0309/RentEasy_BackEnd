package Capston.RentEasy_BackEnd.domain.building.domain;

import Capston.RentEasy_BackEnd.domain.member.domain.Member;
import Capston.RentEasy_BackEnd.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "building")
public class Building extends BaseEntity {

    @Column(nullable = false)
    private String buildingName;

    @Column(nullable = false)
    private String address;

    @JoinColumn(columnDefinition = "varchar(20)", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
