/**
 * @author schandna created on 14/07/20
 */
public class ReachingPoints {

    /*

When given target pair (tx, ty), we can conclude that the previous result is (tx - ty, tx) if tx > ty or (ty - tx, ty) if tx < ty.
Based on this idea, we can retrieve the result backwards from the final result.

If any of tx or ty equal to the initial sx or sy, we can just check is the difference of the other the multiplier of the initial value.

To optimize our code, we can to consider the case when tx >> ty or ty >> tx. That's why we do the module operation to avoid too many repeatitve subtration.

Example
sx=1, sy=1, tx=2, ty=100000000
If we recursively computing the tx and ty:
(2, 99999998), (2, 99999996) ... (2 , 2), (2, 0).
But this takes way too many steps. With the help of %, it can be simplified as
(2, 100000000), (2, 0)

class Solution:
def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
    if sx > tx or sy > ty:
        return False
    if sx == tx: return (ty - sy) % sx == 0
    if sy == ty: return (tx - sx) % sy == 0
    if tx > ty:
        tx %= ty
    else:
        ty %= tx
    return self.reachingPoints(sx, sy, tx, ty)

*/
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx) {
            return ty >= sy && (ty - sy) % tx == 0;
        }

        if (sy == ty) {
            return tx >= sx && (tx - sx) % ty == 0;
        }

        if (sx >= tx || sy >= ty) {
            return false;
        }

        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }

    public boolean reachingPointsRec(int sx, int sy, int tx, int ty) {

        if(sx==tx && sy==ty){
            return true;
        }

        if(sx>tx || sy>ty){
            return false;
        }

        return reachingPoints(sx+sy, sy, tx, ty) || reachingPoints(sx, sx+sy, tx, ty);
    }

    public static void main(String[] args) {
        ReachingPoints rp = new ReachingPoints();
//        System.out.println(rp.reachingPoints(1,1,3,5)); // True
//        System.out.println(rp.reachingPoints(35, 13,455955547,420098884));
        System.out.println(rp.reachingPoints(2, 2,4,100000000));


    }
}
