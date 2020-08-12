package com.yaojian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Solution1 implements Solution {

    @Override
    public void solution() {
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 6)));
    }

    public int[] twoSum2(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            int find = numsMap.getOrDefault(remain, -1);
            if (find == i || find == -1) {
                continue;
            }else if (find < i){
                res[0] = find;
                res[1] = i;
            }else{
                res[0] = i;
                res[1] = find;
            }
        }
        return res;
    }

    /**
     * 暴力求解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
