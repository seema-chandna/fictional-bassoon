import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author schandna created on 20/07/20
 */
public class TopShow {

    /*

In other words, more that 70% of the viewers who watched the first x eposides of a show continued on to finish the entire show. The x is what we are looking for.

User 1 - 1..10
User 2 - 1..10
User 3 - 1..10
User 4 - 1..10
User 5 - 1..10
User 6 - 1..6
User 7 - 1..6
User 8 - 1..6
User 9 - 1..8
User 10 - 1..9

100% - 1..6

x=8  -> 70 - 100

6 6 6 8 9 10 10 10 10 10

6 -> 50%
8 (7) -> 70%
9 (6) -> 6 (80%)

x -> 7


5/3+7, 5/1+6, 5/1+5, 5/5



*/


    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        TopShow sol = new TopShow();

        sol.process_log("show", 1, 6);
        sol.process_log("show", 2, 6);
        sol.process_log("show", 3, 6);
        sol.process_log("show", 4, 8);
        sol.process_log("show", 5, 9);
        sol.process_log("show", 6, 10);
        sol.process_log("show", 7, 10);
        sol.process_log("show", 8, 10);
        sol.process_log("show", 9, 10);
        sol.process_log("show", 10, 10);

        sol.print_results();
    }

    Map<String, Map<Integer, Integer>> map = new HashMap<>();
    int max = 10;

    void process_log(String show, int user_id, int episode) {

        Map<Integer, Integer> userEpMap = map.getOrDefault(show, new HashMap<>());

        Integer epi = userEpMap.getOrDefault(user_id, 0);
        userEpMap.put(user_id, Math.max(episode, epi));
        map.put(show, userEpMap);
    }


    void print_results() {

        for (String show : map.keySet()) {
            System.out.println(getHighest(show));
        }
    }


    int getHighest (String show) {

        Map<Integer, Integer> userEpMap = map.get(show);

        Map<Integer, Integer> countMap = new TreeMap<>(Comparator.reverseOrder());

        for (Integer user : userEpMap.keySet()){

            Integer epi = userEpMap.get(user);

            int count  = countMap.getOrDefault(epi, 0);
            countMap.put(epi, count+1);
        }

        double minEpi= Integer.MAX_VALUE;
        Integer totEpiWatch = 0;
        Double lastMostEpi = 0.0;
        Integer epiId=0;

        int prevEpi =0;

        for(Integer epi : countMap.keySet()){

            Integer epiWatch = countMap.get(epi);
            totEpiWatch += countMap.get(epi);

            if (epi == 10){
                lastMostEpi = Double.valueOf(epiWatch);
                continue;
            }

            double per = (lastMostEpi/totEpiWatch) * 100;

            if (per >= 70) {
                if (minEpi > per){
                    minEpi = per;
                    epiId=epi;
                }
            } else {
                prevEpi = epi;
                break;
            }
        }
        // 8

        if(prevEpi<epiId && prevEpi+1 != epiId){
            epiId = prevEpi+1;
        }

//        int lastEpi =0;
//        for(Integer epi : countMap.keySet()){
//            if(epi >= epiId) {
//                continue;
//            } else {
//                lastEpi = epi;
//                break;
//            }
//        }
//
//        if(lastEpi<epiId && lastEpi+1 != epiId){
//            epiId = lastEpi+1;
//        }


        return epiId;
    }




}
