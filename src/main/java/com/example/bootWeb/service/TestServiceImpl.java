package com.example.bootWeb.service;

import com.example.bootWeb.domain.TestVo;
import com.example.bootWeb.mapper.TestMapper;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TestServiceImpl implements TestService{

    private TestMapper mapper;

    @Override
    public void insert() {

    }

    @Override
    public TestVo get() {
        return null;
    }
}
