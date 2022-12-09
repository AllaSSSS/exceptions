import java.util.Arrays;

public class ArrayDivision {


    public static void main(String[] args) {
        try {
            div(new int[]{1, 2, 3}, new int[]{5, 6});
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        try {
            div(new int[]{1, 2, 3}, new int[]{1, 1, 0});
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        System.out.println(Arrays.toString(div(new int[]{2, 6, 10}, new int[]{2, 3, 5})));
    }


    static int[] div(int[] dividend, int[] divisor) {
        try {
            if (dividend.length != divisor.length) {
                throw new IllegalArgumentException("Should be the same length");
            }
            int[] result = new int[dividend.length];
            for (int i=0; i < result.length; i++) {
                result[i] = dividend[i] / divisor[i];
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
