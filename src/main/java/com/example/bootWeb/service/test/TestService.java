package com.example.bootWeb.service.test;

import com.example.bootWeb.domain.dto.vo.TestVo;
import org.springframework.stereotype.Service;

@Service
public interface TestService {
    public void insert();

    public TestVo get();
}
