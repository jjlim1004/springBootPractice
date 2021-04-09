package com.example.bootWeb.service;

import com.example.bootWeb.domain.TestVo;
import org.springframework.stereotype.Service;

@Service
public interface TestService {
    public void insert();

    public TestVo get();
}
