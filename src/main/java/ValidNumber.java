
import java.util.regex.Pattern;

/**
 * @author schandna created on 19/04/20
 */
public class ValidNumber {

    // https://leetcode.com/submissions/detail/327296120/
    static public boolean isNumber(String s) {

        if(s == null || s.length() == 0){
            return false;
        }

        String res = s.trim();
        if(res.length() == 0){
            return false;
        }
        // res = res.replaceAll("[0-9]","");

//         boolean status = Pattern.matches("[\\+\\-]{0,1}[0-9]*[\\.]?[0-9]*[e]?[\\-]?[0-9]*", res);

        boolean status = Pattern.matches("^[\\+\\-]{0,1}([0-9]+[\\.][0-9]*|[0-9]*[\\.][0-9]+|[0-9]+)(e[\\+\\-]{0,1}[0-9]+)?[0-9]*", res);

        res = res.replaceAll("^[\\+\\-]{0,1}([0-9]+[\\.][0-9]*|[0-9]*[\\.][0-9]+|[0-9]+)(e[\\+\\-]{0,1}[0-9]+)?[0-9]*","");

        return res.length() >= 1 ? false : true;
    }

    public static void main(String[] args) {

        System.out.println(" --6 >> " + isNumber(" --6")); // false
        System.out.println(" -6 >> " + isNumber(" -6")); // true
        System.out.println("e >> " + isNumber("e")); // false
        System.out.println(" >> " + isNumber(" ")); //false
        System.out.println("3. >> " + isNumber(" 3.")); // true
        System.out.println(". >> " + isNumber(".")); // false
        System.out.println(".1 >> " + isNumber(".1")); // true
        System.out.println("e6 >> " + isNumber("e6")); // false
        System.out.println(" 005047e+6 >> " + isNumber(" 005047e+6")); // true

    }

    public boolean isNumberMine(String s) {

        if(s == null || s.length() == 0 ){
            return false;
        }

        String res = s.trim();

        if(res.length() == 0){
            return false;
        }

//         res = res.replaceAll("^[\\+\\-]{0,1}([0-9]+[\\.][0-9]*|[0-9]*[\\.][0-9]+|[0-9]+)(e[\\+\\-]{0,1}[0-9]+)?[0-9]*","");

//         return res.length() >= 1 ? false : true;
        return  Pattern.matches("^[\\+\\-]{0,1}([0-9]+[\\.][0-9]*|[0-9]*[\\.][0-9]+|[0-9]+)(e[\\+\\-]{0,1}[0-9]+)?[0-9]*", res);
    }

    public boolean isNumber1ms(String s) {
        s = s.trim();

        // flag for the point
        boolean pointSeen = false;
        // flag for seen
        boolean eSeen = false;
        // flag for number seen
        boolean numberSeen = false;

        // flag for number after e
        boolean numberAfterE = false;

        for(int i=0; i<s.length(); i++) {

            // if we see number
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                // if we see a dot ...
                if(eSeen || pointSeen) { //any e or another point would be false
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {

                // we have seen an 'e'
                if(eSeen || !numberSeen) { // another e would be false; or no number seen will be false;
                    return false;
                }
                // toggle the numbers
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }

    public boolean isNumber2ms(String s) {
        s = s.trim();

        boolean dotSeen = false, eSeen = false;
        boolean numSeen = false;
        boolean numBeforeE = false, numAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '.') {
                // no dot or no e allowed before another dot
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } else if (c == 'e') {
                // no e allowed before another e
                // must have number before e
                if (eSeen) return false;
                eSeen = true;
            } else if (Character.isDigit(c)) {
                if (eSeen) {
                    numAfterE = true;
                } else {
                    numBeforeE = true;
                }

                numSeen = true;
            } else if (c == '-' || c == '+') {
                if (i == 0 || s.charAt(i-1) == 'e') continue;
                return false;
            } else {
                return false;
            }
        }

        if (eSeen && !(numBeforeE && numAfterE)) return false; // must have number on both sides of e
        return numSeen;
    }
}
