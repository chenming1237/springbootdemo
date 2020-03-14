package com.example.demo.service;

import com.example.demo.dao.UserAccountDao;
import com.example.demo.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private Test1Service test1Service;

    @Override
    public List<UserAccount> findList() {
        return userAccountDao.findList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(Long fromId, Long toId, BigDecimal num) {
        reduceAccount(fromId, num);
        try{
            addAccount(toId, num);
        }catch (Exception e){

        }
        //System.out.printf(String.valueOf(1/0));
    }

    @Override
    public void reduceAccount(Long formId, BigDecimal num) {
        userAccountDao.reduceAccount(formId, num);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addAccount(Long userId, BigDecimal num) {
        userAccountDao.addAccount(userId, num);
        UserAccount userAccount = userAccountDao.get(userId);
        System.out.println("李四有余额：" + userAccount.getAccount());
        System.out.printf(String.valueOf(1/0));

    }

}
