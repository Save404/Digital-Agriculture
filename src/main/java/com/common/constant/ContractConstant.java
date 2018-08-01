package com.common.constant;

public class ContractConstant {

    /** 同意销售 */
    public static final Integer CONTRACT_STATU_AGREE = 1;

    /** 拒绝销售 */
    public static final Integer CONTRACT_STATU_CANCEL = 2;

    /** 等待收货 */
    public static final Integer CONTRACT_STATU_SHIP = 3;

    /** 订单完成 */
    public static final Integer CONTRACT_STATU_FINISH = 4;

    /** 尚未支付 */
    public static final Integer CONTRACT_PAY_STATU_UNFINISH = 0;

    /** 已支付 */
    public static final Integer CONTRACT_PAY_STATU_FINISH = 1;
}
