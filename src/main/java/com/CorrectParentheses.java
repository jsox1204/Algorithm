package com;

import java.util.Stack;

public class CorrectParentheses {
    public static void main(String[] args) {

        String parentheses = "((((((())))((())))))";

        System.out.println(solution(parentheses));
    }

    private static boolean solution(String parentheses) {

        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(') {
                integerStack.push(1);
            } else if (parentheses.charAt(i) == ')' && integerStack.empty() ) {
                return false;
            } else if (parentheses.charAt(i) == ')' && !integerStack.empty() ) {
                integerStack.pop();
            }
        }

        return integerStack.empty();
    }
}
