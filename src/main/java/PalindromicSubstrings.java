import java.util.HashMap;
import java.util.Map;

/**
 * @author schandna created on 05/07/20
 */
public class PalindromicSubstrings {

//    public int countSubstrings(String s) {
//        int count =0;
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//
//        int len = s.length();
//        Map<String, Boolean> map = new HashMap<>();
//        Map<String, Boolean> temp = null;
//        map.put("", true);
//
//
//        for(int i=len-1; i>=0; i++) {
//            int size = map.size();
//            temp = new HashMap<>();
//            for (String key : map.keySet()){
//
//                String newSt = key + s.charAt(i);
//                if(map.containsKey(newSt) && map.get(newSt)){
//                    count ++;
//                } else if(map.get(key)) {
//                    temp.put(newSt, false);
//
//                }
//
//            }
//        }
//
//    }

}
