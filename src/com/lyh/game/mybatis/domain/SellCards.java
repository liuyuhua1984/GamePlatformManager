package com.lyh.game.mybatis.domain;

import java.io.Serializable;

import com.lyh.game.mybatis.domain.BaseDomain;

public class SellCards extends BaseDomain implements Serializable {
    /**
     * 买的玩家账号
     */
    private String buyOpenId;

    /**
     * 卖房卡玩家的账号
     */
    private String sellOpenId;

    /**
     * 销售的房卡
     */
    private Integer roomCards;

    /**
     * 房卡剩余数量
     */
    private Integer remainCards;

    /**
     * 出售类型1房卡
     */
    private Integer sellType;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * sell_cards
     */
    private static final long serialVersionUID = 1L;

    public String getBuyOpenId() {
        return buyOpenId;
    }

    public void setBuyOpenId(String buyOpenId) {
        this.buyOpenId = buyOpenId == null ? null : buyOpenId.trim();
    }

    public String getSellOpenId() {
        return sellOpenId;
    }

    public void setSellOpenId(String sellOpenId) {
        this.sellOpenId = sellOpenId == null ? null : sellOpenId.trim();
    }

    public Integer getRoomCards() {
        return roomCards;
    }

    public void setRoomCards(Integer roomCards) {
        this.roomCards = roomCards;
    }

    public Integer getRemainCards() {
        return remainCards;
    }

    public void setRemainCards(Integer remainCards) {
        this.remainCards = remainCards;
    }

    public Integer getSellType() {
        return sellType;
    }

    public void setSellType(Integer sellType) {
        this.sellType = sellType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", buyOpenId=").append(buyOpenId);
        sb.append(", sellOpenId=").append(sellOpenId);
        sb.append(", roomCards=").append(roomCards);
        sb.append(", remainCards=").append(remainCards);
        sb.append(", sellType=").append(sellType);
        sb.append(", orderId=").append(orderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}