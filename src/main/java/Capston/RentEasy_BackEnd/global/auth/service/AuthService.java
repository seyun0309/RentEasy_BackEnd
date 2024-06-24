package Capston.RentEasy_BackEnd.global.auth.service;


import Capston.RentEasy_BackEnd.domain.member.domain.Member;
import Capston.RentEasy_BackEnd.domain.member.repository.MemberRepository;
import Capston.RentEasy_BackEnd.global.auth.dto.GeneratedTokenDTO;
import Capston.RentEasy_BackEnd.global.auth.dto.SecurityMemberDTO;
import Capston.RentEasy_BackEnd.global.auth.dto.SignUpRequestDTO;
import Capston.RentEasy_BackEnd.global.auth.dto.SignUpResponseDTO;
import Capston.RentEasy_BackEnd.global.auth.jwt.JwtProvider;
import Capston.RentEasy_BackEnd.global.enums.ErrorCode;
import Capston.RentEasy_BackEnd.global.enums.Role;
import Capston.RentEasy_BackEnd.global.error.exception.BusinessException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static Capston.RentEasy_BackEnd.global.enums.Role.BUILDING_OWNER;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        //이메일 중복 확인
        Optional<Member> findEmail = memberRepository.findByEmail(signUpRequestDTO.getEmail());
        if (findEmail.isPresent()) {
            throw new BusinessException(ErrorCode.MEMBER_PROFILE_DUPLICATION);
        }

        //사용자 역할 설정(기본값 = 건물주)
        Role role = BUILDING_OWNER;

        String hashedPassword = passwordEncoder.encode(signUpRequestDTO.getPassword());
        Member member = Member.builder()
                .name(signUpRequestDTO.getUserName())
                .email(signUpRequestDTO.getEmail())
                .password(hashedPassword)
                .phoneNumber(signUpRequestDTO.getPhoneNumber())
                .build();
        member.setRole(role);

        memberRepository.save(member);
        return SignUpResponseDTO.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }

    @Transactional
    public GeneratedTokenDTO login(String email, String password) {
        Optional<Member> findEmail = memberRepository.findByEmail(email);

        if (findEmail.isPresent()) {
            Member member = findEmail.get();
            if (passwordEncoder.matches(password, member.getPassword())) {
                SecurityMemberDTO securityMemberDTO = SecurityMemberDTO.builder()
                        .id(member.getId())
                        .role(member.getRole())
                        .name(member.getName())
                        .build();

                GeneratedTokenDTO generatedTokenDTO = jwtProvider.generateTokens(securityMemberDTO);

                return generatedTokenDTO;
            } else {
                throw new BusinessException(ErrorCode.INVALID_PASSWORD);
            }
        } else {
            throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE);
        }
    }
}
