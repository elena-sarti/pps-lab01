package tdd;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack implements MinMaxStack{
    public static ArrayList<Integer> stack = new ArrayList<Integer>();
    private static boolean isStackEmpty = true;

    @Override
    public void push(int value) {
        if (isStackEmpty) { isStackEmpty = false; }
        stack.add(value);
    }

    @Override
    public int pop() {
        if (stack.isEmpty()){ throw new IllegalStateException("Stack currently empty"); }
        int poppedValue = stack.remove(stack.size()-1);
        if (stack.isEmpty()) { isStackEmpty = true; }
        return poppedValue;
    }

    @Override
    public int peek() {
        if (stack.isEmpty()){ throw new IllegalStateException("Stack currently empty"); }
        return stack.get(stack.size()-1);
    }

    @Override
    public int getMin() {
        return stack.stream().
                mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalStateException("Stack vuoto"));
    }

    @Override
    public int getMax() {
        return stack.stream().
                mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalStateException("Stack vuoto"));
    }

    @Override
    public boolean isEmpty() {
        return isStackEmpty;
    }

    @Override
    public int size() {
        return stack.size();
    }
}
