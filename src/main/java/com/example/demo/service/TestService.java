package com.example.demo.service;

import com.example.demo.domain.UserAccount;

import java.math.BigDecimal;
import java.util.List;

public interface TestService {
    List<UserAccount> findList();

    void transfer(Long formId, Long toId, BigDecimal num);

    void reduceAccount(Long formId, BigDecimal num);

    void addAccount(Long userId, BigDecimal num);

}
