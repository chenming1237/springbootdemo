package com.example.demo.dao;

import com.example.demo.domain.UserAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface UserAccountDao {

    @Select("select * from user_account")
    List<UserAccount> findList();

    @Select("select * from user_account where id = #{id}")
    UserAccount get(@Param("id")Long userId);

    @Update("UPDATE user_account set account = account + #{num} WHERE id = #{id}")
    void addAccount(@Param("id") Long id, @Param("num") BigDecimal num);

    @Update("UPDATE user_account set account = account - #{num} WHERE id = #{id}")
    void reduceAccount(@Param("id") Long id, @Param("num") BigDecimal num);
}
