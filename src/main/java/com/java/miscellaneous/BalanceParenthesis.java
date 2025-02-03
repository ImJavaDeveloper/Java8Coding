package com.java.miscellaneous;

import java.util.Stack;

public class BalanceParenthesis {

    public boolean isBalanceParenthesis(String str) {

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
            {
                stack.push(ch);
            }
            else if(ch==')' || ch=='}' || ch==']')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                char top = stack.pop();
                if((ch==')' && top!='(') || (ch=='}' && top!='{') || (ch==']' && top!='['))
                {
                    return false;
                }
            }
        }

        if(stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
