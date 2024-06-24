package Capston.RentEasy_BackEnd.global.auth.controller;


import Capston.RentEasy_BackEnd.global.auth.dto.GeneratedTokenDTO;
import Capston.RentEasy_BackEnd.global.auth.dto.LoginRequestDTO;
import Capston.RentEasy_BackEnd.global.auth.dto.SignUpRequestDTO;
import Capston.RentEasy_BackEnd.global.auth.dto.SignUpResponseDTO;
import Capston.RentEasy_BackEnd.global.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입 로직" , description = "이메일, 비밀번호, 사용자 이름, 전화번호를 사용하여 회원가입을 진행합니다.")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody @Valid SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO responseDTO = authService.signUp(signUpRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인 로직" , description = "이메일과 비밀번호 사용하여 로그인을 진행합니다.")
    public ResponseEntity<GeneratedTokenDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        String email = String.valueOf(loginRequestDTO.getEmail());
        String password = String.valueOf(loginRequestDTO.getPassword());
        GeneratedTokenDTO generatedTokenDTO = authService.login(email, password);
        return ResponseEntity.ok(generatedTokenDTO);
    }
}
