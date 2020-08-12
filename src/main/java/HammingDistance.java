/**
 * @author schandna created on 22/03/20
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {

        int xor = x;
        xor = xor ^ y;

        int count = 0;

        while (xor > 0) {
            count += xor & 1;
            xor >>= 1;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4)); // 2

    }
}
