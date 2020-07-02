package org.example;

public class BinarySearchTree<T extends Comparable> {

    private Node<T> head;

    static class Node<T extends Comparable> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node<T> copy = head;
        add(data, copy);
    }

    private void add(T data, Node<T> node) {
        if(data.compareTo(node.data) < 1) {
            if(node.left == null) {
                node.left = new Node(data);
                return;
            } else {
                add(data, node.left);
            }
        } else if (data.compareTo(node.data) >= 1) {
            if(node.right == null) {
                node.right = new Node(data);
                return;
            } else {
                add(data, node.right);
            }

        }
    }

    public T find(T data) {
        Node<T> copy = head;

        T ret = find(data, copy);
        return ret;
    }

    private T find(T data, Node<T> copy) {
        if(data.equals(copy.data)) {
            return data;
        }

        if(data.compareTo(copy.data) < 1 && copy.left != null)  {
            return find(data, copy.left);
        } else if (data.compareTo(copy.data) >= 1 && copy.right != null) {
            return find(data, copy.right);
        }

        return null;
    }


}
