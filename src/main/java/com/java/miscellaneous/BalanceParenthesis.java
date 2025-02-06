package com.java.miscellaneous;

import java.util.Stack;

/* Program to find the balance parenthesis in the given string */

public class BalanceParenthesis {

    public boolean isBalanceParenthesis(String str) {

        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                characters.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (characters.isEmpty()) {
                    return false;
                }
                char top = characters.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }
}
