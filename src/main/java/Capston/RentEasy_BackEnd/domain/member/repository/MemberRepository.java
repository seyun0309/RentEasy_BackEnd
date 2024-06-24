package Capston.RentEasy_BackEnd.domain.member.repository;

import Capston.RentEasy_BackEnd.domain.member.domain.Member;
import Capston.RentEasy_BackEnd.global.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    @Modifying
    @Query("UPDATE Member m SET m.refreshToken = :refreshToken WHERE m.id = :id")
    void updateRefreshToken(@Param("id") Long id, @Param("refreshToken") String refreshToken);

    @Query("SELECT m.role FROM Member m WHERE m.id = :memberId AND m.deletedAt IS NULL")
    Optional<Role> findRoleById(Long memberId);
}
