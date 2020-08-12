package com.yaojian;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 implements Solution {

    @Override
    public void solution() {
        System.out.println(lengthOfLongestSubstring("   "));
    }

    /**
     * 采用滑动窗口的思想，创建一个数组保留每个字母出现的最后位置
     * 同时设立left指针，当出现重复时将left-set[pos]中的位置置0，set[pos]-right中的元素为干净的元素不会出现重复
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        char[] sArr = s.toCharArray();
        int[] set = new int[128];
        int maxNum = 0, tmpNum = 0;
        while (right < sArr.length){
            if (set[sArr[right]] == 0) {
                set[sArr[right]] = right+1;
                right++;
                tmpNum++;
                if (tmpNum > maxNum) {
                    maxNum = tmpNum;
                }
            }else{
                int tmp = set[sArr[right]];
                for (int i = left; i < set[sArr[right]]; i++) {
                    set[sArr[i]] = 0;
                }
                left = tmp;
                set[sArr[right]] = right + 1;
                tmpNum = right - left + 1;
                right++;
            }
        }
        return maxNum;
    }
}
