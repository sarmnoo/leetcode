package com.company;

public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
        System.out.println("father:"+key);
    }

    public void show(T generic) {
        System.out.println(generic);
    }

    public void showAll(Generic<?> generic) {
        System.out.println(generic.getKey());
    }

    public static void main(String[] args) {
//        Generic<Integer> qqq = new Generic<>(3);
//        qqq.show(1);
//        qqq.showAll(new Generic<>(2));
//        qqq.showAll(new Generic<String>("22"));

        MyGeneric integerMyGeneric = new MyGeneric(2);
        Generic generic = integerMyGeneric;
        generic.setKey("222");
//        Integer x = integerMyGeneric.getKey();


    }
}
