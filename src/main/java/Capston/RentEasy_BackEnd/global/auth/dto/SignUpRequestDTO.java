package Capston.RentEasy_BackEnd.global.auth.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequestDTO {
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
}
