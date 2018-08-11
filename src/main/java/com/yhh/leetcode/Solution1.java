package com.yhh.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    /**
     * https://leetcode.com/problems/two-sum/description/
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> valueToIndex = new HashMap<>(nums.length);
        valueToIndex.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                return new int[]{i, valueToIndex.get(target - nums[i])};
            }
        }
        return null;
    }
}
