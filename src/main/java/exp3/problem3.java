package exp3;

import java.io.*;
import java.util.Stack;

public class problem3 {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("./src/main/java/exp3/problem3.txt"));
            StringBuilder str;
            while (in.ready()) {
                str = (new StringBuilder(in.readLine()));
                System.out.println(isParenthesisMatch_myStack(String.valueOf(str)));
                System.out.println(isParenthesisMatch_Stack(String.valueOf(str)));
            }
            in.close();
        } catch (IOException ignored) {
        }
    }

    public static boolean isParenthesisMatch_myStack(String str) {
        MyStack<Character> stack = new MyStack<>();
        int flag1=0,flag2=0,index=0;
        char[] s=str.toCharArray();
        for (Character ch : s) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals('(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals('[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals('{')) {
                        return false;
                    }
                    break;
                case '/':
                    if(flag1==0){
                        stack.push(ch);
                        if(s[index+1]!='*') return false;
                        flag1=1;
                        break;
                    }
                    else {
                        flag1=0;
                        if(stack.pop()!='*') return false;
                        if(flag2==1) return false;
                        stack.pop();
                        stack.pop();
                    }
                    break;
                case '*':
                    if(flag1==0) return false;
                    else if(flag2==0){
                        if(stack.peek()!='/') return false;
                        stack.push(ch);

                        flag2=1;
                        break;
                    }
                    else {
                        flag2=0;
                        if(s[index+1]!='/') return false;
                        stack.push(ch);
                    }
                    break;
                default:
                    break;
            }
            index++;
        }
        return stack.empty();
    }

    public static boolean isParenthesisMatch_Stack(String str) {
        Stack<Character> stack = new Stack<>();
        int flag1=0,flag2=0,index=0;
        char[] s=str.toCharArray();
        for (Character ch : s) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals('(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals('[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals('{')) {
                        return false;
                    }
                    break;
                case '/':
                    if(flag1==0){
                        stack.push(ch);
                        if(s[index+1]!='*') return false;
                        flag1=1;
                        break;
                    }
                    else {
                        flag1=0;
                        if(stack.pop()!='*') return false;
                        if(flag2==1) return false;
                        stack.pop();
                        stack.pop();
                    }
                    break;
                case '*':
                    if(flag1==0) return false;
                    else if(flag2==0){
                        if(stack.peek()!='/') return false;
                        stack.push(ch);

                        flag2=1;
                        break;
                    }
                    else {
                        flag2=0;
                        if(s[index+1]!='/') return false;
                        stack.push(ch);
                    }
                    break;
                default:
                    break;
            }
            index++;
        }
        return stack.empty();
    }
}
