package com.yaojian;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L0    C4    I8     R12
 * E1 T3 O5 E7 S9 I11 I13 G15
 * E2    D6    H10    N14
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class Solution6 implements Solution {

    @Override
    public void solution() {

        // "PHASIYIRPLIGAN" 5
        System.out.println(convert("ABC", 1));
    }

    public String convert(String s, int numRows) {
        char[] sArr = s.toCharArray();
        if (sArr.length == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        // 计算位置的数组
        int slice = 2 * numRows - 2;
        int col = sArr.length / slice;
        int[] arr = new int[col+1];
        arr[0] = 0;
        int pos = 0;
        for (int i = 0; i < sArr.length && pos < col; i += slice) {
            arr[pos++] = i;
        }
        int base = col * slice;
        int remain = sArr.length - base;
        String[] remainArr = new String[remain];
        if (remain <= numRows) {
            for (int i = 0; i < remain; i++) {
                remainArr[i] = sArr[base + i]+"";
            }
        }else {
            remainArr[numRows-1] = sArr[base + numRows - 1] + "";
            for (int i = numRows - 2, j = 1; i >= 0; i--, j++) {

                int left = base + i;
                int right = base + numRows - 1 + j;
                if (right < sArr.length) {
                    remainArr[i] = sArr[left] + "" + sArr[right];
                }else {
                    remainArr[i] = sArr[left]+"";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < col; j++) {
            sb.append(sArr[arr[j]]);
        }
        if (remainArr.length >= 1) {
            sb.append(remainArr[0]);
        }
        /**
         *  * L0    C4    I8     R12
         *  * E1 T3 O5 E7 S9 I11 I13 G15
         *  * E2    D6    H10    N14
         */
        for (int i = 1; i < numRows; i++){
            for (int j = 0; j < col; j++) {
                int left = arr[j] + i;
                int right = arr[j] + 2 * (numRows - 1) - i;
                if (left == right) {
                    sb.append(sArr[left]);
                }else {
                    sb.append(sArr[left] + "" + sArr[right]);
                }
            }
            if (remainArr.length > i) {
                sb.append(remainArr[i]);
            }
        }
        return sb.toString();
    }
}
