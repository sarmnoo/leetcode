package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);

    }


}
