package com.hui.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 辉
 */
public class  AccountBook implements Serializable {
    private Long id;

    private String moneyId;

    private BigDecimal money;

    private String reason;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date moneyTime;

    private Long moneyType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId == null ? null : moneyId.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(Date moneyTime) {
        this.moneyTime = moneyTime;
    }

    public Long getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Long moneyType) {
        this.moneyType = moneyType;
    }
}