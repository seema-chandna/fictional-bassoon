import java.util.ArrayList;
import java.util.List;

/**
 * @author schandna created on 03/04/20
 */
public class AllAnagrams {

    /*

    Find All Anagrams in a String

    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
     */

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        int anaLen = p.length();
        int[] countP = new int[26];
        for(int i=0; i<anaLen; i++){
            countP[p.charAt(i)-'a']++;
        }

        for(int i=0; i<=s.length()-anaLen; i++){
            if(checkAnagram(s.substring(i, i+anaLen), countP)) {
                res.add(i);
            }
        }

        return res;
    }

    boolean checkAnagram(String txt, int[] countP) {

        int[] count = new int[26];
        for(int i=0; i<txt.length(); i++) {
            int index = txt.charAt(i)-'a';
            if(countP[index] == 0){
                return false;
            }
            count[index]++;
        }

        for(int i=0; i<26; i++) {
            if(count[i] != countP[i]){
                return false;
            }
        }
        return true;
    }

    final int MAX = 256;

    // This function returns true if contents
    // of arr1[] and arr2[] are same, otherwise
    // false.
    private boolean compare(char arr1[], char arr2[]) {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    public List<Integer> findAnagrams3(String txt, String pat) { // 16 ms from gfg

        List<Integer> res = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();

        if(N<M){
            return res;
        }
        // countP[]:  Store count of all
        // characters of pattern
        // countTW[]: Store count of current
        // window of text
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++)
        {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        // Traverse through remaining characters
        // of pattern
        for (int i = M; i < N; i++)
        {
            // Compare counts of current window
            // of text with counts of pattern[]
            if (compare(countP, countTW))
                res.add(i - M);

            // Add current character to current
            // window
            (countTW[txt.charAt(i)])++;

            // Remove the first character of previous
            // window
            countTW[txt.charAt(i-M)]--;
        }

        // Check for the last window in text
        if (compare(countP, countTW))
            res.add(N - M);

        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) { // 6ms
        int map[] = new int[26];
        char arr[] = p.toCharArray();
        for(char c: arr){
            map[c-'a']++;
        }
        arr = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        int i=0, j=0;
        while(j < arr.length){
            char c = arr[j];
            if(i == j && map[c-'a']==0){
                i++;
                j++;
                continue;
            }
            if(map[c-'a'] > 0){
                map[c-'a']--;
                if(j-i + 1 == p.length()){
                    result.add(i);
                    map[arr[i]-'a']++;
                    i++;
                }
                j++;
            }else{
                map[arr[i]-'a']++;
                i++;
            }
        }
        return result;
    }
}
