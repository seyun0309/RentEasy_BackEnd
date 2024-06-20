package Capston.RentEasy_BackEnd.domain.tenant.dto;

import Capston.RentEasy_BackEnd.global.enums.ContractType;
import Capston.RentEasy_BackEnd.global.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TenantDTO {
    private String tenantName;
    private String tenantPhoneNumber;
    private String roomNumber;
    private RoomType roomType;
    private ContractType contractType;
    private int securityDeposit;
    private int MonthlyFee;
    private int jeonseFee;
    private int maintenanceCost;
    private LocalDate contractDate;
    private LocalDate contractExpiryDate;
}
