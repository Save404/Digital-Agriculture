package com.redis.key;

public class GovKey extends BasePrefix{
    public static final int TOKEN_EXPIRE = 3600 * 24;

    private GovKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static GovKey token = new GovKey(TOKEN_EXPIRE,"token");
}

