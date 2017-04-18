import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yananester on 4/17/17.
 */
public class PartOneTests {

    public boolean checkEachNumber(String generatedString) {
        boolean result = true;
        for (int k = 0; k < generatedString.length(); k++) {
            char currentChar = generatedString.charAt(k);
            result = currentChar == '0' || currentChar == '1';
        }
        return result;
    }

    public boolean checkNumInEachString(String generatedString, int w) {
        return generatedString.length() == w;
    }


    public boolean checkGenerateStringsFunction(String[] generatedStrings, int w) {
        double resultsNumber = getResultsNumber(w);
        //the simplest check and less expensive (answer fot point 2 in Part 1)
        if (resultsNumber != generatedStrings.length) {
            return false;
        }

        Set<String> setStrings = new HashSet<String>();
        Collections.addAll(setStrings, generatedStrings);
        if (resultsNumber != setStrings.size()) {
            return false;
        }
        for (String generatedString : setStrings) {
            if (!isStringValid(generatedString, w)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStringValid(String generatedString, int w) {
        return checkEachNumber(generatedString) && checkNumInEachString(generatedString, w);
    }

    public double getResultsNumber(int w) {
        return Math.pow(2, w);
    }

    @Test
    public void positiveTest() {
        int w = 3;
        String[] generatedStrings = PartOne.generateStrings(w);
        Assert.assertTrue(checkGenerateStringsFunction(generatedStrings, w));
    }

    @Test
    public void negativeTest() {
        int w = 4;
        String[] generatedStrings = PartOne.generateStrings(w);
        Assert.assertFalse(checkGenerateStringsFunction(generatedStrings, w));
    }
}
//3) For a width w, how many strings are expected to be generated?
//I used Math.pow(2, w)
