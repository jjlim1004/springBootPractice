package com.example.bootWeb;

import com.example.bootWeb.domain.dto.vo.Role;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.entity.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureMybatis
//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember(){
        for(int i = 1 ; i<=100; i++){
            String s =Integer.toString(i);
            Member member =Member.builder().memberId(s).memberAge(s).memberEmail(s).memberName(s).memberGender(s).role(Role.USER).build();
            memberRepository.save(member);
        }
    }
}
