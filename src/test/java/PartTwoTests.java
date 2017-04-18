import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yananester on 4/17/17.
 */
public class PartTwoTests extends PartOneTests {
    //    1) Write a program that takes a string and returns true if it’s a palindrome
// (do not use string reverse function).

    @Override
    public double getResultsNumber(int w) {
        double resultsNumber = 0;
        if (w % 2 == 0) {
            resultsNumber = Math.pow(2, w / 2);
        } else {
            resultsNumber = Math.pow(2, (w + 1) / 2);
        }
        return resultsNumber;
    }

    public static boolean isItPalindrome(String generatedString) {
        for (int i = 0; i < generatedString.length() / 2; i++) {
            if (generatedString.charAt(i) != generatedString.charAt(generatedString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStringValid(String generatedString, int w) {
        return checkEachNumber(generatedString) && checkNumInEachString(generatedString, w) && isItPalindrome(generatedString);
    }

//    2) Provide all test cases for this palindrome use case


    @Test
    public void positiveTest() {
        int w = 4;
        String[] generatedStrings = PartOne.generatePalindromeStrings(w);
        Assert.assertTrue(checkGenerateStringsFunction(generatedStrings, w));
    }

    @Test
    public void negativeTest() {
        int w = 5;
        String[] generatedStrings = PartOne.generatePalindromeStrings(w);
        Assert.assertFalse(checkGenerateStringsFunction(generatedStrings, w));
    }



//3) For a width w, how many palindromes are expected to be generated?
//    double numRes = 0;
//if(generatedStrings.length%2==0){
//        numRes=Math.pow(2,w/2);
//        }else{
//        numRes=Math.pow(2,(w+1)/2);
//        }



    //Extra test for palindrome (not under requirements)

    @Test
    public void palindromeTestPositive() {
        Assert.assertTrue(isItPalindrome("abccba"));
    }

    @Test
    public void palindromeTestNegative() {
        Assert.assertFalse(isItPalindrome("jfdfhjdf"));
    }

    @Test
    public void palindromeNullString() {
        Assert.assertTrue(isItPalindrome(""));
    }

    @Test
    public void palindromeSpecialCharacters() {
        Assert.assertTrue(isItPalindrome("@!_+&&+_!@"));
    }

    @Test
    public void palindromeNumbers() {
        Assert.assertTrue(isItPalindrome("12344321"));
    }

    @Test
    public void palindromeCaseSensitivity() {
        Assert.assertFalse(isItPalindrome("ABCDdcba"));
    }

    @Test
    public void palindromeDiffLanguages() {
        Assert.assertFalse(isItPalindrome("abcddсbа"));
        // used "a" and "c" in russian language
    }
}
