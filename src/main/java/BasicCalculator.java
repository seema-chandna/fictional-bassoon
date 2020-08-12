import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author schandna created on 05/07/20
 */
public class BasicCalculator {

    /*

    Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
     */
    public int calculate(String s) { // now 7 ms

        Stack<Integer> st = new Stack<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();

        int res=0, num=0;
        boolean minus = false;
        char ch;

        for(int i=0; i<len; i++) {

            ch = s.charAt(i);
            if(ch == ' ') continue;

            if (ch == '(') {
                st.push(res);
                st.push(minus ? -1 : 1);

                minus = false;
                res=0;
            } else if (Character.isDigit(ch)) {
                num=0;
                while(i<len && Character.isDigit(s.charAt(i))) {
                    num = num *10 + (int) (s.charAt(i) -'0') ;
                    i++;
                }
                i--;
                res += (minus ? -num : num);
            } else if (ch == '+') {
                minus = false;
            } else if (ch == '-') {
                minus = true;
            } else if (ch == ')') {
                res *= st.pop();
                res += st.pop();
            }
        }
        return res;
    }


    int i=0;
    public int calculate2(String s) { // 2ms
        int sign = 1;
        int operand = 0;
        int result = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c == ' ') {
                continue;
            } else if (c == '(') {
                operand = calculate2(s);
            } else if (c == ')') {
                break;
            } else if (c >= '0' && c <= '9') {
                operand = operand * 10 + c - '0';
            } else {
                result += operand * sign;
                sign = (c == '+') ? 1 : -1;
                operand = 0;
            }
        }
        return result + operand * sign;
    }

    public static void main(String[] args) {

        BasicCalculator cal = new BasicCalculator();
//        System.out.println(cal.calculate("(1+(4+5+2)-3)+(6+8)"));

//        System.out.println(cal.calculate("2147483647"));
        System.out.println(cal.calculate2("(1+(4+5+2)-3)+(6+8)"));
    }

    /*

    Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
     */


    public int calculateII(String s) { // Mine 13 ms
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        int prev = 0, curr=0;
        char sign = '+';
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            if(Character.isDigit(s.charAt(i))) {
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    curr = curr *10 + (int) (s.charAt(i) -'0') ;
                    i++;
                }
                switch (sign) {
                    case '+':
                        res += curr;
                        prev = curr;
                        break;
                    case '-':
                        res -= curr;
                        prev = -curr;
                        break;
                    case '*':
                        res = res-prev + prev * curr;
                        prev = prev * curr;
                        break;
                    case '/':
                        res = res-prev + prev / curr;
                        prev = prev / curr;
                        break;
                }
                curr = 0;
                i--;
            } else {
                sign = s.charAt(i);
            }
        }
        return res;
    }

    public int calculateII_10ms(String s) { // 10ms
        s = s.trim();
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        //int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
//             if (Character.isDigit(c)) {
//                 num = num * 10 + (c - '0');
//             }
            if (Character.isDigit(c)) {
                // num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    num = num *10 + (int) (s.charAt(i) -'0') ;
                    i++;
                }
                i--;
            }
            if (!Character.isDigit(c) || i == s.length() -1) {
                switch (sign) {
                    //pre = 0;
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
