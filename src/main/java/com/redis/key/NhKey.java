package com.redis.key;

public class NhKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600 * 24;

    private NhKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static NhKey token = new NhKey(TOKEN_EXPIRE,"token");
}
