package com.yaojian;

import java.util.Stack;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5 implements Solution {

    @Override
    public void solution() {
        System.out.println(longestPalindrome2("abcda"));
    }

    public String longestPalindrome(String s) {
        char[] sArr = s.toCharArray();
        if (sArr.length == 0) {
            return "";
        }
        int[][] dp = new int[sArr.length][sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            dp[i][i] = 1;
        }
        int maxLeft = 0, maxRight = 0;
        for (int slice = 1; slice < sArr.length; slice++) {
            for (int i = 0; i < sArr.length - slice; i++) {
                int right = i + slice;
                if (sArr[i] == sArr[right]) { // 相等，计算dp[i][right]的值
                    if (slice == 1) {
                        dp[i][right] = 2;
                    }else{
                        dp[i][right] = dp[i+1][right-1] == 0? 0: dp[i+1][right-1] + 2;
                    }
                    if (dp[i][right] > (maxRight - maxLeft)){
                        maxLeft = i;
                        maxRight = right;
                    }
                }else {
                    dp[i][right] = 0;
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    /**
     * 第二种解决方案
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        char[] sArr = s.toCharArray();
        int maxLeft = 0, maxRight = 0;
        for (int i = 0; i < sArr.length; i++) {
            int len1 = len(sArr, i, i);
            int len2 = len(sArr, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (maxRight - maxLeft)) {
                maxLeft = i - (len - 1) / 2;
                maxRight = i + len / 2;
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    private int len(char[] sArr, int left, int right) {
        int tmpL = left, tmpR = right;
        while (tmpL >= 0 && tmpR < sArr.length && sArr[tmpL] == sArr[tmpR]) {
            tmpL--;
            tmpR++;
        }
        return tmpR - tmpL - 1;
    }
}
