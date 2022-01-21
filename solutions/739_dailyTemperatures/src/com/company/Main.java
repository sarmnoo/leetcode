package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{30,60,90};
        int[] ints = dailyTemperatures(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public static int[] dailyTemperatures(int[] temperatures) {
        int[] rets = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temp = i + 1;
            while (temp < temperatures.length) {
                if (temperatures[temp] > temperatures[i]) {
                    rets[i] = temp - i;
                    break;
                } else {
                    if (rets[temp] == 0){
                        break;
                    } else {
                        temp += rets[temp];
                    }
                }
            }
        }
        return rets;

    }

}
