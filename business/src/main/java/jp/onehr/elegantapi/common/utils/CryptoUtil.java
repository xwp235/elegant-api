package jp.onehr.elegantapi.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptoUtil {

    public static String md5Hash(String input,String salt) {
        return DigestUtils.md5Hex(input+salt);
    }

    public static String sha256Hash(String input,String salt) {
        return DigestUtils.sha256Hex(input+salt);
    }

}
