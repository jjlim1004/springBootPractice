package com.example.bootWeb.service.member;

import com.example.bootWeb.config.SessionMember;
import com.example.bootWeb.domain.dto.UpdateInfoDTO;
import com.example.bootWeb.domain.entity.Member;
import com.example.bootWeb.domain.entity.MemberRepository;
import com.example.bootWeb.domain.entity.Password;
import com.example.bootWeb.domain.entity.PasswordRepository;
import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Override
    public int join(Member member, Password password) {

        if(memberRepository.findByMemberId(member.getMemberId()) != null ){
            return 1; //회원가입 실패 -- 이미 존재하는 아이디
        }
        memberRepository.save(member);
        passwordRepository.save(password);
        return 0; //회원가입 정상 종료
    }

    @Override
    public SessionMember login(String loginId, String loginPw) {
        String pw = passwordRepository.findPwByMemberId(loginId);
        if(pw!=null && pw.equals(loginPw)){
            Member member = memberRepository.findByMemberId(loginId);
            SessionMember sessionMember = new SessionMember(member);
            return sessionMember;
        }
        return null;
    }

    @Override
    public void updateInfo(UpdateInfoDTO updateInfoDTO) {
        memberMapper.update(updateInfoDTO);
        memberMapper.updatePw(updateInfoDTO);
    }

}
