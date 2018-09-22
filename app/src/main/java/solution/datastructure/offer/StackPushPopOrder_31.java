package solution.datastructure.offer;

import java.util.Stack;

public class StackPushPopOrder_31 {

    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || pop.length == 0)
            return false;
        if (push.length != pop.length)
            return false;

        Stack<Integer> stack = new Stack<>();

        int pPush = 0;
        int pPop = 0;
        while (pPush < push.length) {
            stack.push(push[pPush]);
            while (!stack.empty() && stack.peek() == pop[pPop]) {
                stack.pop();
                pPop++;
            }
            pPush++;
        }

        if (stack.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] pushB = null;
        int[] pushC = {};
        int[] popA = {4, 3, 5, 1, 2};
        int[] popB = {4, 5, 3, 2, 1};
        int[] popC = null;
        int[] popD = {};
        System.out.println(isPopOrder(pushC, popC));
    }
}
