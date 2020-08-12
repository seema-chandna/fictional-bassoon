import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author schandna created on 20/07/20
 */
public class Garage {
    int totalSlots;
    int occSlots=0;
    int slotId=1;
    Map<Integer, Integer> slotsMap = new HashMap<>(); // user, slotId
    PriorityQueue <Pair<Integer, Integer>> alocatedSlots = new PriorityQueue<>((p1, p2) -> p2.getKey() - p1.getKey()); // slotId, user

    Garage( int totalSlots){
        this.totalSlots = totalSlots;
    }

    void parkCar(Integer userId){

        if(occSlots == totalSlots){
            //
        }
        alocatedSlots.add(new Pair(slotId, userId));
        slotsMap.put(userId, slotId++);
        occSlots++;
    }

    void retrieveCar(Integer userId){
        alocatedSlots.remove(slotsMap.get(userId));
        slotsMap.remove(userId);
        occSlots--;
    }

    void compact() {
        for(Integer slot=1; slot<=occSlots; slot++) {
            if(slotsMap.get(slot) == null) {
                Pair topUserId = alocatedSlots.remove();
                alocatedSlots.add(new Pair<Integer, Integer>(slot, (Integer)topUserId.getValue()));
                slotsMap.put((Integer)topUserId.getValue(), slot);
            }
        }
        slotId = occSlots;
    }

// 1 2 3 4 5
// X X X X X
// - X - X X
// 5 4 2

    public static void main(String[] args) {

        Garage gar = new Garage(10);
        gar.parkCar(1);
        gar.parkCar(2);
        gar.parkCar(3);
        gar.parkCar(4);
        gar.parkCar(5);
        System.out.println(gar.slotsMap);

        gar.retrieveCar(1);
        gar.retrieveCar(3);

        System.out.println(gar.slotsMap);
        gar.compact();

        System.out.println(gar.slotsMap);
    }

}
