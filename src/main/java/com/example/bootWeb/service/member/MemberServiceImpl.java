package com.example.bootWeb.service.member;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.vo.entity.Member;
import com.example.bootWeb.domain.vo.entity.MemberRepository;
import com.example.bootWeb.domain.vo.entity.Password;
import com.example.bootWeb.domain.vo.entity.PasswordRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

//    @Autowired
//    MemberMapper memberMapper;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Override
    public int join(Member member, Password password) {
        if(memberRepository.findByMemberId(member.getMemberId()) != null ){
            return 1; //로그인 실패
        }
        memberRepository.save(member);
        passwordRepository.save(password);
        return 0; //회원가입 정상 종료
    }

    @Override
    public Map<Integer, SessionMember> login(String loginId, String loginPw) {
        Member member = memberRepository.findByMemberId(loginId);
        Map<Integer,SessionMember> map = new HashMap<>();
        SessionMember sessionMember = new SessionMember(member);
        if(member != null){
            String pw = passwordRepository.findByMemberId(member.getMemberId());
            if(pw.equals(loginPw)){
                map.put(0,sessionMember);
                return map; //로그인 성공
            }
            map.put(1,null);
            return map; //1은 잘못된 비밀번호
        }
        map.put(2,null);
        return map; //2는 잘못된 아이디
    }


}
