import javafx.util.Pair;

import java.util.*;

/**
 * @author schandna created on 25/07/20
 */
public class WordLadderII {

    Map<String, List<String>> allComboDict;
//    List<List<String>> result;
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//
//        result = new ArrayList<>();
//        // Since all words are of same length.
//        int L = beginWord.length();
//
//        // Dictionary to hold combination of words that can be formed,
//        // from any given word. By changing one letter at a time.
//        getAllComboDict(wordList, L);
//
//
//
//
//
//    }
//
//    void dfs(String word){
//
//        for(){
//
//        }
//
//    }

    public List<List<String>> findLadders20(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;

        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        startSet.add(beginWord);

        bfs(startSet, endSet, map, dict, false);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(res, list, beginWord, endWord, map);
        return res;
    }


    private void dfs(List<List<String>> res, List<String> list, String word, String endWord, Map<String, List<String>> map) {
        if (word.equals(endWord)) {
            res.add(new ArrayList(list));
            return;
        }

        if (map.get(word) == null) return;
        for (String next : map.get(word)) {
            list.add(next);
            dfs(res, list, next, endWord, map);
            list.remove(list.size() - 1);
        }
    }

    private void bfs(Set<String> startSet, Set<String> endSet, Map<String, List<String>> map, Set<String> dict, boolean reverse) {
        if (startSet.size() == 0) return;

        if (startSet.size() > endSet.size()) {
            bfs(endSet, startSet, map, dict, !reverse);
            return;
        }

        Set<String> tmp = new HashSet<>();
        dict.removeAll(startSet);
        boolean finish = false;

        for (String s : startSet) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char old = chs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chs[i] = c;
                    String word = new String(chs);

                    if (dict.contains(word)) {
                        if (endSet.contains(word)) {
                            finish = true;
                        } else {
                            tmp.add(word);
                        }

                        String key = reverse ? word : s;
                        String val = reverse ? s : word;

                        if (map.get(key) == null) {
                            map.put(key, new ArrayList<>());
                        }

                        map.get(key).add(val);
                    }
                }

                chs[i] = old;
            }
        }

        if (!finish) {
            bfs(tmp, endSet, map, dict, reverse);
        }
    }

    /////////////////////// ========== ////////////////////////

    public List<List<String>> findLaddersMine(String beginWord, String endWord, List<String> wordList) { // Time limit Exceeded for last input

        List<List<String>> result = new ArrayList<>();

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = getAllComboDict(wordList, L);

        // Queue for BFS
        Queue<Pair<String, Set<String>>> Q = new LinkedList<>();
        Set<String> data = new LinkedHashSet<>();
        data.add(beginWord);
        Q.add(new Pair(beginWord, data));

        // Visited to make sure we don't repeat processing same word.
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int prevLevel=0;
        int currLevel=0;

        while (!Q.isEmpty()) {
            Pair<String, Set<String>> node = Q.remove();
            String word = node.getKey();
            Set<String> levelList = node.getValue();

            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        levelList.add(endWord);
                        System.out.println(levelList);

                        prevLevel = currLevel;
                        currLevel = levelList.size();

                        if(prevLevel==0 || prevLevel == currLevel){
                            result.add(new ArrayList<>(levelList));
                        } else {
                            return result;
                        }
                        break;

//                        if(prevLevel>0 && currLevel>prevLevel){
//                            return result;
//                        }
                        // return level + 1;

                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
//                    if (!visited.contains(adjacentWord) && !adjacentWord.equals(endWord)) {
//                        visited.add(adjacentWord);
                    if(!levelList.contains(adjacentWord)){
                        Set<String> nextLevel = new LinkedHashSet<>(levelList);
                        nextLevel.add(adjacentWord);
                        Q.add(new Pair(adjacentWord, nextLevel));
                    }

//                    }
                }
            }
        }

        return result;
    }

    Map<String, List<String>> getAllComboDict(List<String> wordList, int L) {

        allComboDict = new HashMap<>();

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

    /////////////////////// ========== ////////////////////////

    Map<String, List<String>> getAllComboDict(List<String> wordList, String beginWord) {

        Map<String, List<String>> graph = new HashMap<>();
        for (String word : wordList) {
            List<String> regWords = allCombo(word);
            graph.put(word, regWords);
            for (String word2 : regWords) {
                graph.computeIfAbsent(word2, x -> new ArrayList<>()).add(word);
            }
        }

        if(!graph.containsKey(beginWord)){
            graph.put(beginWord, allCombo(beginWord));
        }

        return graph;
    }

    private List<String> allCombo(String word) {
        int n = word.length();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            result.add(word.substring(0, i) + "*" + word.substring(i + 1, n));
        }
        return result;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = getAllComboDict(wordList, beginWord);

        // Queue for BFS
        Queue<Pair<String, List<String>>> Q = new LinkedList<>();
        List<String> data = new ArrayList<>();
        data.add(beginWord);
        Q.add(new Pair(beginWord, data));

        // Visited to make sure we don't repeat processing same word.
        Set<String> visited = new HashSet<>();

        int prevLevel=0;
        int currLevel=0;
        int minPathLength = Integer.MAX_VALUE;

        while (!Q.isEmpty()) {

            int size = Q.size();
            for(int level = 0; level<size; level++){

                Pair<String, List<String>> node = Q.remove();
                String word = node.getKey();
                List<String> levelList = node.getValue();

                visited.add(word);

                // Intermediate words for current word
                for (String newWord : allComboDict.get(word)) {

                    // Next states are all the words which share the same intermediate state.
                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {

                        if (visited.contains(adjacentWord)) continue;

                        List<String> nextLevel = new ArrayList<>(levelList);
                        nextLevel.add(adjacentWord);

                        // If at any point if we find what we are looking for
                        // i.e. the end word - we can return with the answer.
                        if (adjacentWord.equals(endWord)) {
//                            System.out.println(nextLevel);

                            prevLevel = currLevel;
                            currLevel = nextLevel.size();

                            if(nextLevel.size() <= minPathLength ){
                                result.add(nextLevel);
                                minPathLength = nextLevel.size();
                            }
//                            if(prevLevel==0 || prevLevel == currLevel){
//                                result.add(nextLevel);
//                            }
                            else {
                                return result;
                            }
                            break;
                        }
                        // Otherwise, add it to the BFS Queue. Also mark it visited
                        Q.add(new Pair(adjacentWord, nextLevel));
                    }
                }

            }
        }

        return result;
    }

    /////////////////////// ========== ////////////////////////

    private List<String> comb(String word) {
        int n = word.length();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            result.add(word.substring(0, i) + "*" + word.substring(i + 1, n));
        }
        return result;
    }

    public List<List<String>> findLaddersBFS(String beginWord, String endWord, List<String> wordList) {

//        Map<String, List<String>> wordReg = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        graph.put(beginWord, comb(beginWord));
        // wordReg.computeIfAbsent(beginWord, x-> new ArrayList<>()).addAll(comb(beginWord));
        for (String word : wordList) {
            List<String> regWords = comb(word);
            // wordReg.computeIfAbsent(word, x-> new ArrayList<>()).addAll(regWords);
            graph.put(word, regWords);
            for (String word2 : regWords) {
                graph.computeIfAbsent(word2, x -> new ArrayList<>())
                        .add(word);
            }
        }
        // System.out.println(graph);
        List<List<String>> answer = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        LinkedList<Tuple> queue = new LinkedList<>();
        List<String> beginPath = new ArrayList<>();
        beginPath.add(beginWord);
        queue.offer(new Tuple(beginWord, 1, beginPath));
        int minPathLength = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Tuple cur = queue.poll();
                visited.add(cur.word);
                // System.out.println(cur.word);
                for (String word : graph.get(cur.word)) {
                    if (!graph.containsKey(word)) continue;
                    for (String neighbor : graph.get(word)) {
                        if (visited.contains(neighbor)) continue;
                        List<String> newPath = new ArrayList<>(cur.path);
                        newPath.add(neighbor);
                        if (neighbor.equals(endWord)) {
                             System.out.println("newPath - " + newPath);
                            if (newPath.size() < minPathLength) answer.clear();
                            if (newPath.size() <= minPathLength) {
                                answer.add(newPath);
                                minPathLength = newPath.size();
                            } else {
                                return answer;
                            }
                            continue;
                        }
                        queue.offer(new Tuple(neighbor, cur.level + 1, newPath));
                    }
                }
            }
        }
        return answer;
    }

    private class Tuple {
        public String word;
        public int level;
        public List<String> path;
        public Tuple(String word, int level, List<String> path) {
            this.word = word;
            this.level = level;
            this.path = path;
        }
        @Override
        public String toString() {
            return new StringBuilder()
                    .append("[word=").append(word).append(",")
                    .append("level=").append(level).append(",")
                    .append("path=").append(path).append("]")
                    .toString();
        }
    }

    /////////////////////// ========== ////////////////////////

    public static void main(String[] args) {
        WordLadderII wordLadder = new WordLadderII();

        List<String> wordList;
//
        wordList = Arrays.asList(new String [] {"hot","dot","dog","lot","log","cog", "hig","hog"});
        System.out.println("ans is " + wordLadder.findLadders("hit", "cog", wordList));
        System.out.println("mth is [[hit, hot, hog, cog], [hit, hig, hog, cog]]");

        wordList = Arrays.asList(new String [] {"hot","dot","dog","lot","log"});
        System.out.println("ans is " + wordLadder.findLadders("hit", "cog", wordList));
        System.out.println("mth is []");

        wordList = Arrays.asList(new String [] {"hot","dot","dog","lot","log","cog"});
        System.out.println("ans is " + wordLadder.findLadders("hit", "cog", wordList)); // [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
        System.out.println("mth is [[hit, hot, dot, dog, cog], [hit, hot, lot, log, cog]]");

        wordList = Arrays.asList(new String [] {"ted","tex","red","tax","tad","den","rex","pee"});
        System.out.println("ans is " + wordLadder.findLadders("red", "tax", wordList)); // [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
        System.out.println("mth is [[red, ted, tad, tax], [red, ted, tex, tax], [red, rex, tex, tax]]");


        wordList = Arrays.asList(new String [] {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"});
        System.out.println("ans is " + wordLadder.findLadders("cet", "ism", wordList));

    }
}
