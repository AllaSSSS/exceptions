import java.util.Arrays;

public class ArrayDifference {

    public static void main(String[] args) {
        try {
            diff(new int[]{1, 2, 3}, new int[]{5, 6});
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println(Arrays.toString(diff(new int[]{1, 2, 3}, new int[]{5, 6, 7})));
    }


    static int[] diff(int[] minuend, int[] subtrahend) {
        if (minuend.length != subtrahend.length) {
            throw new IllegalArgumentException("Should be the same length");
        }
        int[] result = new int[minuend.length];
        for (int i=0; i < result.length; i++) {
            result[i] = minuend[i] - subtrahend[i];
        }
        return result;
    }
}