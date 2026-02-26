package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    public static final int VALUE_TO_STORE = 1;
    public static final int QUEUE_EXPECTED_MINIMUM = 1;
    public static final int QUEUE_EXPECTED_MAXIMUM = Queue.QUEUE_CAPACITY;
    Queue queue;

    @BeforeEach
    public void beforeEach(){
        queue = new Queue();
    }

    @Test
    public void isQueueInitiallyEmpty(){
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isStoringPossible(){
        int elementsStored = 1;
        queue.store(VALUE_TO_STORE);
        assertFalse(queue.isEmpty());
        assertEquals(elementsStored, queue.size());
    }

    @Test
    public void isRemovingPossible(){
        int elementsRemoved = 1;
        storeProgressiveNumbers(0, Queue.QUEUE_CAPACITY - 1);
        removeElements(elementsRemoved);
        assertEquals(Queue.QUEUE_CAPACITY - elementsRemoved, queue.size());
    }

    @Test
    public void isRemovingPossibleEmptyQueue(){
        assertThrows(IllegalStateException.class, () -> queue.remove());
    }

    @Test
    public void isStoringPossibleExceedingCapacity(){
        storeProgressiveNumbers(QUEUE_EXPECTED_MINIMUM,QUEUE_EXPECTED_MAXIMUM+1);
        assertEquals(QUEUE_EXPECTED_MINIMUM + 1, queue.remove());
    }

    @Test
    public void isGetMaxPossible(){
        storeProgressiveNumbers(QUEUE_EXPECTED_MINIMUM,QUEUE_EXPECTED_MAXIMUM);
        assertEquals(QUEUE_EXPECTED_MAXIMUM, queue.getMax());
    }

    @Test
    public void isGetMaxPossibleEmptyQueue(){
        assertThrows(IllegalStateException.class, () -> queue.getMin());
    }

    @Test
    public void isGetMinPossible(){
        storeProgressiveNumbers(QUEUE_EXPECTED_MINIMUM,QUEUE_EXPECTED_MAXIMUM);
        assertEquals(QUEUE_EXPECTED_MINIMUM, queue.getMin());
    }

    @Test
    public void isGetMinPossibleEmptyQueue(){
        assertThrows(IllegalStateException.class, () -> queue.getMin());
    }

    public void storeProgressiveNumbers(int firstNumber, int lastNumber){
        for(int naturalNumber = firstNumber; naturalNumber <= lastNumber; naturalNumber++) { queue.store(naturalNumber); }
    }

    public void removeElements(int elementsToRemove){
        for (int i = 0; i < elementsToRemove; i++){ queue.remove(); }
    }
}
