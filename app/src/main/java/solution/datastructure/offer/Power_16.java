package solution.datastructure.offer;

public class Power_16 {

    // 方法一
    private boolean invalidInput = false;

    public double powerNormal(double base, int exponentiation) {
        if (equal(base, 0.0) && exponentiation <= 0) {
            invalidInput = true;
            return 0.0;
        }

        int absExp = exponentiation;
        if (exponentiation < 0) absExp = -exponentiation;

        double result = powerWithExp(base, absExp);
        if (exponentiation < 0) result = 1.0 / result;

        return result;
    }

    public double powerWithExp(double base, int exponentiation) {
        double result = 1.0;
        for (int i = 1; i <= exponentiation; i++) {
            result *= base;
        }
        return result;
    }

    public boolean equal(double num1, double num2) {
        double tmp = num1 - num2;
        if (tmp > -0.0000001 && tmp < 0.0000001) return true;
        else return false;
    }


    // 方法二
    public double powerUnsigned(double base, int exp) {
        double result;
        if (exp < 0) {
            exp = Math.abs(exp);
            result = powerWithExpUnsigned(base, exp);
            result = 1.0 / result;
        } else {
            result = powerWithExpUnsigned(base, exp);
        }
        return result;
    }

    public double powerWithExpUnsigned(double base, int exp) {
        if (exp == 0) return 1.0;
        if (exp == 1) return base;

        double result = powerWithExpUnsigned(base, exp >> 1);
        System.out.println("result:" + result);
        result *= result;
        if ((exp & 1) == 1) {
            result *= base;
            System.out.println("exp: " + exp + " == base: " + base + " == result: " + result);
        }

        return result;
    }

    public static void main(String[] args) {
        Power_16 test = new Power_16();
//        double result = test.powerNormal(4.0, -4);
        double result1 = test.powerUnsigned(4.0, 8);
//        System.out.println("是否是非法输入：" + test.invalidInput);
//        System.out.println("结果是：" + result);
        System.out.println("结果是：" + result1);
    }
}
