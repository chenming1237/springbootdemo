package com.example.demo.service;

import com.example.demo.dao.UserAccountDao;
import com.example.demo.domain.UserAccount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private static final Log log = LogFactory.getLog(TestServiceImpl.class);

    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private Test1Service test1Service;

    @Override
    public List<UserAccount> findList() {
        log.debug("查询所有用户信息");
        return userAccountDao.findList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
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
