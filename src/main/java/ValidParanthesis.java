/**
 * @author schandna created on 10/04/20
 */
public class ValidParanthesis {

    static boolean isValidString(String str) {

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    public static void main(String[] args) {
//        System.out.println(isValidString(")))((("));

        System.out.println(checkValidString("(*))")); // true
        System.out.println(checkValidString("(((******))")); // true
        System.out.println(checkValidString("(")); // false
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*")); // false

        System.out.println(checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)")); // true

        System.out.println(checkValidString("(())(())(((()*()()()))()((()()(*()())))(((*)()")); // false

        // (*)**((**))((**)
        // (*(*)((*
        // (*(*(*(**)))
    }


    /*
    Valid Parenthesis String
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
     */

    public static boolean checkValidString_(String s) { // not completely working
        if(s == null || s.length() == 0) {
            return true;
        }
        int count=0;

        int countS=0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*') {
                countS++;
                if(i+1<s.length() && (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
                    continue;
                }
            }
            if(s.charAt(i) == '(') {
                count++;
                if(count == 1) {
                    countS=0;
                }
            } else if(s.charAt(i) == ')') {
                count--;
            }

            if(count<0){
                if(countS > 0) {
                    countS--;
                    count++;
                    continue;
                }
                return false;
            } else if (countS>0 && count>1 && countS>=count) {
                countS=count=0;
            }
        }

        return (count==0 || (countS>0 && Math.abs(count) <= countS));
    }

    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }


}
