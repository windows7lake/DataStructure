package solution.datastructure.offer;

public class ReplaceSpaces_05 {

    public static String replaceSpacesWithStringBuilder(String inputStr) {
        if (inputStr == null || inputStr.length() == 0) return null;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == ' ') stringBuilder.append("%20");
            else stringBuilder.append(inputStr.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String replaceSpaces(String inputStr) {
        if (inputStr == null || inputStr.length() == 0) return null;

        char[] chars = inputStr.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++)
            if (chars[i] == ' ') count++;
        int newLength = chars.length + count * 2;
        char[] newChars = new char[newLength];
        for (int i = 0; i < chars.length; i++)
            newChars[i] = chars[i];
        for (int i = chars.length - 1, j = newLength - 1; i >= 0 && j >= i; i--)
            if (newChars[i] == ' ') {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
            } else {
                newChars[j--] = chars[i];
            }
        return new String(newChars);
    }

    public static void main(String[] args) {
        String str1 = "We are happy.";
        String str2 = " Wearehappy.";
        String str3 = "Wearehappy. ";
        String str4 = "We   are   happy  .";
        String str5 = "Wearehappy.";
        String str6 = "    ";
        String str7 = " ";
        String str8 = null;
        String str9 = "";
        String[] strings = {str1, str2, str3, str4, str5, str6, str7, str8, str9};
        for (String str : strings) {
            System.out.println(replaceSpacesWithStringBuilder(str));
            System.out.println(replaceSpaces(str));
        }
    }
}
