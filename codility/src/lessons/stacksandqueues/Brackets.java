package lessons.stacksandqueues;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Brackets
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * Difficulty : Easy
 * Related Topics : Stacks and Queues
 *
 * created by cenkc on 4/5/2020
 */
public class Brackets {

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        assertEquals(1, brackets.solution("{[()()]}"));
        assertEquals(1, brackets.solution("{}"));
        assertEquals(1, brackets.solution("{[]}"));
        assertEquals(0, brackets.solution("{[}"));
        assertEquals(0, brackets.solution("{{"));
        assertEquals(1, brackets.solution("{{}}"));
        assertEquals(1, brackets.solution("{{}()[()]}"));
    }

    public int solution(String S) {
        Stack stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (isOpeningChar(currentChar)) {
                stack.push(currentChar);
            } else {
                if (stack.size() == 0) {
                    return 0; // first char is closingChar and it's not good
                }
                if (isPaired((char) stack.peek(), currentChar)) {
                    stack.pop();
                    continue;
                } else {
                    return 0;
                }
            }
        }
        if (stack.empty()) {
            return 1;
        }
        return 0;
    }

    private boolean isPaired(char c1, char c2) {
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '[' && c2 == ']') return true;
        if (c1 == '{' && c2 == '}') return true;
        return false;
    }

    public boolean isOpeningChar(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}
