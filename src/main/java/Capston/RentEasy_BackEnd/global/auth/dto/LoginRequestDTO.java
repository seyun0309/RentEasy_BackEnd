package Capston.RentEasy_BackEnd.global.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class LoginRequestDTO {
    @NotBlank
    private final String email;
    @NotBlank
    private final String password;
}
