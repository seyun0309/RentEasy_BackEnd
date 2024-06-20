package Capston.RentEasy_BackEnd.domain.money.domain;

import Capston.RentEasy_BackEnd.domain.building.domain.Building;
import Capston.RentEasy_BackEnd.global.common.BaseEntity;
import Capston.RentEasy_BackEnd.global.enums.MoneyType;
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
@Table(name = "money")
public class Money extends BaseEntity {

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MoneyType moneyType;

    @JoinColumn(columnDefinition = "varchar(20)", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;
}
