package com.company;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.*;

public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public static void main(String[] args) {
                new HashMap<>();
                new ConcurrentHashMap<>();
                new Hashtable<>();
                new LinkedList<>();
                new LinkedHashMap<>();

        }
}
