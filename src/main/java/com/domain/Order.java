package com.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String orderId;
    private String mjBasicId;
    private BigDecimal orderPayment;
    @DecimalMin(value = "0", message = "运费不能为0")
    private BigDecimal postFee;
    private String buyerMessage;
    private String orderShippingId;
    private String orderShippingCode;
    private Integer orderStatus;
    private Integer payStatus;
    private Integer postStatus;
    @NotEmpty(message = "收获地址不能为空")
    private String addressId;
    private Date orderCreated;
    private Date orderUpdated;
    @NotEmpty(message = "农户ID不能为空")
    private String nhBasicid;
    @DecimalMin(value = "0", message = "数量不能为空")
    private BigDecimal orderNumber;
    private String alipay;
    @NotEmpty(message = "单位不能为空")
    private String orderUnit;
    @NotEmpty(message = "商品ID不能为空")
    private String goodId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMjBasicId() {
        return mjBasicId;
    }

    public void setMjBasicId(String mjBasicId) {
        this.mjBasicId = mjBasicId;
    }

    public BigDecimal getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(BigDecimal orderPayment) {
        this.orderPayment = orderPayment;
    }

    public BigDecimal getPostFee() {
        return postFee;
    }

    public void setPostFee(BigDecimal postFee) {
        this.postFee = postFee;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getOrderShippingId() {
        return orderShippingId;
    }

    public void setOrderShippingId(String orderShippingId) {
        this.orderShippingId = orderShippingId;
    }

    public String getOrderShippingCode() {
        return orderShippingCode;
    }

    public void setOrderShippingCode(String orderShippingCode) {
        this.orderShippingCode = orderShippingCode;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Date getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(Date orderCreated) {
        this.orderCreated = orderCreated;
    }

    public Date getOrderUpdated() {
        return orderUpdated;
    }

    public void setOrderUpdated(Date orderUpdated) {
        this.orderUpdated = orderUpdated;
    }

    public String getNhBasicid() {
        return nhBasicid;
    }

    public void setNhBasicid(String nhBasicid) {
        this.nhBasicid = nhBasicid;
    }

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", mjBasicId='" + mjBasicId + '\'' +
                ", orderPayment=" + orderPayment +
                ", postFee=" + postFee +
                ", buyerMessage='" + buyerMessage + '\'' +
                ", orderShippingId='" + orderShippingId + '\'' +
                ", orderShippingCode='" + orderShippingCode + '\'' +
                ", orderStatus=" + orderStatus +
                ", payStatus=" + payStatus +
                ", postStatus=" + postStatus +
                ", addressId='" + addressId + '\'' +
                ", orderCreated=" + orderCreated +
                ", orderUpdated=" + orderUpdated +
                ", nhBasicid='" + nhBasicid + '\'' +
                ", orderNumber=" + orderNumber +
                ", alipay='" + alipay + '\'' +
                ", orderUnit='" + orderUnit + '\'' +
                ", goodId='" + goodId + '\'' +
                '}';
    }
}
