package com.example.bootWeb.service.test;

import com.example.bootWeb.domain.dto.vo.TestVo;
import com.example.bootWeb.domain.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {
    public void insert();

    public TestVo get();

    public List<Member> getMemberList(int pageNum);
}
