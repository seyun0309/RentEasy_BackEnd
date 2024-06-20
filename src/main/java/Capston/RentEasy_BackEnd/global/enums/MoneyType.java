package Capston.RentEasy_BackEnd.global.enums;

import lombok.Getter;

@Getter
public enum MoneyType {
    REVENUE("001", "수익"),
    EXPENDITURE("002", "전세");

    private final String code ;
    private final String description;

    MoneyType(String code,  String description) {
        this.code = code;
        this.description = description;
    }
}
