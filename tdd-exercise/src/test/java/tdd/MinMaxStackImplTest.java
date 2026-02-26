package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    public static final int VALUE_TO_PUSH = 1;
    public static final int[] TEST_STACK = new int[]{1,2,3,4};
    public static final int MIN_VALUE_OF_STACK = Arrays.stream(TEST_STACK).min().getAsInt();
    public static final int MAX_VALUE_OF_STACK = Arrays.stream(TEST_STACK).max().getAsInt();
    Stack stack;

    @BeforeEach
    public void beforeEach(){
        stack = new Stack();
    }

    @Test
    public void testStackInitiallyEmpty(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush(){
        stack.push(VALUE_TO_PUSH);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopStackEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void testPop(){
        stack.push(VALUE_TO_PUSH);
        assertEquals(VALUE_TO_PUSH, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeekStackEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    public void testPeek(){
        stack.push(VALUE_TO_PUSH);
        assertEquals(VALUE_TO_PUSH, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testGetMaxStackEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.getMax());
    }

    @Test
    public void testGetMax(){
        pushProgressiveNumbers();
        assertEquals(stack.getMax(), Arrays.stream(TEST_STACK).max().getAsInt());
    }

    @Test
    public void testGetMinStackEmpty(){
        assertThrows(IllegalStateException.class, () -> stack.getMin());
    }

    @Test
    public void testGetMin(){
        pushProgressiveNumbers();
        assertEquals(stack.getMin(), Arrays.stream(TEST_STACK).min().getAsInt());
    }

    public void pushProgressiveNumbers(){
        for(int pushedNumber = MIN_VALUE_OF_STACK; pushedNumber <= MAX_VALUE_OF_STACK; pushedNumber++) { stack.push(pushedNumber); }
    }
}