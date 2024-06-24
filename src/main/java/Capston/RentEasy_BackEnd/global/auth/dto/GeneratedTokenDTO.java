package Capston.RentEasy_BackEnd.global.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GeneratedTokenDTO {
    private String accessToken;
    private String refreshToken;
}
