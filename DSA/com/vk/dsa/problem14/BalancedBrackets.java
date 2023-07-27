package com.vk.dsa.problem14;

import java.util.Stack;

/**
 * This program is to check if given set of brackets/paranthesis is balanced or not.
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        String s = "{)";
        System.out.println(isValid(s));



    }

    private static boolean isValid(String s) {
        boolean isValid = false;
        Stack<Character> st = new Stack<>();
        if (null == s || 0 == s.length()) {
            return isValid;
        }

        for (Character nextCh : s.toCharArray()) {
            if (nextCh == '(' || nextCh == '{' || nextCh == '[') {
                st.push(nextCh);
            } else if (nextCh == ')' || nextCh == '}' || nextCh == ']') {
                if (st.isEmpty()) {
                    isValid = false;
                    break;
                }

                char prevCh = st.pop();
                if (prevCh == '(' && nextCh == ')' ||
                        prevCh == '[' && nextCh == ']' ||
                        prevCh == '{' && nextCh == '}') {
                    isValid = true;
                } else {
                    isValid = false;
                    break;
                }
            }
        }
        if (isValid && st.isEmpty()) {
            return true;
        } else if (isValid && !st.isEmpty()) {
            return false;
        } else if (!isValid) {
            return true;
        }
        return false;
    }
}
