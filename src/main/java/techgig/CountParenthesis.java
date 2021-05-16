package techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountParenthesis {

    public static void main(String... a) {
//        System.out.println(new CountParenthesis().tryCatchCheck());
        System.out.println(new CountParenthesis().countParentheses(""));
    }

    public int countParentheses(String input) {
        int count = 0;
        input = "((((()";
        List<Character> vals = new Stack<>();
        int top = -1;
        for (char c : input.toCharArray()) {
            if (c == '(') vals.add(c);

            top = vals.size() - 1;
            if (!vals.isEmpty()) {
                Character cc = vals.remove(top);
                if(cc == ')') count += 2 ;
            }


        }
        return count;
    }

    public int tryCatchCheck() {

        int i = 0;
        try {
            int b = 10;
            i = b / i;


        } catch(ArithmeticException e) {
            i  =  1;
            return i;
        } finally {
            i = 2;
            return i;
        }
    }
}
