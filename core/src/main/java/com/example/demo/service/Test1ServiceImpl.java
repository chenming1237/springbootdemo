package com.example.demo.service;

import com.example.demo.dao.UserAccountDao;
import com.example.demo.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addAccount(Long userId, BigDecimal num) {
        userAccountDao.addAccount(userId, num);
        UserAccount userAccount = userAccountDao.get(userId);
        System.out.println("李四有余额：" + userAccount.getAccount());
        //System.out.printf(String.valueOf(1/0));

    }

}
