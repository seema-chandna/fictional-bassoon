import java.util.Map;
import java.util.TreeMap;

/**
 * @author schandna created on 21/03/20
 */
public class FractionalNumbers {

    public static void main(String[] args) {
        double t = ((double)2) / 1;
        int rem = 3%2;


        Double.toString(t);
        System.out.println(t + " rem " + rem + " - " + Double.toString(t).length());
//
//        String se = "ab";
//
//        String test = "ghab";
//
//        int i = test.indexOf(se);
//
//        System.out.println(i);

        System.out.println(fractionToDecimal(-2147483648, 3));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(25, 5));
    }

    public static String fractionToDecimal1(int numerator, int denominator) {

        String result = "";

        double div = ((double)numerator) / denominator;
        long decimal = (long) div;

        if(div<0){
            result += "-";
        }
        result += Math.abs(decimal);
        double frac = Math.abs(div - decimal);

        if(frac > 0.0){
            result += ".";

            String repSeq = repSeq(Math.abs( (long)numerator), Math.abs( (long)denominator));

            result += repSeq;

//            String temp = Double.toString(frac);
//
//            if (repSeq != null) {
//                int idx = temp.indexOf(repSeq);
//                for(int i=2; i < idx; i++) {
//                    result += temp.charAt(i);
//                }
//                result += "(" + repSeq + ")";
//            } else {
//                for(int i=2 ; i < temp.length(); i++) {
//                    result += temp.charAt(i);
//                }
//            }




//             for(int i=2 ; i < temp.length(); i++) {

//                 if(i+1 == temp.length()){
//                    result += temp.charAt(i);
//                 } else if(temp.charAt(i) != temp.charAt(i+1)) {
//                     result += temp.charAt(i);
//                 } else {
//                     result += "(" + temp.charAt(i) + ")";
//                     break;
//                 }
//             }
        }
        return result;
    }

    public static String fractionToDecimal(int numerator, int denominator) {

        String result = "";

        double div = ((double)numerator) / denominator;

        if(div<0){
            result += "-";
        }
        result += Math.abs((long) div);

        String repSeq = repSeq(Math.abs( (long)numerator), Math.abs( (long)denominator));

        result += (repSeq != "" ? "." : "") + repSeq;

        return result;
    }

    static String repSeq(long numerator, long denominator) {

        String res = "";
        Map<Long, Integer> mp = new TreeMap<>();
        long rem = numerator % denominator;

        while((rem!=0) && (!mp.containsKey(rem))){

            mp.put(rem, res.length());

            rem=rem*10;

            long res_Part=rem / denominator;

            res+=Long.toString(res_Part);

            rem=rem % denominator;
        }

        if(rem==0) {
            return res;
        } else {
            return res.substring(0,mp.get(rem)) + "(" + res.substring(mp.get(rem)) + ")";
        }

        /*String repSeq = (rem==0)? null:res.substring(mp.get(rem));

        if(repSeq != null) {
            return res.substring(0,mp.get(rem)) + "(" + repSeq + ")";
        } else {
            return res;
        }*/
    }

//    public static String fractionToDecimal(int numerator, int denominator) {
//        String result = "";
//
//        double div = ((double) numerator) / denominator;
//
//        int decimal = (int) div;
//
//        result += decimal;
//
//        double frac = div - decimal;
//
//        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
//
//        if (frac > 0.0) {
//            result += ".";
//
//            String temp = Double.toString(frac);
//
//            for (int i = 2; i < temp.length(); i++) {
//
//                if (i + 1 == temp.length()) {
//                    result += temp.charAt(i);
//                } else if (temp.charAt(i) != temp.charAt(i + 1)) {
//                    result += temp.charAt(i);
//                } else {
//                    result += "(" + temp.charAt(i) + ")";
//                    break;
//                }
//            }
//        }
//        return result;
//    }
}
