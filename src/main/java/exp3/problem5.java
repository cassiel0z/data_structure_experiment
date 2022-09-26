package exp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class problem5 {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("./src/main/java/exp3/problem5.txt"));
            StringBuilder str;
            while (in.ready()) {
                str = (new StringBuilder(in.readLine()));
                System.out.println(calculatePostfix(str.toString()));
            }
            in.close();
        } catch (IOException ignored) {
        }
    }

    public static int calculatePostfix(String s) {
        String pf = toPostfix(s);
        String[] strArray = pf.split(" ");
        MyStack<String> stack = new MyStack<>();
        for (String x : strArray) {
            if (isNumeric(x)) {
                stack.push(x);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (x) {
                    case "+" -> stack.push(String.valueOf(a + b));
                    case "-" -> stack.push(String.valueOf(b - a));
                    case "*" -> stack.push(String.valueOf(a * b));
                    case "/" -> stack.push(String.valueOf(b / a));
                }

            }
        }
        return Integer.parseInt(stack.pop());

    }

    public static String toPostfix(String s) {
        String[] strArray = s.split(" ");
        MyStack<String> s1 = new MyStack<>();
        MyStack<String> s2 = new MyStack<>();
        StringBuilder res = new StringBuilder();
        boolean flag;
        for (String x : strArray) {
            flag = true;
            while (flag) {
                switch (x) {
                    case "+":
                    case "-":
                        if (s2.empty()) {
                            s2.push(x);
                            flag = false;
                        } else {
                            if (!s2.peek().equals("(")) {
                                String temp = s2.pop();
                                s1.push(temp);
                                res.append(temp).append(" ");
                            } else {
                                s2.push(x);
                                flag = false;
                            }
                        }
                        break;
                    case "*":
                    case "/":
                        if (s2.empty()) {
                            s2.push(x);
                            flag = false;
                        } else {
                            if (s2.peek().equals("/") || s2.peek().equals("*")) {
                                String temp = s2.pop();
                                s1.push(temp);
                                res.append(temp).append(" ");
                            } else {
                                s2.push(x);
                                flag = false;
                            }
                        }
                        break;
                    case "(":
                        s2.push(x);
                        flag = false;
                        break;
                    case ")":
                        while (!s2.peek().equals("(")) {
                            String temp = s2.pop();
                            s1.push(temp);
                            res.append(temp).append(" ");
                        }
                        s2.pop();
                        flag = false;
                        break;
                    default:
                        s1.push(x);
                        res.append(x).append(" ");
                        flag = false;
                }
            }
        }
        while (!s2.empty()) {
            String temp = s2.pop();
            s1.push(temp);
            res.append(temp).append(" ");
        }

        return res.toString();
    }

    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        return isNum.matches();
    }

}
