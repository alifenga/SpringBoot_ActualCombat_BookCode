package xyz.alifenga.page49;

import java.util.regex.Pattern;

public class Test {

    public static boolean checkEnglish01(String string) {
        Pattern p = Pattern.compile("[a-zA-z]");
        if (p.matcher(string).find()) {
            return true;
        }
        return false;
    }

    public static boolean checkEnglish02(String string) {
        if (string.matches(".*[a-zA-z].*")) {
            return true;
        }
        return false;
    }

    public static boolean checkEnglish03(String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ((c > 'a' && c < 'z') || (c > ('A') && c < 'Z')) {
                return true;
            }
        }
        return false;
    }


    public static boolean checkEnglish04(String string) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] chars1 = string.toCharArray();
        for (char c : chars1) {
            for (char c1 : chars) {
                if (c == c1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkEnglish01("我"));
        System.out.println(checkEnglish02("我"));
        System.out.println(checkEnglish03("我"));
        System.out.println(checkEnglish04("我"));
    }
}
