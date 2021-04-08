package com.example.bootWeb.mapper;

import com.example.bootWeb.domain.TestVo;

public interface TestMapper {

    public void insert(TestVo testVo);

    public TestVo get(String no);
}
