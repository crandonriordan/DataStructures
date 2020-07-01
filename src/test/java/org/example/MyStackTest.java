package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest {

    private String MUNFORDVILLE = "Munfordville";
    private String ELIZABETHTOWN = "Elizabethtown";
    private String ST_PAUL = "St. Paul";

    @Test
    public void testPushAndPeek() {
        MyStack<String> stack = new MyStack<>();
        stack.push(MUNFORDVILLE);
        assertEquals(MUNFORDVILLE, stack.peek());
        stack.push(ELIZABETHTOWN);
        stack.push(ST_PAUL);
        assertEquals(ST_PAUL, stack.peek());
    }

    @Test
    public void testPop() {
        MyStack<String> stack = new MyStack<>();
        stack.push(MUNFORDVILLE);
        assertEquals(MUNFORDVILLE, stack.peek());
        stack.push(ELIZABETHTOWN);
        stack.push(ST_PAUL);
        stack.pop();
        assertEquals(ELIZABETHTOWN, stack.peek());
    }
}
