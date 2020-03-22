package com.yhh.example;

import java.util.Scanner;

/**
 * @author happyfeet
 * @since Mar 06, 2020
 */
public class Main2021 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int low = in.nextInt();
        int high = in.nextInt();
        System.out.println(findMinValue(low, high));

    }

    /*
        找到 [low, high) 中所有质数的十位数之和和个位数之和的较小值
     */
    public static int findMinValue(int low, int high) {

        int tensDigitSum = 0;
        int unitsDigitSum = 0;

        for (int index = low; index < high; index++) {

            if (isPrimeNumber(index)) {
                unitsDigitSum += index % 10;
                tensDigitSum += (index % 100) / 10;
            }
        }
        return Math.min(unitsDigitSum, tensDigitSum);
    }

    private static boolean isPrimeNumber(int value) {

        int index = 2;

        while (index < value) {
            if (value % index == 0) {
                return false;
            }
            index++;
        }

        return true;
    }

}
