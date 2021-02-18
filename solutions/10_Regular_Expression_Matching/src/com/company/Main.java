package com.company;

public class Main {

    public boolean isMatch(String s, String p) {
        boolean match[][] = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int k = 1; k <= p.length(); k ++) {
            if (p.charAt(k - 1) == '*') {
                match[0][k] = match[0][k - 2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) != '*' && p.charAt(j-1) != '.') {
                    //p[j] is a character
                    if (s.charAt(i-1) == p.charAt(j-1)) {
                        match[i][j] = match[i-1][j-1];
                    } else {
                        match[i][j] = false;
                    }
                } else if (p.charAt(j-1) == '*') {
                    //p[j] is *
                    if (s.charAt(i-1) == p.charAt(j - 2) || p.charAt(j-2) == '.') {
                        match[i][j] = match[i][j-2] || match[i-1][j];
                    } else {
                        match[i][j] = match[i][j-2];
                    }
                } else {
                    //p[j] is .
                    match[i][j] = match[i-1][j-1];
                }
            }
        }

        return match[s.length()][p.length()];
    }



    public static void main(String[] args) {
        Main solution = new Main();
        boolean isMatch = solution.isMatch("ab", ".*");
        System.out.println(isMatch);
    }
}
