package com.lyh.game.mybatis.domain;

import java.io.Serializable;

import com.lyh.game.mybatis.domain.BaseDomain;

public class Agent extends BaseDomain implements Serializable {
    /**
     * 代理类型(总代理,一级经销,二级经销,三级经销)
     */
    private Integer type;

    /**
     * 房卡数量
     */
    private Integer roomCards;

    /**
     * 邀请人
     */
    private String inviterName;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 微信号等第三方账号名称
     */
    private String openName;

    /**
     * 电话
     */
    private Long phone;

    /**
     * 下属代理id是一个id集合
     */
    private String subordinateAgentId;

    /**
     * agent
     */
    private static final long serialVersionUID = 1L;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRoomCards() {
        return roomCards;
    }

    public void setRoomCards(Integer roomCards) {
        this.roomCards = roomCards;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName == null ? null : inviterName.trim();
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public String getOpenName() {
        return openName;
    }

    public void setOpenName(String openName) {
        this.openName = openName == null ? null : openName.trim();
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getSubordinateAgentId() {
        return subordinateAgentId;
    }

    public void setSubordinateAgentId(String subordinateAgentId) {
        this.subordinateAgentId = subordinateAgentId == null ? null : subordinateAgentId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", type=").append(type);
        sb.append(", roomCards=").append(roomCards);
        sb.append(", inviterName=").append(inviterName);
        sb.append(", inviteCode=").append(inviteCode);
        sb.append(", openName=").append(openName);
        sb.append(", phone=").append(phone);
        sb.append(", subordinateAgentId=").append(subordinateAgentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}