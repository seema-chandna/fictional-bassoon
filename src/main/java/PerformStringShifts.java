import java.util.ArrayList;
import java.util.List;

/**
 * @author schandna created on 15/04/20
 */
public class PerformStringShifts {

    public static void main(String[] args) {

        // [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
        String s = "fgabcde";
        int shift = 2;

        System.out.println(s.substring(shift) + s.substring(0,shift));

        // [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
        String st = "abcdefg";
        int rShift = 3;

        System.out.println(st.substring(st.length()-rShift) + st.substring(0, st.length()-rShift));
    }

    public String stringShift(String s, int[][] shift) {
        String res = s;
        for(int i=0; i<shift.length; i++){
            if(shift[i][0] == 0){
                res = leftShift(res, shift[i][1]);
            } else {
                res = rightShift(res, shift[i][1]);
            }
        }
        return res;
    }

    public String leftShift(String s, int shift) {
        // [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
        return s.substring(shift) + s.substring(0,shift);
    }

    public String rightShift(String s, int shift) {
        // [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
        int len = s.length();
        return s.substring(len-shift) + s.substring(0, len-shift);
    }

//    public int[][] stringShift(int[][] shift) {
//
//        List<int[]> res = new ArrayList<>();
//        int k=0, l=0;
//
//        for(int i=0; i<shift.length; ){
//
//            int lcount = 0;
//            while(i<shift.length && shift[i][0] == 0) {
//                lcount += shift[i][1];
//                i++;
//            }
//            if(lcount > 0){
//                res.add(new int[]{0, lcount});
//                k++;
//            }
//
//            int rcount = 0;
//            while(i<shift.length && shift[i][0] == 1) {
//                rcount += shift[i][1];
//                i++;
//            }
//            if(rcount > 0){
//                res.add(new int[]{1, rcount});
//            }
//        }
//
//        return res;
//    }
}
