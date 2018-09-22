package solution.datastructure.offer;

public class NumberOf1InBinary_15 {

    public static int numberOf1Error(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) count++;
            n = n >> 1;
        }
        return count;
    }

    public static int numberOf1Normal(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) count++;
            flag = flag << 1;
        }
        return count;
    }

    private static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println("numberOf1Error : " + numberOf1Error(0x80000000));
//        System.out.println("numberOf1Normal : " + numberOf1Normal(0x80000000));
        System.out.println("numberOf1 : " + numberOf1(0x80000000));
    }
}
