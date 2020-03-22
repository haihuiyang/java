package com.yhh.example;

import java.util.Scanner;

/**
 * @author happyfeet
 * @since Mar 04, 2020
 */
public class Example10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(findLastWordLength(str));
    }

    public static int findLastWordLength(String str) {

        int length = 0;
        while((length <= str.length() - 1) && (str.charAt(str.length() - length - 1) != ' ')) {
            length++;
        }

        return length;
    }

}
