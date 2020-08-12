package com.yaojian;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */
public class Solution11 implements Solution {

    @Override
    public void solution() {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    /**
     * 双指针求解
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length-1;
        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(height[left] * (right - left), maxArea);
                left++;
            }else {
                maxArea = Math.max(height[right] * (right - left), maxArea);
                right--;
            }
        }
        return maxArea;
    }

    /**
     * 暴力求解
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < height.length - i; j++) {
                int h = Math.min(height[j], height[j + i]);
                maxArea = Math.max(h * i, maxArea);
            }
        }
        return maxArea;
    }
}
