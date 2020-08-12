import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author schandna created on 21/07/20
 */
public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        int size = 0;
        boolean flag = false;
        for(int i = 0; i < N; i++){
            int[] nextState = new int[8];
            for(int j = 1; j < 7; j++){
                nextState[j] = (cells[j - 1] == cells[j + 1] ? 1 : 0);
            }
            String s = Arrays.toString(nextState);
            if(!set.contains(s)){
                set.add(s);
                size++;
            }
            else{
                flag = true;
                break;
            }
            cells = nextState;
        }
        if(flag){
            N = N % size;
            for(int i = 0; i < N; i++){
                int[] nextState = new int[8];
                for(int j = 1; j < 7; j++){
                    nextState[j] = (cells[j - 1] == cells[j + 1] ? 1 : 0);
                }
                cells = nextState;
            }
        }

        return cells;
    }

    public int[] prisonAfterNDays4cell(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        int size = 0;
        boolean flag = false;
        for(int i = 0; i < N; i++){
            int[] nextState = new int[4];
            for(int j = 1; j < 3; j++){
                nextState[j] = (cells[j - 1] == cells[j + 1] ? 1 : 0);
            }
            String s = Arrays.toString(nextState);
            if(!set.contains(s)){
                set.add(s);
                size++;
            }
            else{
                flag = true;
                break;
            }
            cells = nextState;
        }
        if(flag){
            N = N % size;
            for(int i = 0; i < N; i++){
                int[] nextState = new int[4];
                for(int j = 1; j < 3; j++){
                    nextState[j] = (cells[j - 1] == cells[j + 1] ? 1 : 0);
                }
                cells = nextState;
            }
        }

        return cells;
    }

    public static void main(String[] args) {
        PrisonCellsAfterNDays prison = new PrisonCellsAfterNDays();
        System.out.println(prison.prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 245)); // Day 2: [0, 0, 0, 0, 1, 1, 1, 0]

//        System.out.println(prison.prisonAfterNDays4cell(new int[] {0,1,0,1}, 5));
    }
}
