package org.example;

public class MySinglyLinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T> {
        T t;
        Node<T> next;

        Node(T t) {
            super();
            this.t = t;
        }
    }

    public T get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> copy = head;

        for(int i = 0; i < index; i++) {
            copy = copy.next;
        }

        return copy.t;
    }

    public void remove(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        Node<T> prev = null;
        Node<T> copy = head;
        if(index == 0) {
            copy = copy.next;
            head = copy;
            size--;
            return;
        }

        while(count < index) {
            prev = copy;
            copy = copy.next;
            count++;
        }

        if(prev == null) {
            return;
        }

        prev.next = copy.next;
        size--;
    }

    public void add(T t) {
        if(head == null) {
            head = new Node<T>(t);
            tail = head;
        } else {
            tail.next = new Node<T>(t);
            tail = tail.next;
        }

        size++;
    }

    public void recursiveAdd(T t) {
        // base case
        // i'm at the tail
        if(head == null) {
            head = new Node<T>(t);
            tail = head;
            size++;
            return;
        }

        recursiveAdd(head, t);
    }

    private void recursiveAdd(Node<T> node, T t) {
        if(node == tail) {
            tail.next = new Node<T>(t);
            tail = tail.next;
            size++;
            return;
        }
        recursiveAdd(node.next, t);
    }

    public T removeTail() {
        if(size == 0) {
            return null;
        }


        Node<T> copy = head;
        while(head != tail) {
            copy = head;
            head = head.next;
        }

        T ret = tail.t;
        copy.next = null;

        return ret;
    }

    public T getTail() {
        if(tail == null) {
            return null;
        }
        return tail.t;
    }

    public int getSize() {
        return size;
    }
}


