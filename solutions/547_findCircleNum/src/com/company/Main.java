package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] isConnected = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        int circleNum = main.findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    /**
     * 并查集解决
     * 同一个parent的元素为一组
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        //初始化parent,开始每个元素的父节点是自己
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < isConnected.length; i ++) {
            for (int j = i + 1; j < isConnected.length; j ++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int circleNums = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                circleNums ++;
            }
        }
        return circleNums;

    }

    /**
     * 将元素index1,index2进行合并
     * 分别找到index1的父节点和index2的父节点，进行合并
     * 将index1合并到index2下
     */
    public void union(int[] parent, int index1, int index2) {
        parent[findParent(parent, index1)] = findParent(parent, index2);
    }

    /**
     * 递归查找元素父节点
     * @param parent
     * @param index
     * @return
     */
    public int findParent(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = findParent(parent, parent[index]);
        }
        return parent[index];
    }
}
