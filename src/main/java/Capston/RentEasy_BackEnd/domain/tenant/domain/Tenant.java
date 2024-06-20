package Capston.RentEasy_BackEnd.domain.tenant.domain;

import Capston.RentEasy_BackEnd.domain.building.domain.Building;
import Capston.RentEasy_BackEnd.global.common.BaseEntity;
import Capston.RentEasy_BackEnd.global.enums.ContractType;
import Capston.RentEasy_BackEnd.global.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;


@SuperBuilder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tenant")
public class Tenant extends BaseEntity {

    @Column(nullable = false)
    private String tenantName;

    @Column(nullable = false)
    private String tenantPhoneNumber;

    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    private int securityDeposit;

    private int monthlyFee;

    private int jeonseFee;

    private int maintenanceCost;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date contractDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date contractExpiryDate;

    //TODO 월세 납부 여부 애트리뷰트

    @JoinColumn(columnDefinition = "varchar(20)", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

}
