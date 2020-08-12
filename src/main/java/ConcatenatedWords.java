import com.sun.tools.javac.util.StringUtils;
import org.graalvm.util.CollectionsUtil;

import java.util.*;

/**
 * @author schandna created on 25/07/20
 */
public class ConcatenatedWords {

    /*
    472. Concatenated Words          -       Hard

Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.
     */


    List<String> res;
    List<String> dict;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        res = new ArrayList<>();
//        dict = new PriorityQueue<String>(words.length, (s1, s2) -> s1.length() - s2.length());
        dict = new ArrayList<>();
        PriorityQueue<String> dict1 = new PriorityQueue<>(Comparator.reverseOrder());
        dict1 = new PriorityQueue<String>(words.length, Comparator.comparingInt(String::length));
        dict1 = new PriorityQueue<String>(words.length, (s1, s2) -> s1.length() - s2.length());


        for(String w : words) {
            if(w !=null && w.trim().length()>0){
                dict.add(w);
            }
        }
        if (dict != null && dict.isEmpty()){
            return res;
        }

        Collections.sort(dict, Comparator.comparingInt(String::length));

        for(String w : dict) {
            boolean status = wordBreak(w, 0, new boolean[w.length()]);

            if(status) {
                res.add(w);
            }
        }

        return res;
    }

    boolean wordBreak(String word, int start, boolean[] visited) {

        if(start == word.length()){
            return true;
        }

        if(visited[start]){
            return false;
        }

        visited[start] = true;

        for(String d : dict){
            if(d.length() >= word.length()){
                break;
            }
            if(word.startsWith(d, start) && wordBreak(word, start + d.length(), visited)){
                return true;
            }
        }

//        Iterator itr = dict.iterator();
//        while (itr.hasNext()) {
//            String d = (String)itr.next();
//            if(d.length() >= word.length()){
//                break;
//            }
//            if(word.startsWith(d, start) && wordBreak(word, start + d.length(), visited)){
//                return true;
//            }
//        }
        return false;
    }

    public static void main(String[] args) {
        ConcatenatedWords cw = new ConcatenatedWords();
        List<String> res;
        res = cw.findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
        System.out.println(res);

        res = cw.findAllConcatenatedWordsInADict(new String[] {"cat","cats","catscats","dog"});
        System.out.println(res);

        res = cw.findAllConcatenatedWordsInADict(new String[] {"", "cat","cats","catscats","dog"});
        System.out.println(res);

        res = cw.findAllConcatenatedWordsInADict(new String[] {""});
        System.out.println(res);
    }

}
