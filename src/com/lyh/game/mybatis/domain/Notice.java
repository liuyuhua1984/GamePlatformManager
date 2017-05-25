package com.lyh.game.mybatis.domain;

import java.io.Serializable;

import com.lyh.game.mybatis.domain.BaseDomain;

public class Notice extends BaseDomain implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 是否已发送
     */
    private Byte isSend;

    /**
     * 运行次数
     */
    private Integer runCount;

    /**
     * 公告类型,1大厅
     */
    private Byte type;

    /**
     * 公告内容
     */
    private String content;

    /**
     * notice
     */
    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getIsSend() {
        return isSend;
    }

    public void setIsSend(Byte isSend) {
        this.isSend = isSend;
    }

    public Integer getRunCount() {
        return runCount;
    }

    public void setRunCount(Integer runCount) {
        this.runCount = runCount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", title=").append(title);
        sb.append(", isSend=").append(isSend);
        sb.append(", runCount=").append(runCount);
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}