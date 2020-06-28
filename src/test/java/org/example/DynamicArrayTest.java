package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DynamicArrayTest {

    DynamicArray<Integer> dynamicArray;

    @Before
    public void setup() {
        dynamicArray = new DynamicArray<>();
    }

    @Test
    public void testAdd() {
        dynamicArray.add(5);
        dynamicArray.add(7);

        assertEquals(dynamicArray.size(), 2);
        assertEquals((int) dynamicArray.get(1), (int) 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsIllegalArgumentException() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.get(3);
    }

    @Test
    public void testGetSize() {
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        assertEquals(dynamicArray.size(), 3);
    }

    @Test
    public void testIndexOf() {
        int[] arr = new int[]{ 5, 7, 8, -16, 32, 21, 33 };
        for(int i : arr) {
            dynamicArray.add(i);
        }

        assertEquals(dynamicArray.indexOf(arr[5]), 5);
    }

    @Test
    public void testRemoveByIndex() {
        int[] arr = new int[]{ 5, 7, 8, -16, 32, 21, 33 };
        for(int i : arr) {
            dynamicArray.add(i);
        }
        int originalSize = dynamicArray.size();
        dynamicArray.remove(0);
        assertEquals(dynamicArray.size(), originalSize - 1);
        assertEquals(dynamicArray.indexOf(Integer.valueOf(5)), -1);
    }

    @Test
    public void testRemoveByObject() {
        int[] arr = new int[]{ 5, 7, 8, -16, 32, 21, 33, -16 };
        for(int i : arr) {
            dynamicArray.add(i);
        }
        int originalSize = dynamicArray.size();
        dynamicArray.remove(Integer.valueOf(-16));
        assertEquals(dynamicArray.size(), originalSize - 1);
        assertEquals(dynamicArray.indexOf(-16), -1);
    }
}
