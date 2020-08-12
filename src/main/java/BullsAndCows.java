import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author schandna created on 02/07/20
 */
public class BullsAndCows {

    public static void main(String[] args) {
        BullsAndCows cd = new BullsAndCows();

        System.out.println(cd.getHint("1122", "1222"));

        // "1123", "0111" -> 1A1B
        // "1122", "1222" -> "3A0B"
    }

    public String getHint(String secret, String guess) {

        if (secret == null || guess == null){
            return null;
        }

        char[] secArr = secret.toCharArray();
        char[] gueArr = guess.toCharArray();

        Map<Character, Integer> mpCount = new HashMap<>();

        Integer i=0;
        for(Character c : secret.toCharArray()){
            mpCount.put(c, mpCount.getOrDefault(c, 0)+1);
        }

        List<Character> guessList = new ArrayList<>();
        for(Character c : guess.toCharArray()){
            guessList.add(c);
        }

        int bull=0, cows=0;
        i=0;
        for(i=0; i<gueArr.length; i++){

            int count = mpCount.getOrDefault(gueArr[i], 0);
            if(secArr[i] == gueArr[i]) {
                mpCount.put(gueArr[i], count-1);
                guessList.remove((Character)gueArr[i]);
            }
        }



        // for(Character c : guess.toCharArray()){
        //     int count = mpCount.getOrDefault(c, 0);
        //     if(count > 0) {
        //         List<Integer> res = mp.get(c);
        //         if (res != null && res.size() > 0){
        //             if(res.contains(i)){
        //                 bull++;
        //                 mpCount.put(c, count-1);
        //                 guessList.remove(c);
        //             }
        //         }
        //     }
        //     i++;
        // }

        i=0;
        for(Character c : guessList){
            int count = mpCount.getOrDefault(c, 0);
            if(count > 0) {
                cows++;
                mpCount.put(c, count-1);
            }
            i++;
        }

        return bull+"A"+cows+"B";
    }

    public String getHint2(String secret, String guess) {

        if (secret == null || guess == null){
            return null;
        }

        Map<Character, List<Integer>> mp = new HashMap<>();
        Map<Character, Integer> mpCount = new HashMap<>();

        Integer i=0;
        for(Character c : secret.toCharArray()){
            List<Integer> res = mp.getOrDefault(c, new ArrayList());
            res.add(i++);
            mp.put(c, res);
            mpCount.put(c, mpCount.getOrDefault(c, 0)+1);
        }

        List<Character> guessList = new ArrayList<>();
        for(Character c : guess.toCharArray()){
            guessList.add(c);
        }

        int bull=0, cows=0;
        i=0;
        for(Character c : guess.toCharArray()){
            int count = mpCount.getOrDefault(c, 0);
            if(count > 0) {
                List<Integer> res = mp.get(c);
                if (res != null && res.size() > 0){
                    if(res.contains(i)){
                        bull++;
                        mpCount.put(c, count-1);
                        guessList.remove(c);
                    }
                }
            }
            i++;
        }

        i=0;
        for(Character c : guessList){
            int count = mpCount.getOrDefault(c, 0);
            if(count > 0) {
                cows++;
                mpCount.put(c, count-1);
            }
            i++;
        }

        return bull+"A"+cows+"B";
    }

    public String getHint1ms(String secret, String guess) {
        char[] secArr = secret.toCharArray();
        char[] gueArr = guess.toCharArray();
        int[] numCount = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secArr.length; i++) {
            if (secArr[i] == gueArr[i]) {
                bull++;
            } else {
                numCount[secArr[i]-'0']--;
                numCount[gueArr[i]-'0']++;
                if (numCount[secArr[i]-'0'] >= 0) {
                    cow++;
                }
                if (numCount[gueArr[i]-'0'] <= 0) {
                    cow++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull).append('A').append(cow).append('B');
        return sb.toString();
    }

    public String getHint2ms(String secret, String guess) {
        int n = secret.length();
        int[] arr = new int[n];
        int[] exist = new int[10];
        List<Integer> unmatched = new ArrayList();

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < n; i++) {
            int num = secret.charAt(i) - '0';
            exist[num]++;
            arr[i] = num;
        }

        for (int i = 0; i < guess.length(); i++) {
            int num = guess.charAt(i) - '0';
            if (i < n && arr[i] == num) {
                bull++;
                exist[num]--;
            } else {
                unmatched.add(i);
            }
        }

        for (int i : unmatched) {
            int num = guess.charAt(i) - '0';
            if (exist[num] > 0) {
                exist[num]--;
                cow++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append('A');
        sb.append(cow);
        sb.append('B');

        return sb.toString();
    }

//    public String getHint(String secret, String guess) {
//
//        if (secret == null || guess == null){
//            return null;
//        }
//
//        Map<Character, Integer> mp = new HashMap<>();
//
//        int i=0;
//        for(Character c : secret.toCharArray()){
//            mp.put(c, i++);
//        }
//
//        int bull=0, cows=0;
//        i=0;
//        for(Character c : guess.toCharArray()){
//            if (mp.containsKey(c)){
//                int scIndx = mp.get(c);
//                if(scIndx == i){
//                    bull++;
//                } else {
//                    cows++;
//                }
//            }
//            i++;
//        }
//
//        return bull+"A"+cows+"B";
//    }
}
