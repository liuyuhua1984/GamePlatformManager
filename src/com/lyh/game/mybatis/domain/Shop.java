package com.lyh.game.mybatis.domain;

import java.io.Serializable;

import com.lyh.game.mybatis.domain.BaseDomain;

public class Shop extends BaseDomain implements Serializable {
    /**
     * 商品名称
     */
    private String shopName;

    /**
     * 单价(人民币)
     */
    private Float price;

    /**
     * 充值量
     */
    private Integer num;

    /**
     * 赠送数量
     */
    private Integer presentNum;

    /**
     * 折扣(0和100表示原价,)
     */
    private Integer discount;

    /**
     * 售理代理类型
     */
    private Integer sellAgentType;

    /**
     * 上架为1
     */
    private Byte itemOn;

    /**
     * 商品类型
     */
    private Integer type;

    /**
     * shop
     */
    private static final long serialVersionUID = 1L;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPresentNum() {
        return presentNum;
    }

    public void setPresentNum(Integer presentNum) {
        this.presentNum = presentNum;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getSellAgentType() {
        return sellAgentType;
    }

    public void setSellAgentType(Integer sellAgentType) {
        this.sellAgentType = sellAgentType;
    }

    public Byte getItemOn() {
        return itemOn;
    }

    public void setItemOn(Byte itemOn) {
        this.itemOn = itemOn;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shopName=").append(shopName);
        sb.append(", price=").append(price);
        sb.append(", num=").append(num);
        sb.append(", presentNum=").append(presentNum);
        sb.append(", discount=").append(discount);
        sb.append(", sellAgentType=").append(sellAgentType);
        sb.append(", itemOn=").append(itemOn);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}