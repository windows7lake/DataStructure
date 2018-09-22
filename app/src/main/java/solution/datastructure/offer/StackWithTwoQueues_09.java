package solution.datastructure.offer;

import java.util.LinkedList;

public class StackWithTwoQueues_09 {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}

class Stack<E> {

    private LinkedList<E> queue1;
    private LinkedList<E> queue2;

    public Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(E e) {
        if (!queue1.isEmpty()) {
            queue1.add(e);
        } else if (!queue2.isEmpty()) {
            queue2.add(e);
        } else {
            queue1.add(e);
        }
    }

    public E pop() {
        if (queue1.isEmpty() && queue2.isEmpty())
            throw new RuntimeException("The stack is empty!");

        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }

        if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }

        return null;
    }
}