package Capston.RentEasy_BackEnd.global.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignUpResponseDTO {
    private String email;
    private String password;
}
