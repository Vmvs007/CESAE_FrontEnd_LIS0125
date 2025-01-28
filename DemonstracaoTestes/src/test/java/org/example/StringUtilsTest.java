package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void testIsPalindromeTrue(){
        assertTrue(StringUtils.isPalindrome("ana"));
        assertTrue(StringUtils.isPalindrome("ovo"));
    }

    @Test
    public void testIsPalindromeOneLetter(){
        assertFalse(StringUtils.isPalindrome("o"));
        assertFalse(StringUtils.isPalindrome("q"));
    }

    @Test
    public void testIsPalindromeTwoLetters(){
        assertFalse(StringUtils.isPalindrome("aa"));
        assertFalse(StringUtils.isPalindrome("av"));
    }

    @Test
    public void testIsPalindromeFalse(){
        assertFalse(StringUtils.isPalindrome("vitor"));
        assertFalse(StringUtils.isPalindrome("quality assurance"));
    }

    @Test
    public void testIsPalindromeNull(){
        assertFalse(StringUtils.isPalindrome(null));
    }

}