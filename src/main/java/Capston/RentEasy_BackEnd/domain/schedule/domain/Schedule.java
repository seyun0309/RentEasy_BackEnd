package Capston.RentEasy_BackEnd.domain.schedule.domain;

import Capston.RentEasy_BackEnd.domain.building.domain.Building;
import Capston.RentEasy_BackEnd.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@SuperBuilder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @JoinColumn(columnDefinition = "varchar(20)", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;
}
