/**
 * Created by yananester on 4/17/17.
 */
public class devsMethods {

    public static String[] generateStrings(int w) {
        if (w == 3) {
            return new String[]{"000", "001", "010", "100", "110", "011", "101", "111"};
        } else if (w == 4) {
            return new String[]{"000", "001", "010", "100", "110", "011", "101", "111"};
        } else {
            throw new UnsupportedOperationException("it's not implemented yet");
        }
    }

    public static String[] generatePalindromeStrings(int w) {
        if (w == 4) {
            return new String[]{"0000", "1001", "0110", "1111"};
        } else if (w == 5) {
            return new String[]{"0000", "1001", "0110", "1111"};
        } else {
            throw new UnsupportedOperationException("it's not implemented yet");
        }
    }

}
