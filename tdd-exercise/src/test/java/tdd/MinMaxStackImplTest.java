package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
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
        int pushedValue = 0;
        stack.push(pushedValue);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void isPopPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,()->stack.pop());
    }

    @Test
    public void isPopPossible(){
        int pushedValue = 0;
        stack.push(pushedValue);
        assertEquals(pushedValue, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isPeekPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,()->stack.peek());
    }

    @Test
    public void isPeekPossible(){
        int pushedValue = 32;
        stack.push(pushedValue);
        assertEquals(pushedValue, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void isGetMaxPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,()->stack.getMax());
    }

    @Test
    public void isGetMaxPossible(){
        int[] listOfNumbers = {1,2,3,4};
        for(int pushedNumeber = 1; pushedNumeber < 5; pushedNumeber++) { stack.push(pushedNumeber); }
        assertEquals(stack.getMax(), Arrays.stream(listOfNumbers).max().getAsInt());
    }

    @Test
    public void isGetMinPossibleStackEmpty(){
        assertThrows(IllegalStateException.class,()->stack.getMin());
    }

    @Test
    public void isGetMinPossible(){
        int[] listOfNumbers = {1,2,3,4};
        for(int pushedNumeber = 1; pushedNumeber < 5; pushedNumeber++) { stack.push(pushedNumeber); }
        assertEquals(stack.getMin(), Arrays.stream(listOfNumbers).min().getAsInt());
    }
}