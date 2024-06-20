package Capston.RentEasy_BackEnd.global.enums;

import lombok.Getter;

@Getter
public enum RoomType {

    STORE("001", "상가"),
    ONE_ROOM("002", "원룸"),
    ONE_AND_HALF_ROOM("003", "1.5룸"),
    TWO_ROOM("004", "투룸");


    private final String code ;
    private final String description;

    RoomType(String code,  String description) {
        this.code = code;
        this.description = description;
    }
}
