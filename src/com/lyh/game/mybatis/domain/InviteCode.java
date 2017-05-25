package com.lyh.game.mybatis.domain;

import java.io.Serializable;

import com.lyh.game.mybatis.domain.BaseDomain;

public class InviteCode extends BaseDomain implements Serializable {
    /**
     * 邀请码
     */
    private String code;

    /**
     * 代理id
     */
    private Long agentId;

    /**
     * 是否使用,使用为1
     */
    private Byte isUse;

    /**
     * invite_code
     */
    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", agentId=").append(agentId);
        sb.append(", isUse=").append(isUse);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}