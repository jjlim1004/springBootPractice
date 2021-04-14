package com.example.bootWeb.service.test;

import com.example.bootWeb.domain.vo.TestVo;
import com.example.bootWeb.mapper.MemberMapper;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TestServiceImpl implements TestService{

    private MemberMapper mapper;

    @Override
    public void insert() {

    }

    @Override
    public TestVo get() {
        return null;
    }
}
