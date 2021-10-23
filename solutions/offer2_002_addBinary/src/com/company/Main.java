package com.company;

public class Main {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int maxLen = a.length() > b.length()? a.length():b.length();
        int aTempLen = maxLen - a.length();
        int bTempLen = maxLen - b.length();
        while (aTempLen > 0) {
            a = "0" + a;
            aTempLen --;
        }
        while (bTempLen > 0) {
            b = "0" + b;
            bTempLen --;
        }
        int mode = 0;

        for (int i = maxLen - 1; i >= 0; i--) {
            int sum = 0;
            int aInt = Integer.parseInt(String.valueOf(a.charAt(i)));
            int bInt = Integer.parseInt(String.valueOf(b.charAt(i)));
            sum = aInt + bInt + mode;
            mode = sum / 2;
            sum = sum % 2;
            stringBuilder.append(sum);
        }
        if (mode == 1) {
            stringBuilder.append(mode);
        }
        String ret = stringBuilder.reverse().toString();
        return ret;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String ret = main.addBinary("1010","1011");
        System.out.println(ret);
    }
}
