package com.lyh.game.mybatis.domain;

import java.io.Serializable;

import com.lyh.game.mybatis.domain.BaseDomain;

public class UserPay extends BaseDomain implements Serializable {
    /**
     * 玩家id
     */
    private Long userId;

    /**
     * 充值前的数量
     */
    private Integer pay_before_num;

    /**
     * 充值数量
     */
    private Integer payNum;

    /**
     * 充值后的数量
     */
    private Integer payAfterNum;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 充值是否成功,成功为1
     */
    private Byte paySucess;

    /**
     * 充值类型1,人民币
     */
    private Integer payType;

    /**
     * user_pay
     */
    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPay_before_num() {
        return pay_before_num;
    }

    public void setPay_before_num(Integer pay_before_num) {
        this.pay_before_num = pay_before_num;
    }

    public Integer getPayNum() {
        return payNum;
    }

    public void setPayNum(Integer payNum) {
        this.payNum = payNum;
    }

    public Integer getPayAfterNum() {
        return payAfterNum;
    }

    public void setPayAfterNum(Integer payAfterNum) {
        this.payAfterNum = payAfterNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Byte getPaySucess() {
        return paySucess;
    }

    public void setPaySucess(Byte paySucess) {
        this.paySucess = paySucess;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", pay_before_num=").append(pay_before_num);
        sb.append(", payNum=").append(payNum);
        sb.append(", payAfterNum=").append(payAfterNum);
        sb.append(", orderId=").append(orderId);
        sb.append(", paySucess=").append(paySucess);
        sb.append(", payType=").append(payType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}