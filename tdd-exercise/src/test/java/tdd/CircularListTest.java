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
        for(int queuePosition = 0; queuePosition < Queue.QUEUE_CAPACITY; queuePosition++) {queue.store(VALUE_TO_STORE);}
        for (int i = 0; i < elementsRemoved; i++){ queue.remove(); }
        assertEquals(Queue.QUEUE_CAPACITY - elementsRemoved, queue.size());
    }

    @Test
    public void isRemovingPossibleEmptyQueue(){
        assertThrows(IllegalStateException.class, () -> queue.remove());
    }

    @Test
    public void isStoringPossibleExceedingCapacity(){
        int expectedValue = 0;
        for(int naturalNumber = 0; naturalNumber <= Queue.QUEUE_CAPACITY; naturalNumber++) {
            queue.store(naturalNumber);
            expectedValue = Queue.QUEUE_CAPACITY - naturalNumber + QUEUE_EXPECTED_MINIMUM;
        }
        assertEquals(expectedValue, queue.remove());
    }

    @Test
    public void isGetMaxPossible(){
        for(int naturalNumber = QUEUE_EXPECTED_MINIMUM; naturalNumber <= QUEUE_EXPECTED_MAXIMUM; naturalNumber++) { queue.store(naturalNumber); }
        assertEquals(QUEUE_EXPECTED_MAXIMUM, queue.getMax());
    }

    @Test
    public void isGetMaxPossibleEmptyQueue(){
        assertThrows(IllegalStateException.class,() -> queue.getMin());
    }

    @Test
    public void isGetMinPossible(){
        for(int naturalNumber = QUEUE_EXPECTED_MINIMUM; naturalNumber <= QUEUE_EXPECTED_MAXIMUM; naturalNumber++) { queue.store(naturalNumber); }
        assertEquals(QUEUE_EXPECTED_MINIMUM, queue.getMin());
    }

    @Test
    public void isGetMinPossibleEmptyQueue(){
        assertThrows(IllegalStateException.class,() -> queue.getMin());
    }
}
