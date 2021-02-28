package lessons.stacksandqueues;

import java.util.Stack;

/**
 * Fish
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 * Difficulty : Easy
 * Related Topics : Stacks and Queues
 *
 * created by cenkc on 4/6/2020
 */
public class Fish {
    private static final int DOWNSTREAM = 1;
    private static final int UPSTREAM = 0;

    public static void main(String[] args) {
        int[] A = new int[] {4 ,3 ,2, 1, 5};
        int[] B = new int[] {0, 1, 0, 0, 0};

        Fish fish = new Fish();
        System.out.println(fish.solution(A, B));
    }

    public int solution(int[] A, int[] B) {

        Stack<Integer> stack = new Stack<>();
        int numAlive = A.length;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == DOWNSTREAM) {
                stack.push(A[i]);
            }
            if (B[i] == UPSTREAM) {
                while (!stack.isEmpty()) {
                    if (stack.peek() > A[i]) {
                        numAlive--;
                        break;
                    } else if (stack.peek() < A[i]) {
                        numAlive--;
                        stack.pop();
                    }
                }
            }
        }
        return numAlive;
    }
}
