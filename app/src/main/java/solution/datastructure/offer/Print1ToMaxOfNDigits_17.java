package solution.datastructure.offer;

public class Print1ToMaxOfNDigits_17 {

    /**
     * 方法一
     */
    private static void printMaxDigital(int n) {
        if (n <= 0) return;
        // 使用数组来模拟大数
        int[] number = new int[n];
        while (!increment(number)) {
            print(number);
        }
    }

    // 使用数组实现对数进行+1操作
    private static boolean increment(int[] number) {
        boolean isOverFlow = false;  // 最高位产生进位标志
        int carry = 0;  // 进位位

        for (int i = number.length - 1; i >= 0; i--) {
            int sum = number[i] + carry;
            if (i == number.length - 1) sum++;
            if (sum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    sum -= 10;
                    carry = 1;
                    number[i] = sum;
                }
            } else {
                number[i]++;
                break;
            }
        }
        return isOverFlow;
    }

    // 打印数组中表示的数，如果数组中表示的数字位数小于n，则不打印前面的0
    private static void print(int[] number) {
        // 标记：判断是否可以开始打印
        boolean isBeginning = false;
        for (int i = 0; i < number.length; i++) {
            if (!isBeginning && number[i] != 0) isBeginning = true;
            if (isBeginning) System.out.print(number[i]);
        }
        System.out.println();
    }

    /**
     * 方法二
     */
    /**
     * 方法一
     */
    private static void printMaxDigital2(int n) {
        if (n <= 0) return;
        StringBuffer sb = new StringBuffer(n);
        for (int i = 0; i < n; i++)
            sb.append('0');
        printMaxDigitalRecursion(sb, n, 0);
    }

    private static void printMaxDigitalRecursion(StringBuffer sb, int n, int index) {
        if (index == n) {
            printRecursion(sb);
            return;
        }
        for (int i = 0; i < 10; i++) {
            sb.setCharAt(index, (char) (i + '0'));
            printMaxDigitalRecursion(sb, n, index + 1);
        }
    }

    private static void printRecursion(StringBuffer sb) {
        boolean flag = false;
        for (int i = 0; i < sb.length(); i++) {
            if (!flag && sb.charAt(i) != '0') flag = true;
            if (flag) System.out.print(sb.charAt(i));
        }
        if (flag) System.out.println();
    }


    public static void main(String[] args) {
        printMaxDigital2(2);
    }

}
