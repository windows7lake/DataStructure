package solution.datastructure.offer;

import java.util.Stack;

public class MinInStack_30 {

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(1);
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        stack.push(1);
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
    }
}

class StackWithMin {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int minValue = 0;

    public StackWithMin() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        dataStack.push(value);
        if (minStack.isEmpty()) {
            minValue = value;
        } else {
            if (minValue > value)
                minValue = value;
        }
        minStack.push(minValue);
    }

    public int pop() {
        int result = -1;
        if (!dataStack.isEmpty() && !minStack.isEmpty()) {
            result = dataStack.pop();
            minStack.pop();
            if (!minStack.isEmpty())
                minValue = minStack.peek();
            else
                minValue = 0;
        }
        if (result == -1) throw new RuntimeException("stack is empty");
        return result;
    }

    // 取栈顶值
    public int top() {
        if (!dataStack.isEmpty()) {
            return dataStack.peek();
        }
        return 0;
    }

    public int min() {
        return minValue;
    }
}