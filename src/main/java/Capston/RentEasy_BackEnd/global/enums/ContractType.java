package Capston.RentEasy_BackEnd.global.enums;

import lombok.Getter;

@Getter
public enum ContractType {
    MONTHLY_RENT("001", "월세"),
    JEONSE("002", "전세");

    private final String code ;
    private final String description;

    ContractType(String code,  String description) {
        this.code = code;
        this.description = description;
    }
}
