package Capston.RentEasy_BackEnd.domain.money.dto;


import Capston.RentEasy_BackEnd.global.enums.MoneyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MoneyDTO {

    private String description;
    private String amount;
    private MoneyType moneyType;
}
