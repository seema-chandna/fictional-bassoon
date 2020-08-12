/**
 * @author schandna created on 10/04/20
 */
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) { //0 ms

        int s1=0, t1=0;
        int i=S.length()-1, j=T.length()-1;

        while(i>=0 && j>=0) {
            while(i>0 && S.charAt(i) == '#') {
                s1++;
                i--;
            }
            while(s1>0 && i>=0 && S.charAt(i) != '#') {
                i--;
                s1--;
            }

            while(j>0 && T.charAt(j) == '#') {
                t1++;
                j--;
            }
            while(t1>0 && j>=0  && T.charAt(j) != '#'){
                j--;
                t1--;
            }

            if(i>=0 && j>=0 && S.charAt(i) != '#' && T.charAt(j) != '#'){
                if(S.charAt(i) != T.charAt(j)){
                    return false;
                }
                i--;
                j--;
            }
        }

        while(i>=0) {
            while(i>=0 && S.charAt(i) == '#') {
                s1++;
                i--;
            }
            while(s1>0 && i>=0 && S.charAt(i) != '#'){
                i--;
                s1--;
            }
            if(s1==0 && i>=0 && S.charAt(i) != '#'){
                break;
            }
        }

        while (j>=0) {
            while (j>=0 && T.charAt(j) == '#') {
                t1++;
                j--;
            }
            while(t1>0 && j>=0  && T.charAt(j) != '#'){
                j--;
                t1--;
            }
            if(t1==0 && j>=0 && T.charAt(j) != '#'){
                break;
            }
        }

        if (i<0 && j<0) {
            return true;
        } else if (i==0 && j==0 && S.charAt(i) == T.charAt(j)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean status = false ;
//        status = backspaceCompare("a##c", "#a#c");
//        System.out.println(status);
//        System.out.println("backspaceCompare0ms - " + backspaceCompare0ms("a##c", "#a#c"));
//
//        status = backspaceCompare("nzp#o#g", "c##nzp#o#g");
//        System.out.println(status);
        System.out.println("backspaceCompare0ms - " + backspaceCompare0ms("nzp#o#g", "c##nzp#o#g"));

//        status = backspaceCompare("cv##pzk###t##m#p#qb##o##kmenj##zto###", "cv##pzk##b##hmf###t##m#p#qb##r#n#o##kmenj##zto###");
//        System.out.println(status);
//        System.out.println("backspaceCompare0ms - " + backspaceCompare0ms("cv##pzk###t##m#p#qb##o##kmenj##zto###", "cv##pzk##b##hmf###t##m#p#qb##r#n#o##kmenj##zto###"));
//
//        status = backspaceCompare("bxj##tw", "bxj###tw");
//        System.out.println(status);
//        System.out.println("backspaceCompare0ms - " + backspaceCompare0ms("bxj##tw", "bxj###tw"));
//
//        status = backspaceCompare("x#end##outp###twoyc#nj###h#ozx##qy#m##cwjdrmn##wtje###v#r##nhew#k#xh#wsjc##", "j#x#g#end##outp#o###twoyc#l#l#nj###p#h#oa#zx##qyz##m##cwjdci##rmn##wtje###v#rq###nhew#kw##xh#wsjc##");
//        System.out.println(status);
//        System.out.println("backspaceCompare0ms - " + backspaceCompare0ms("x#end##outp###twoyc#nj###h#ozx##qy#m##cwjdrmn##wtje###v#r##nhew#k#xh#wsjc##", "j#x#g#end##outp#o###twoyc#l#l#nj###p#h#oa#zx##qyz##m##cwjdci##rmn##wtje###v#rq###nhew#kw##xh#wsjc##"));
    }

    public static boolean backspaceCompare0ms(String s, String t) { // another 0 ms
        int cntS = 0;
        int cntT=  0;
        int indexS = s.length() - 1;
        int indexT = t.length() - 1;
        while(indexS >= 0 || indexT >= 0){
            //System.out.println(indexS + " " + indexT);
            while(indexS >= 0 && (s.charAt(indexS) == '#' || cntS > 0)){
                if(s.charAt(indexS) == '#')
                    cntS ++;
                else
                    cntS--;
                indexS--;
            }
            while(indexT >= 0 && (t.charAt(indexT) == '#' || cntT > 0)){
                if(t.charAt(indexT) == '#')
                    cntT ++;
                else
                    cntT--;
                indexT--;
            }
            if(indexS == -1 && indexT == -1)
                return true;
            if(indexS == -1 || indexT == -1)
                return false;
            if(s.charAt(indexS) != t.charAt(indexT))
                return false;
            indexS--;
            indexT--;

        }

        return true;
    }

    public boolean backspaceCompareLeet(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
