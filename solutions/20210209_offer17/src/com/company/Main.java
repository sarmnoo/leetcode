package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public int[] printNumbers(int n) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        for (int j = 2; j <= n; j++) {
            int numSize = numbers.size();
            int current = 0;
            int tenNum = (int) Math.pow(10,(j - 1));
            for (int k = 1; k < 10; k++) {
                int addNum = tenNum * k;
                while(current < numSize) {
                    numbers.add(numbers.get(current) + addNum);
                    current ++;
                }
                current = 0;
            }
        }

        int[] ret = new int[numbers.size() - 1];
        for (int i = 1; i < numbers.size(); i++) {
            ret[i-1] = numbers.get(i);
        }
        return ret;

    }


    public static void main(String[] args) {
        Main solution = new Main();
        int[] ret = solution.printNumbers(4);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] +" ");
            if (ret[i] % 10 == 0) {
                System.out.println();
            }
        }
    }
}
