package tdd;

import java.util.LinkedList;

public class Queue implements CircularQueue{
    public static final int QUEUE_CAPACITY = 5;
    private static final java.util.Queue<Integer> queue = new LinkedList<>();
    private static int queueAlreadyFull = 0;
    private static boolean isQueueEmpty = true;

    @Override
    public void store(int storedValue){
        if (queueAlreadyFull==QUEUE_CAPACITY){ queue.remove(); }
        queue.add(storedValue);
        queueAlreadyFull += 1;
        if (queueAlreadyFull == 1) { isQueueEmpty = false; }
    }

    @Override
    public int remove(){
        if (queue.isEmpty()) {throw new IllegalStateException("Queue currently empty.");}
        queueAlreadyFull -= 1;
        if (queueAlreadyFull == 0) { isQueueEmpty = true; }
        return queue.remove();
    }


    @Override
    public boolean isEmpty(){
        return isQueueEmpty;
    }

    @Override
    public int size(){
        return queue.size();
    }

    @Override
    public int getMax() {
        if(isQueueEmpty) { throw new IllegalStateException("Queue currently empty."); }
        return queue.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    @Override
    public int getMin() {
        if(isQueueEmpty) { throw new IllegalStateException("Queue currently empty."); }
        return queue.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
}
