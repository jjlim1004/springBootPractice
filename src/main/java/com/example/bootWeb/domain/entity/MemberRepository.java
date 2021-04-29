package com.example.bootWeb.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByMemberEmail(String memberEmail);

    //첫번째로 사용하는 파라미터 ?1
    //혹은 @param()으로 감싸고 :parameter 로 사용하기
    @Query("select m from Member m where m.memberId=?1")
    Member findByMemberId(String memberId);

//    @Query(value = "delete from Member m where m.member_no=:memberNo")
//    void memberOut( @Param("memberNo") long memberNo);

}
