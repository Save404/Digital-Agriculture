package com.redis.key;

public interface KeyPrefix {
    public int expireSecond();

    public String getPrefix();
}
