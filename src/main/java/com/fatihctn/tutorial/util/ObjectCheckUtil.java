package com.fatihctn.tutorial.util;

public class ObjectCheckUtil {

    public static <T> boolean isEmptyObject(T t) {
        return t == null || "".equals(t.toString());
    }
}
