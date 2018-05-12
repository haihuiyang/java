package com.yhh.example;

import com.yhh.common.PrintUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {


    private static String DIGIT_WITH_ALPHABET_REGEX_STR = "[1-9a-zA-Z]+";
    private Pattern pattern;

    @Before
    public void init() {
        pattern = Pattern.compile(DIGIT_WITH_ALPHABET_REGEX_STR);
    }

    @Test
    public void testFindDigitWithAlphabet() {
        String testStr = "1Thi44s is a re1gex te3st.is";
        Matcher matcher = pattern.matcher(testStr);
        Integer i = 0;
        while (matcher.find()) {
            PrintUtils.println("group " + i++ + " : " + matcher.group());
        }
        /*
        result:
            group 0 : 1Thi44s
            group 1 : is
            group 2 : a
            group 3 : re1gex
            group 4 : te3st
            group 5 : is
         */
    }
}
