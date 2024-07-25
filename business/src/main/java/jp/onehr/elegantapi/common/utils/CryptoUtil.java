package jp.onehr.elegantapi.common.utils;

import cn.hutool.crypto.digest.DigestUtil;

public class CryptoUtil {

    public static String md5Hash(String input,String salt) {
        return DigestUtil.md5Hex(input+salt);
    }

    public static String sha256Hash(String input,String salt) {
        return DigestUtil.sha256Hex(input+salt);
    }

}
