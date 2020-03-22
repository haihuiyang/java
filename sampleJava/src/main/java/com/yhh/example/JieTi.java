package com.yhh.example;

/**
 * @author happyfeet
 * @since Mar 11, 2020
 */
public class JieTi {

    /*
    有很多楼梯，每迈一步 1，2，3 个台阶

    n 阶

    输出：下面走到 n 个台阶总共有多少总走法

    1 -> 1
    2 -> 1,1 2
    3 -> 1,1,1 1,2 2,1 3

    n 在 10000 左右
     */

    public int findTotalWays(int n) {

        /*
        f1 = 1
        f2 = 2
        f3 = 4
        fn = f(n-1) + f(n-2) + f(n-3)
         */

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int[] f1ToFn = new int[n];

        f1ToFn[0] = 1;
        f1ToFn[1] = 2;
        f1ToFn[2] = 4;

        for (int i = 3; i < n; i++) {
            f1ToFn[i] = f1ToFn[i - 1] + f1ToFn[i - 2] + f1ToFn[i - 3];
        }

        return f1ToFn[n - 1];
    }
}
