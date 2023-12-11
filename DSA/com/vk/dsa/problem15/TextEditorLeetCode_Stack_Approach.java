
package com.vk.dsa.problem15;

import java.util.Stack;

/**
 * This problem is from Leetcode
 * this is to create a text editor.
 * Level : HARD
 * @author : Varun.Kumar
 */
public class TextEditorLeetCode_Stack_Approach {
    public static void main(String[] args) {
        //test case 1
        TextEditor2 te = new TextEditor2();
        te.addText("leetcode");
        System.out.println(te.deleteText(4));
        te.addText("practice");
        System.out.println(te.cursorRight(3));
        System.out.println(te.cursorLeft(8));
        System.out.println(te.deleteText(10));
        System.out.println(te.cursorLeft(2));
        System.out.println(te.cursorRight(6));

    }
}
class TextEditor2 {

    Stack<Character> left;
    Stack<Character> right;
    public TextEditor2() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void addText(String text) {
        for (char ch : text.toCharArray()) {
            left.push(ch);
        }
    }

    public int deleteText(int k) {
        int m = Math.min(k, left.size());
        int r = m;
        while (m > 0) {
            left.pop();
            m--;
        }
        return r;
    }

    public String cursorLeft(int k) {
        int m = Math.min(k, left.size());
        String str = "";
        while (m-- > 0) {
            char ch = left.pop();
            right.push(ch);
        }
        m = Math.min(10, left.size());
        Stack<Character> rev = new Stack<>();
        while (m-- > 0) {
            rev.push(left.pop());
        }
        while (!rev.isEmpty()) {
            char ch = rev.pop();
            str = str + ch;
            left.push(ch);
        }
        return str;
    }

    public String cursorRight(int k) {
        int m = Math.min(k, right.size());
        String str = "";
        while (m-- > 0) {
            char ch = right.pop();
            left.push(ch);
        }
        m = Math.min (10, left.size());
        Stack<Character> rev = new Stack<>();
        while (m-- > 0) {
            rev.push(left.pop());
        }
        while (!rev.isEmpty()) {
            char ch = rev.pop();
            str = str + ch;
            left.push(ch);
        }
        return str;
    }
}
