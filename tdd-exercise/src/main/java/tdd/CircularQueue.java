package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Stores an integer in the queue.
     *
     * @param storedValue The integer to store.
     */
    void store(int storedValue);

    /**
     * Removes and retrieves the element that occupies the first position in the queue.
     *
     * @return the element removed from the queue.
     * @throws IllegalStateException if the stack is empty.
     */
    int remove() throws IllegalStateException;

    /**
     * Gets the minimum value currently in the queue.
     *
     * @return The minimum value in the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int getMin() throws IllegalStateException;

    /**
     * Gets the maximum value currently in the queue.
     *
     * @return The maximum value in the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int getMax() throws IllegalStateException;

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the number of elements currently in the queue.
     *
     * @return The size of the stack.
     */
    int size();
}