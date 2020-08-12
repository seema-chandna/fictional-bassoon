/**
 * @author schandna created on 22/03/20
 */
public class NimGame {


    /*
    You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

Example:

Input: 4
Output: false
Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be
             removed by your friend.
     */
    public static boolean canWinNim(int n) {

        if (n==4 || (n%4 ==0)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(-4 % 3);
        System.out.println(((-4 % 3)+3)%3);

//        System.out.println("canWinNim - " + canWinNim(4)); // false
//        System.out.println("canWinNim - " + canWinNim(1)); // true

//        int leftShifts = Math.floorMod(43, 8); // 3
//        System.out.println(leftShifts);
//
//        leftShifts = Math.floorMod(-43, 8); // 5
//        System.out.println(leftShifts);
    }


}


class Solution {

    public boolean checkRecord(String s) {

        int countA=0;
        int len =  s.length();

        for (int i=0; i< len; i++) {

            if (s.charAt(i) == 'A') {
                countA++;
                if (countA >= 2) {
                    return false;
                }

            } else if (s.charAt(i) == 'L' && i+1 < len && s.charAt(i+1) == 'L'
                    && i+2 < len && s.charAt(i+2) == 'L'){
                return false;
            }
        }
        return true;
    }
}
