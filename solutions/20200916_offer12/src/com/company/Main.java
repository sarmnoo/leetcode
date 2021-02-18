package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }

        int startI = -1, startJ = -1;
        List<Integer> startIArray = new ArrayList<Integer>();
        List<Integer> startJArray = new ArrayList<>();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    startIArray.add(i);
                    startJArray.add(j);
                }
            }
        }
        if (startIArray.size() == 0) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < startIArray.size(); i++) {
            int[][] flag = new int[board.length][board[0].length];
            if (search(startIArray.get(i), startJArray.get(i), board, flag, word, index)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(int startI, int startJ, char[][]board, int[][] flag, String word, int index) {
        if (startI < 0 || startI > board.length - 1 || startJ < 0 || startJ > board[0].length - 1 || board[startI][startJ] != word.charAt(index) || flag[startI][startJ] == 1) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        } else {
            flag[startI][startJ] = 1;
            boolean res = search(startI + 1, startJ, board, flag, word, index + 1) ||
                    search(startI - 1, startJ, board, flag, word, index + 1) ||
                    search(startI, startJ + 1, board, flag, word, index + 1) ||
                    search(startI, startJ - 1, board, flag, word, index + 1);
            flag[startI][startJ] = 0;
            return res;

        }

    }

    public static void main(String[] args) {
	    char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
	    String word = "ABCESEEEFS";
	    Main solution = new Main();
	    System.out.println(solution.exist(board, word));
    }
}
