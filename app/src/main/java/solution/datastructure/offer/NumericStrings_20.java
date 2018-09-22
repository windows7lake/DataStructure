package solution.datastructure.offer;

public class NumericStrings_20 {

    int index;

    public boolean isNumber(String number) {
        if (number == null || number.isEmpty()) return false;

        char[] str = number.toCharArray();
        index = 0;

        // 判断整数部分
        boolean flag = scanInteger(str);
        // 判断小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        // 判断指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            flag = scanInteger(str) && flag;
        }
        return index >= str.length && flag;
    }

    // 扫描整数部分
    public boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);
    }

    // 扫描无符号整数部分
    public boolean scanUnsignedInteger(char[] str) {
        int tmp = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > tmp;
    }

    public boolean isNumeric(String str) {
        return str.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    public static void main(String[] args) {
        NumericStrings_20 numeric = new NumericStrings_20();
        String str = "-1E-16.";
        String str2 = "12e+5.4";
        String str3 = "1a3.14";
        boolean result = numeric.isNumber(str);
        System.out.println(result);
    }
}
