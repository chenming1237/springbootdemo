package com.example.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserAccount implements Serializable {

    private static final long serialVersionUID = -8977610729468317543L;

    private Long id;

    private String name;

    private BigDecimal account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }
}
