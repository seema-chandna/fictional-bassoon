import javafx.util.Pair;

import java.util.*;

/**
 * @author schandna created on 18/07/20
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = getAllComboDict(wordList, L);

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                List<String> adjacentWordList = allComboDict.getOrDefault(newWord, new ArrayList<>());

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : adjacentWordList) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    Map<String, List<String>> getAllComboDict(List<String> wordList, int L) {

        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach( word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });
        return allComboDict;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();

        List<String> wordList = Arrays.asList(new String [] {"hot","dot","dog","lot","log","cog", "hig","hog"});
        System.out.println(wordLadder.ladderLength("hit", "cog", wordList));
    }

}
