package com.guoy.util;

import org.apache.commons.codec.binary.Base64;

public class Base64Helper {

    public static String byteToBase64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] base64ToByte(String base64) {
        return Base64.decodeBase64(base64);
    }

}
