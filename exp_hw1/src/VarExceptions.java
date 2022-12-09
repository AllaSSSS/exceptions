public class VarExceptions {
    public static void main(String[] args) {
        try {
            npe(null);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
//        try {
//            npe("xxx");
//        } catch (StringIndexOutOfBoundsException e) {
//            System.out.println(e);
//        }
        try {
            divByZero(0);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        try {
            outOfBound(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }


    static void npe(String s) {
        System.out.println(s.length());
//        System.out.println(s.charAt(10));
    }


    static void divByZero(int divisor) {
        System.out.println(10 / divisor);
    }


    static void outOfBound(int index) {
        int[] arr = {};
        System.out.println(arr[index]);
    }
}