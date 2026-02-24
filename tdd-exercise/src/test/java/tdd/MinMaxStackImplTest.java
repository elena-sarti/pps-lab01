package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    public static final int VALUE_TO_PUSH = 1;
    public static final int[] LIST_OF_NUMBERS = new int[]{1,2,3,4};
    public static final int MIN_VALUE_OF_LIST = Arrays.stream(LIST_OF_NUMBERS).min().getAsInt();
    public static final int MAX_VALUE_OF_LIST = Arrays.stream(LIST_OF_NUMBERS).max().getAsInt();
    Stack stack;

    @BeforeEach
    public void beforeEach(){
        stack = new Stack();
    }

    @Test
    public void isStackInitiallyEmpty(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isPushPossible(){
        stack.push(VALUE_TO_PUSH);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void isPopPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,()->stack.pop());
    }

    @Test
    public void isPopPossible(){
        stack.push(VALUE_TO_PUSH);
        assertEquals(VALUE_TO_PUSH, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isPeekPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,()->stack.peek());
    }

    @Test
    public void isPeekPossible(){
        stack.push(VALUE_TO_PUSH);
        assertEquals(VALUE_TO_PUSH, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void isGetMaxPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,()->stack.getMax());
    }

    @Test
    public void isGetMaxPossible(){
        for(int pushedNumeber = MIN_VALUE_OF_LIST; pushedNumeber <= MAX_VALUE_OF_LIST; pushedNumeber++) { stack.push(pushedNumeber); }
        assertEquals(stack.getMax(), Arrays.stream(LIST_OF_NUMBERS).max().getAsInt());
    }

    @Test
    public void isGetMinPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,() -> stack.getMin());
    }

    @Test
    public void isGetMinPossible(){
        for(int pushedNumeber = MIN_VALUE_OF_LIST; pushedNumeber <= MAX_VALUE_OF_LIST; pushedNumeber++) { stack.push(pushedNumeber); }
        assertEquals(stack.getMin(), Arrays.stream(LIST_OF_NUMBERS).min().getAsInt());
    }
}