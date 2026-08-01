package LeetCodeMedium;

import java.util.Stack;

public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String i: tokens){

            int a, b;
            switch (i){
                case "+":   a = stack.pop();
                            b = stack.pop();
                            stack.push(a+b);
                            break;

                case "-":   a = stack.pop();
                            b = stack.pop();
                            stack.push(b-a);
                            break;

                case "*":   a = stack.pop();
                            b = stack.pop();
                            stack.push(a*b);
                            break;

                case "/":   a = stack.pop();
                            b = stack.pop();
                            stack.push(b/a);
                            break;

                default:  stack.push(Integer.parseInt(i));
            }
        }

        return stack.pop();
    }

}
