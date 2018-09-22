package solution.datastructure.offer;

import android.util.Log;

public class RegularExpressionsMatching_19 {

    private static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null || str.length == 0 || pattern.length == 0)
            return false;

        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int pIndex) {
        // 字符串和模式都已操作完，返回true
        if (strIndex >= str.length && pIndex >= pattern.length)
            return true;
        // 字符串没有操作完，模式操作完，返回false
        if (strIndex < str.length && pIndex >= pattern.length)
            return false;
        // 字符串操作完，模式没有操作完
        //字符串操作完，模式没有操作完
        if (strIndex >= str.length && pIndex < pattern.length) {
            if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*')
                return matchCore(str, strIndex, pattern, pIndex + 2);
            else
                return false;
        }

        /**
         * 字符串没有操作完，模式没有操作完
         */
        //如果模式的下一个字符为*
        if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
            //字符串和模式的当前字符能够匹配
            if (str[strIndex] == pattern[pIndex])
                return matchCore(str, strIndex, pattern, pIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, pIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, pIndex);
            else
                return matchCore(str, strIndex, pattern, pIndex + 2);
        } else {
            if (str[strIndex] == pattern[pIndex] || pattern[pIndex] == '.')
                return matchCore(str, strIndex + 1, pattern, pIndex + 1);
            else
                return false;
        }
    }

    public static void main(String[] args) {
        String str = "aba";
        String pattern = "ab*a";

        boolean result = match(str.toCharArray(), pattern.toCharArray());
        System.out.println(result);
    }

}
