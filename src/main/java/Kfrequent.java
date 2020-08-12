import java.util.*;

/**
 * @author schandna created on 18/06/20
 */
public class Kfrequent {

    /*

692. Top K Frequent Words

    Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
     */
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || words.length == 0){
            return null;
        }
        List<String> res = new LinkedList<>();
//        Map<String, Integer> freqMap = new TreeMap<>();
        Map<String, Integer> freqMap = new HashMap<>();

        for(String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0)+1);
        }

        // PriorityQueue<String> heap = new PriorityQueue<String>(
        //                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
        //                w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((o1, o2) ->
                o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue());
//        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
//        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));

        for (Map.Entry e : freqMap.entrySet()) {
            q.offer(e);
        }

        for (int i=0; i<k; i++) {
            res.add(q.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }

    /*
    The comparison of strings is case-insensitive.
Multiple occurances of a keyword in a review should be considred as a single mention.
If keywords are mentioned an equal number of times in reviews, sort alphabetically.

Example 1:

Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
Example 2:

Input:
k = 2
keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]

Output:
["betacellular", "anacell"]

Explanation:
"betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.

     */
    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();
        for(String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for(String s : strs) {
                s = s.toLowerCase();
                if(set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    public static List<String> getFrequent(int k,String[] keywords,String[] reviews){
//        Map<String,Integer> count= new HashMap<>();
//        List<String> keywordsList= Arrays.asList(keywords);
//        for(String word:words){
//            for(String s:word.split("\\s+")){
//                if(keywordsList.contains(s)){
//                    count.put(s,count.getOrDefault(s,0)+1);
//                }
//            }
//        }
//
//        List<String> ls = new ArrayList<>(count.keySet());
//        Collections.sort(ls, (a,b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));
//
//        return ls.subList(0,k);

        List<String> keywordsList = Arrays.asList(keywords) ;
        HashMap<String,Integer> map = new HashMap<>() ;

        for( String words : reviews){

            Set<String> added = new HashSet<String>() ;

            for(String str :words.split("\\s+")){

                str = str.toLowerCase() ;
                if(keywordsList.contains(str) && !added.contains(str)){

                    map.put(str,map.getOrDefault(str,0)+1) ;
                    added.add(str);
                }
            }
        }

        List<String> ls = new ArrayList<>(map.keySet()) ;

        Collections.sort(ls,(a,b)->(map.get(a)).equals(map.get(b))?a.compareTo(b):map.get(b)-map.get(a));

        return ls.subList(0,k) ;
    }

}
