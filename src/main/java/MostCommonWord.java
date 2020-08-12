import javafx.util.Pair;

import java.util.*;

/**
 * @author schandna created on 25/07/20
 */
public class MostCommonWord {

    public String mostCommonWordOnce(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; ++p) {
            char currChar = chars[p];

            // 1). consume the characters in a word
            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (p != chars.length - 1)
                    // skip the rest of the processing
                    continue;
            }

            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                // identify the maximum count while updating the wordCount table.
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                // reset the buffer for the next word
                wordBuffer = new StringBuilder();
            }
        }
        return ans;
    }

    public String mostCommonWordMap(String paragraph, String[] banned) {

        if (paragraph == null || paragraph.length() == 0){
            return "";
        }

        Set<String> banSet = null;
        if (banned != null && banned.length != 0){
            banSet = new HashSet<>(Arrays.asList(banned));
        }
        Map<String, Integer> mp = new HashMap<>();

        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        paragraph = paragraph.replaceAll("[-+.^:,]","");
        for(String word : paragraph.split(" ")){

            if (!banSet.contains(word)) {
                int count = mp.getOrDefault(word.toLowerCase(), 0);
                mp.put(word.toLowerCase(), count+1);
            }
        }

        String common = Collections.max(mp.entrySet(), Map.Entry.comparingByValue()).getKey();;
        return common;
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        if (paragraph == null || paragraph.length() == 0){
            return "";
        }

        Set<String> banSet = null;
        if (banned != null && banned.length != 0){
            banSet = new HashSet<>(Arrays.asList(banned));
        }
        Map<String, Integer> mp = new HashMap<>();
        PriorityQueue<Pair<Integer, String>> pq = new PriorityQueue<>(2, (p1, p2) -> p2.getKey() - p1.getKey());

        paragraph = paragraph.replaceAll("[-+.^:,]","");
        for(String word : paragraph.split(" ")){
            int count = mp.getOrDefault(word.toLowerCase(), 0);
            mp.put(word.toLowerCase(), count+1);
        }

        if (banSet != null){
            for(String key: mp.keySet()){
                if(!banSet.contains(key)){
                    pq.add(new Pair<>(mp.get(key), key));
                }
            }
        } else {
            for(String key: mp.keySet()){
                pq.add(new Pair<>(mp.get(key), key));
            }
        }

        String common = pq.isEmpty() ? "" : pq.poll().getValue();
        return common;

//        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        MostCommonWord commonWord = new MostCommonWord();

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String [] {"hit"};

        System.out.println(commonWord.mostCommonWordMap(paragraph, banned));
    }
}
