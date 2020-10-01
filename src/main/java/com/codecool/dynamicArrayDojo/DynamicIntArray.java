package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {
    int size;
    Object[] data;

    public DynamicIntArray(int size) {
        this.size = size;
        this.data = new Object[size];
    }

    public DynamicIntArray() {
        this.size = 0;
        this.data = new Object[1];
    }

    public void add(int i) {
        resizeIfFull();
        data[size]=i;
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i=index;i<size-1;i++){
            data[i] = data[i+1];
            data[i+1] = null;
        }
        size--;
    }

    public void insert(int index, int value) {
        resizeIfFull();
        if (index > size) {
            data[size] = value;
        } else {
            if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
            data[index] = value;
        }
        size++;
    }

    private void resizeIfFull(){
        if (data.length > size) {
            return;
        }
        Object[] resized = new Object[size * 2];
        System.arraycopy(data, 0, resized, 0, data.length);
        data = resized;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(data).forEach(e -> {if (e != null){ sb.append(" "); sb.append(e); }});
        return sb.toString();
    }
}
