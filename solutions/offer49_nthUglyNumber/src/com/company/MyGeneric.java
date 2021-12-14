package com.company;

public class MyGeneric extends Generic<Integer> {
    public MyGeneric(Integer key) {
        super(key);
    }

    @Override
    public void setKey(Integer key) {
        super.setKey(key);
    }
}
