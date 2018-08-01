package com.common.commonUtils;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String timeId() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHH-mm");
        String id = df.format(System.currentTimeMillis()).replace("-", "");
        return id + uuid().substring(0, 20);
    }

    public static void main(String[] args) {
        System.out.println(timeId());
    }
}
