package com.company;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.print.attribute.standard.Media;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MedianFinder {
    Queue<Integer> a,b;
    /** initialize your data structure here. */
    public MedianFinder() {
        a = new PriorityQueue<Integer>();  //小顶堆，保存较大的一半，数量会比b多一个或者相等
        b = new PriorityQueue<Integer>((x, y) -> (y - x)); //大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (a.size() == b.size()) {
            //向a中添加一个元素：需要先在b中添加元素，经过变换之后，b的堆顶为小于a中元素的最大元素，
            // 将b的堆顶元素添加到a中，保证a中所有元素都比b中元素大。
            b.add(num);
            a.add(b.poll());
        } else {
            //a b长度不一致时，肯定是b的长度小，所以需要向b中添加元素，
            // 同样的，需要先在a中添加该元素，将a中最小的元素即a的堆顶元素添加到b中
            a.add(num);
            b.add(a.poll());
        }
    }

    public double findMedian() {
        if (a.size() == b.size()) {
            return (double)((a.peek() + b.peek()) / 2.0);
        } else {
            return (double)a.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(2);
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(1);
        finder.addNum(6);
        finder.addNum(9);
        System.out.println(finder.findMedian());
        finder.addNum(7);
        System.out.println(finder.findMedian());
        
    }
}

