package com.admin.util;

import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtil {

    private final static int saltIndex=1;

    private final static int countIndex=12;

    private final static char[] items= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public static String randomDigest(String pass) {
        int randomCountIndex=(int)(Math.random()*items.length);
        int randomSaltIndex=(int)(Math.random()*items.length);

        char count=items[randomCountIndex];
        System.out.println(count);
        char salt=items[randomSaltIndex];
        System.out.println(salt);
        String result=pass+salt;

        for(int i=0;i<count;i++) {
            //加密
            result=DigestUtils.md5Hex(result);
        }
        System.out.println(result);
        //result就是加密之后的字符串
        result=result.substring(0, saltIndex)+salt+result.substring(saltIndex);
        result=result.substring(0, countIndex)+count+result.substring(countIndex);
        System.out.println(result);
        return result;
    }

    public static boolean  decode(String pass,String digestPass) {
        char salt=digestPass.charAt(saltIndex);
        char count=digestPass.charAt(countIndex);

        //开始加密
        String result=pass+salt;
        for(int i=0;i<count;i++) {
            result=DigestUtils.md5Hex(result);
        }
        result=result.substring(0, saltIndex)+salt+result.substring(saltIndex);
        result=result.substring(0, countIndex)+count+result.substring(countIndex);
        return result.equals(digestPass);
    }

    public static void main(String[] args) {
//	randomDigest("123");
        boolean b=decode("123","b08d6397c22135dc3694a2eb227cf752ed");
        System.out.println(b);
    }
}