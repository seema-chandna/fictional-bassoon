import java.util.*;

/**
 * @author schandna created on 04/04/20
 */
public class GroupAnagrams {

    /*

    Given an array of strings, group anagrams together.

        Example:

        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]
        Note:

        All inputs will be in lowercase.
        The order of your output does not matter.
     */

    public static void main(String[] args) {
        List<List<String>> res = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }

    /*
    Complexity Analysis - groupAnagrams

        Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.
                The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.

        Space Complexity: O(NK), the total information content stored in ans.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> resMap = new HashMap<>();
        for(String str : strs){
            String s = ascStr(str);

            List<String> sList = resMap.get(s);
            if(sList == null){
                sList = new ArrayList<>();
            }
            sList.add(str);
            resMap.put(s, sList);
        }
        return new ArrayList<>(resMap.values());
    }

    static String ascStr(String str) {

        char[] s = str.toCharArray();
        Arrays.sort(s);
        return new String(s);
        /*
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
         */
    }



    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    /*
    Complexity Analysis

        Time Complexity: O(NK), where NN is the length of strs, and K is the maximum length of a string in strs.
                            Counting each string is linear in the size of the string, and we count every string.

        Space Complexity: O(NK), the total information content stored in ans.
     */

}
