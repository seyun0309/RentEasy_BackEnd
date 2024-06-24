package Capston.RentEasy_BackEnd.global.enums;

import lombok.Getter;

@Getter
public enum Role {
    BUILDING_OWNER("001","건물주");

    private final String code;
    private final String description;

    Role(String code,  String description) {
        this.code = code;
        this.description = description;
    }
}
