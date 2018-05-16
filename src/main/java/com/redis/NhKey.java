package com.redis;

public class NhKey extends BasePrefix {

    private NhKey(String prefix) {
        super(prefix);
    }

    public static NhKey getById = new NhKey("id");
}
