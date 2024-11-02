package telran.interview;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackInt {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> maxStack = new LinkedList<>();
    
    public void push(int num) {
        stack.add(num);
        if((maxStack.isEmpty()) || (num >= maxStack.getLast())){
            maxStack.addLast(num);
        }
    }

    public int pop() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int res = stack.removeLast();
        if(res == maxStack.getLast()){
            maxStack.removeLast();
        }
        return res;
    }

    public int peek() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int res = stack.removeFirst();
        if(res == maxStack.getLast()){
            maxStack.removeLast();
        }
        return res;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMaxElement() {
        if(maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return (int) maxStack.getLast();
    }
}