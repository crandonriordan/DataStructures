package org.example;

public class DynamicArray<T> {
    private static final int BUCKET = 2;

    private Object[] arr = new Object[BUCKET];
    private int end = 0;

    public boolean add(T element) {
        if(end == arr.length - 1) {
            increaseSizeAndCopy();
        }
        arr[end] = element;
        end++;

        return true;
    }

    private void increaseSizeAndCopy() {
        int length = arr.length * 2;
        Object[] copy = new Object[length];
        for(int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        arr = copy;
    }

    public int size() {
        return end;
    }

    public T get(int index) {
        rangeCheck(index);
        return (T) arr[index];
    }

    public void remove(int index) {
        rangeCheck(index);
        Object[] copy = new Object[arr.length];
        int indexOfCopy = 0;
        for(int i = 0; i < end; i++, indexOfCopy++) {
            if(i == index) {
                indexOfCopy--;
                continue;
            }
            copy[indexOfCopy] = arr[i];
        }
        end--;
        arr = copy;
    }

    public T remove(T t) {
        Object[] copy = new Object[arr.length];
        T ret = null;
        boolean found = false;
        int indexOfCopy = 0;
        for(int i = 0; i < end; i++, indexOfCopy++) {
            if(arr[i].equals(t) && !found) {
                ret = (T) arr[i];
                found = true;
                indexOfCopy--;
                continue;
            } else {
                copy[indexOfCopy] = arr[i];
            }

        }
        end--;
        arr = copy;
        return ret;
    }

    public int indexOf(T t) {
        for(int i = 0; i < end; i++) {
            if(arr[i].equals(t)) {
                return i;
            }
        }

        return -1;
    }

    private void rangeCheck(int index) {
        if(index < 0 || index > end) {
            throw new IllegalArgumentException("Index must be in the bounds");
        }
    }
}
