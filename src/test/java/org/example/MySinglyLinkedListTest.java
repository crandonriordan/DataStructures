package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySinglyLinkedListTest {

    @Test
    public void testAdd() {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        assertNull(list.getTail());
        list.add(5);
        list.add(7);
        list.add(9);
        assertEquals(Integer.valueOf(9), list.getTail());
    }

    @Test
    public void testRecursiveAdd() {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        list.recursiveAdd(5);
        list.recursiveAdd(7);
        list.recursiveAdd(9);
        assertEquals(Integer.valueOf(9), list.getTail());
    }

    @Test
    public void testGetAtIndex() {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        list.recursiveAdd(5);
        list.recursiveAdd(7);
        list.recursiveAdd(9);
        assertEquals(Integer.valueOf(9), list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAtIndexThrowsOutOfBounds() {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        list.recursiveAdd(5);
        list.recursiveAdd(7);
        list.recursiveAdd(9);
        assertEquals(Integer.valueOf(9), list.get(3));
    }

    @Test
    public void testRemoveAtIndex() {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        list.recursiveAdd(5);
        list.recursiveAdd(7);
        list.recursiveAdd(9);
        list.recursiveAdd(11);
        list.recursiveAdd(12);
        list.remove(3);
        assertEquals(Integer.valueOf(12), list.get(3));
        assertEquals(4, list.getSize());
    }

    @Test
    public void testRemoveTail() {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        list.recursiveAdd(5);
        list.recursiveAdd(7);
        list.recursiveAdd(9);
        list.recursiveAdd(11);
        list.recursiveAdd(12);
        assertEquals(Integer.valueOf(12), list.removeTail());
    }


}
