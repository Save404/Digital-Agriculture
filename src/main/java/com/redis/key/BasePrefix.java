package com.redis.key;

import com.redis.key.KeyPrefix;

public abstract class BasePrefix implements KeyPrefix {

    private int expireSecond;

    private String prefix;

    public BasePrefix(int expireSecond, String prefix) {
        this.expireSecond = expireSecond;
        this.prefix = prefix;
    }

    @Override
    public int expireSecond() {//默认0代表永不过期
        return expireSecond;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix + ":";
    }
}
