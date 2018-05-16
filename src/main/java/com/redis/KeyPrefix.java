package com.redis;

public interface KeyPrefix {
    public int expireSecond();

    public String getPrefix();
}
