package com.vk.dsa.problem15;

/**
 * This problem is from Leetcode
 * this is to create a text editor.
 * Level : HARD
 * @author : Varun.Kumar
 */
public class TextEditorLeetCode_Bruteforce_Approach {
    public static void main(String[] args) {


        //test case 2
        TextEditor te = new TextEditor();
        te.addText("jxarid");
        System.out.println(te.cursorLeft(5));
        System.out.println(te.cursorLeft(10));
        te.addText("du");
        System.out.println(te.deleteText(20));

        //test case 3

/*
        TextEditor te = new TextEditor();
        System.out.println(te.cursorLeft(14));
        te.addText("soxqep");
        System.out.println(te.cursorLeft(7));
        te.addText("rfdrotsyeoy");
        System.out.println(te.cursorRight(19));
*/


    }
}
class TextEditor {

    StringBuilder text1;
    int cursor;
    public TextEditor() {
        text1 = new StringBuilder("|");
        cursor = 0;
    }

    public void addText(String text) {
        text1.insert(cursor, text);
        cursor = cursor + text.length();
    }

    public int deleteText(int k) {
        int orgLen = text1.length();

        //identifying startIndex
        int startIndex = cursor-k;
        if (startIndex < 0) {
            startIndex = 0;
        }
        int endIndex = cursor;
        //int leftLenToDelete = text1.substring(startIndex, endIndex).length();
        StringBuilder deleted = text1.delete(startIndex, endIndex);
        cursor = cursor - k;
        if (cursor < 0) {
            cursor = 0;
        }

        return orgLen - deleted.length();
    }

    public String cursorLeft(int k) {
        //moving cursor position
        int tempCursor = cursor;
        if (tempCursor >= k) {
            tempCursor = tempCursor - k;
        } else {
            tempCursor = 0;
        }

        if (tempCursor >= 0) {
            text1.deleteCharAt(cursor);
            cursor = tempCursor;
            text1.insert(cursor, '|');
        }
        //returning required content
        int leftLen = text1.substring(0, cursor).length();
        int min = Math.min(10, leftLen);
        return text1.substring(tempCursor-min, tempCursor);
    }

    public String cursorRight(int k) {
        //moving cursor position
        int tempCursor = cursor;
        tempCursor = tempCursor + k;
        int maxRight = text1.length()-1;
        if (tempCursor > maxRight) {
            tempCursor = maxRight;
        }

        if (tempCursor <= text1.length()) {
            text1.deleteCharAt(cursor);
            cursor = tempCursor;
            text1.insert(cursor, '|');
        }
        //returning required content
        int leftLen = text1.substring(0, cursor).length();
        int min = Math.min(10, leftLen);
        return text1.substring((tempCursor-min), tempCursor);
    }
}