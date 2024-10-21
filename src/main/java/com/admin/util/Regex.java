package com.admin.util;

public class Regex {


    private static final String regexitem = "^\\w{6,16}$";

    public static boolean matches(String regex, String... strs) {
        boolean result = true;
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].matches(regex)) {
                result = false;
                return result;
            }
        }
        return result;
    }

    public static boolean matchesItem(String... strs) {
        boolean result = true;
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].matches(regexitem)) {
                result = false;
                return result;
            }
        }
        return result;
    }

}