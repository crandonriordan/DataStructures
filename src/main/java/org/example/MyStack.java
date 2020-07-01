package org.example;

public class MyStack<T> {

    private MySinglyLinkedList<T> list;

    MyStack() {
        list = new MySinglyLinkedList<>();
    }

    public void push(T t) {
        list.add(t);
    }

    public T peek() {
        return list.getTail();
    }

    public void pop() {
        list.removeTail();
    }
}
