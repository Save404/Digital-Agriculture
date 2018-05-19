package com.redis;

public class MjKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600 * 24;

    private MjKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static MjKey token = new MjKey(TOKEN_EXPIRE,"token");
}
