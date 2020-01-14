package com.yhh.leetcode;

import static com.yhh.common.PrintUtils.println;

/**
 * @author happyfeet
 * @since Jan 13, 2020
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class Solution4 {

    /**
     * 解题思路：
     *
     * 一、将所有元素分为 left_part 和 right_part 两部分，两边元素个数应该一样（中位数性质）
     *
     * 1、len(left_part) == len(right_part)
     * 2、max(left_part) == min(right_part)
     *
     * 假设存在 i (对应于数组 A), j (对应于数组 B)使得上式成立，则可得到：
     *
     * (1)、第一个条件
     * i + j = (m - i) + (n - j)        ==> n + m 为偶数时
     * 或者
     * i + j = (m - i) + (n - j) + 1    ==> n + m 为奇数时
     *
     * (2)、第二个条件
     *  A(i - 1) <= B(j)
     *  B(j - 1) <= A(i)
     *
     * 二、边界条件判断原理：i = 0; j = 0; i = m; j = n;
     *
     * left_part      |  right_part
     * [0 ~ (i - 1)]  |  [i ~ (m - 1)]
     * [0 ~ (j - 1)]  |  [j ~ (n - 1)]
     *
     * 当 i = 0 时，说明 [0 ~ (m - 1)] 在 right_part
     * 当 j = 0 时，说明 [0 ~ (n - 1)] 在 right_part
     * 当 i = m 时，说明 [0 ~ (m - 1)] 在 left_part
     * 当 j = n 时，说明 [0 ~ (n - 1)] 在 left_part
     *
     * 三、为什么需要 m <= n ?
     *
     * i ∈ [0, m]
     * j = (m + n) / 2 - i <= (m + n) / 2 - m = (n - m) / 2
     * 即 j <= (n - m) / 2，如果 m > n，j 可能小于 0，为了避免出现这种情况，所以 m <= n.
     *
     * 四、两个推论（可以分别少一个判断）
     * i > 0 ===> j < n
     * i < m ===> j > 0
     *
     * 前提：m <= n
     * i = (m + n) / 2 - j > 0 ==> j < (m + n) / 2 <= (n + n) / 2 = n   ==> j < n
     * j = (m + n) / 2 - i > (m + n) / 2 - m = (n - m) / 2 >= 0         ==> j > 0
     *
     * @param nums1 有序数组
     * @param nums2 有序数组
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

//        return findMedianSortedArraysWithMaxLeft(nums1, nums2);

        return findMedianSortedArraysWithMinRight(nums1, nums2);
    }

    private double findMedianSortedArraysWithMaxLeft(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int i;
        int j;
        int half = (m + n + 1) / 2;

        int iMin = 0;
        int iMax = m;

        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = half - i;

            if (i > 0 && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (i < m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else {

                int maxLeft;

                // 说明 num1 全在右半部分
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                    // 说明 num1 全在右半部分
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                // 说明 num1 全在左边
                if (i == m) {
                    minRight = nums2[j];
                    // 说明 num2 全在左边
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    private double findMedianSortedArraysWithMinRight(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int i;
        int j;
        int half = (m + n) / 2;
        /*
         i + j = (m + n) / 2 等于左边的元素个数，如果为奇数的话，由于 (m + n) / 2 的特性（比如(3 + 4) / 2 = 3，即左边元素为 3），
         多出来的值就会被分在 right_part，
         所以这里不 +1，下面求出来 minRight 就可以直接返回；
         如果这里 +1（比如(3 + 4 + 1) / 2 = 4，即左边元素为 4），那么多出来的一个值会分配在 left_part，求出来 maxLeft 即可直接返回。
         */

        int iMin = 0;
        int iMax = m;

        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = half - i;

            if (i > 0 && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (i < m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else {

                int minRight;
                // 说明 num1 全在左边
                if (i == m) {
                    minRight = nums2[j];
                    // 说明 num2 全在左边
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                if ((m + n) % 2 == 1) {
                    return minRight;
                }

                int maxLeft;

                // 说明 num1 全在右半部分
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                    // 说明 num1 全在右半部分
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {

        Solution4 solution4 = new Solution4();

        int[] num1 = {0, 1, 2, 3, 4};
        int[] num2 = {5, 6, 7, 8, 9, 10};

        double medianSortedArrays = solution4.findMedianSortedArrays(num1, num2);

        println("result is : {}", medianSortedArrays);

    }

}
