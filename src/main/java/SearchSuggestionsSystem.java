import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author schandna created on 25/06/20
 */
public class SearchSuggestionsSystem {

    TrieNode root = new TrieNode(' ');
    int count = 3;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();
        for(String word : products){
            addWord(word);
        }

        for (int i=0; i<searchWord.length(); i++){
            count = 3;
            result.add(searchWords(searchWord.substring(0, i+1)));
        }
        return result;
    }

    public void addWord(String word) {
        TrieNode pChild = root;
        int n = word.length();

        for(int i =0; i<n; i++) {

            int index = word.charAt(i) - 'a';
            if(pChild.child[index] == null){
                pChild.child[index] = new TrieNode(word.charAt(i));
            }

            pChild = pChild.child[index];
        }

        pChild.leaf = true;
    }

    public List<String> searchWords(String word) {
        List<String> res = new ArrayList<>();
        int n = word.length();

        TrieNode pChild = root;
        String r = new String (word);
        for(int i=0; i<n; i++) {
            int index = word.charAt(i) - 'a';
            if(pChild.child[index] != null) {
                pChild = pChild.child[index];
            } else {
                return res;
            }
        }

        getMatchingWords(pChild, word.substring(0, n-1), res);

        return res;
    }

    public void getMatchingWords(TrieNode pChild1, String start, List<String> res){

        if(pChild1.leaf && count > 0){
            count--;
            res.add(start + pChild1.val);
        }

        if (count == 0){
            return;
        }

        for (int k = 0; k < 26; k++) {
            if (pChild1.child[k]!=null) {
                getMatchingWords(pChild1.child[k], start + pChild1.val, res);
            }
        }
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem sss = new SearchSuggestionsSystem();

//        sss.suggestedProducts(new String [] {"mobile","mouse","moneypot","monitor","mousepad"},  "mouse");
//        sss.suggestedProducts(new String [] {"mobile","mouse","moneypot","monitor","mousepad"},  "mat");

        sss.suggestedProducts(new String [] {"mobile","mouse","moneypot","monitor","mousepad"},  "cat");
    }
}

class TrieNode {
    char val;
    boolean leaf;
    TrieNode[] child = new TrieNode[26];

    public TrieNode(char val) {
        this.val = val;
        leaf = false;
        for(int i=0; i<26; i++){
            child[i] = null;
        }
    }
}

class SolutionTrieDfs {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> returnList = new ArrayList<>();
        Trie t = new Trie();
        for(String product : products) {
            t.insert(product);
        }

        for(int i = 0; i < searchWord.length(); i++) {
            List<String> matchingWords = t.findWordsByPrefix(searchWord.substring(0, i + 1));
            if(matchingWords.size() > 3) {
                matchingWords = matchingWords.subList(0, 3);
            }
            returnList.add(matchingWords);
        }
        return returnList;
    }
}

class Trie {

    private TrieNode1 root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode1(' ');
    }

    public TrieNode1 getRoot() {
        return root;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode1 tempRoot = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(tempRoot.children[c - 'a'] == null) {
                tempRoot.children[c - 'a'] = new TrieNode1(c);
            }
            tempRoot = tempRoot.children[c - 'a'];
        }
        tempRoot.isWord = true;
        tempRoot.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode1 tempRoot = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(tempRoot.children[c - 'a'] != null) {
                tempRoot = tempRoot.children[c - 'a'];
            } else {
                return false;
            }
        }
        return tempRoot.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode1 tempRoot = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(tempRoot.children[c - 'a'] != null) {
                tempRoot = tempRoot.children[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }

    public List<String> findWordsByPrefix(String word) {
        if(startsWith(word)) {
            List<String> returnList = new ArrayList<>();
            TrieNode1 tempRoot = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(tempRoot.children[c - 'a'] != null) {
                    tempRoot = tempRoot.children[c - 'a'];
                }
            }
            findWordsByPrefixHelper(tempRoot, returnList);
            return returnList;
        }
        return Collections.emptyList();
    }

    public void findWordsByPrefixHelper(TrieNode1 t, List<String> returnList) {
        if(t == null) {
            return;
        }
        if(t.isWord) {
            returnList.add(t.word);
        }

        for (TrieNode1 child : t.children) {
            findWordsByPrefixHelper(child, returnList);
        }
    }

    public void printTries() {
        TrieNode1 tempRoot = root;
        printTries(tempRoot, 0);
    }

    public void printTries(TrieNode1 t, int level) {
        if(t == null) {
            return;
        }
        for (int i = 1; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(t.val);
        for (TrieNode1 child : t.children) {
            printTries(child, level + 1);
        }
    }
}

class TrieNode1 {
    public char val;
    public TrieNode1[] children;
    public boolean isWord;
    public String word;

    TrieNode1() {

    }

    public TrieNode1(char val) {
        this.val = val;
        this.children = new TrieNode1[26];
        this.isWord = false;
        this.word = "";
    }
}

class AnotherSolution1 { // 3ms
    class LinkNode {
        String str;
        LinkNode next;
        LinkNode(String str, LinkNode next) {
            this.str = str;
            this.next = next;
        }
    }

    private LinkNode popMinNode(LinkNode list) {
        if (list == null) {
            return list;
        }

        LinkNode minNode = list;
        LinkNode node = list.next;

        while(node != null) {
            if (node.str.compareTo(minNode.str) < 0) {
                minNode = node;
            }
            node = node.next;
        }

        if (minNode == list) {
            return list;
        }

        String str = minNode.str;
        minNode.str = list.str;
        list.str = str;

        return list;
    }

    private List<String> findMinStrings(int lvl, String searchWord, LinkNode list, List<List<String>> rslts) {
        List<String> rslt = new ArrayList<>();
        rslts.add(rslt);

        if (lvl >= searchWord.length()) {
            while(list != null && rslt.size() < 3) {
                list = popMinNode(list);
                rslt.add(list.str);
                list = list.next;
            }
            return rslt;
        }

        LinkNode[] tbl = new LinkNode[26];
        for (LinkNode node = list; node != null; ) {
            if (lvl >= node.str.length()) {
                rslt.add(node.str);
                node = node.next;
                continue;
            }
            int idx = node.str.charAt(lvl)-'a';
            LinkNode tmp = node.next;
            node.next = tbl[idx];
            tbl[idx] = node;
            node = tmp;
        }

        int sIdx = searchWord.charAt(lvl)-'a';

        for (int i = 0; i < sIdx && rslt.size() < 3; i++) {
            while(tbl[i] != null && rslt.size() < 3) {
                tbl[i] = popMinNode(tbl[i]);
                rslt.add(tbl[i].str);
                tbl[i] = tbl[i].next;
            }
        }

        List<String> strs = findMinStrings(lvl+1, searchWord, tbl[sIdx], rslts);
        for (int i = 0; i < strs.size() && rslt.size() < 3; i++) {
            rslt.add(strs.get(i));
        }

        for (int i = sIdx+1; i < 26 && rslt.size() < 3; i++) {
            while(tbl[i] != null && rslt.size() < 3) {
                tbl[i] = popMinNode(tbl[i]);
                rslt.add(tbl[i].str);
                tbl[i] = tbl[i].next;
            }
        }
        return rslt;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> rslts = new ArrayList<>();

        LinkNode list = null;
        char firstCh = searchWord.charAt(0);

        for (int i = 0; i < products.length; i++) {
            char ch = products[i].charAt(0);
            if (ch == firstCh) {
                list = new LinkNode(products[i], list);
            }
        }

        findMinStrings(1, searchWord, list, rslts);

        return rslts;
    }
}

class AnotherSol2 { // 13ms
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TreeNode root = new TreeNode();
        for (String p : products) {
            insert(p, root);
        }

        return search(searchWord, root);
    }

    class TreeNode {
        TreeNode[] nodes;
        List<String> list;
        public TreeNode() {
            nodes = new TreeNode[26];
            list = new ArrayList<String>();
        }
    }

    public void insert(String word, TreeNode root) {
        TreeNode parent = root;
        for (char c : word.toCharArray()) {
            if (parent.nodes[c - 'a'] == null) {
                parent.nodes[c - 'a'] = new TreeNode();
            }

            parent = parent.nodes[c - 'a'];
            if (parent.list.size() < 3) {
                parent.list.add(word);
            }
        }
    }


    public List<List<String>> search(String word, TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        for (char c : word.toCharArray()) {
            if (root != null) {
                root = root.nodes[c - 'a'];
            }

            res.add(root == null? Arrays.asList() : root.list);
        }

        return res;
    }
}

class AnotherSolution3 { // 6ms
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        int low = 0;
        int high = products.length-1;
        for(int i=0; i<searchWord.length(); i++){
            while((low<=high) && (products[low].length() <= i  || products[low].charAt(i) != searchWord.charAt(i))) low++;
            while((low<=high) && (products[high].length() <= i  || products[high].charAt(i) != searchWord.charAt(i))) high--;
            int min = Math.min(low+2, high);
            ArrayList<String> list = new ArrayList<>();
            for(int j=low; j<=min; j++){
                list.add(products[j]);
            }
            result.add(list);
        }
        return result;
    }
}