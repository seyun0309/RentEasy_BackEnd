package Capston.RentEasy_BackEnd.global.auth.dto;


import Capston.RentEasy_BackEnd.global.enums.Role;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SecurityMemberDTO {
    private final Long id;
    private String name;
    private Role role;

    public static SecurityMemberDTO fromClaims(Claims claims) {
        return SecurityMemberDTO.builder()
                .id(Long.valueOf(claims.getId()))
                .name(claims.get("name", String.class))
                .role(Role.valueOf(claims.get("role", String.class)))
                .build();
    }
}
