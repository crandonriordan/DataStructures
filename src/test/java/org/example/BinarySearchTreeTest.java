package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {

    @Test
    public void testAdd() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        bst.add(7);
        bst.add(6);
        bst.add(4);
        bst.add(3);
        assertEquals(Integer.valueOf(7), Integer.valueOf(bst.find(7)));
        assertEquals(Integer.valueOf(3), Integer.valueOf(bst.find(3)));
        assertEquals(Integer.valueOf(6), Integer.valueOf(bst.find(6)));
    }

}
