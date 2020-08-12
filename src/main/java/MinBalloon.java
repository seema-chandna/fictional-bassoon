import java.util.Arrays;
import java.util.Comparator;

/**
 * @author schandna created on 22/03/20
 */
public class MinBalloon {

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}} ;

        System.out.println(findMinArrowShots(points));

        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}} ;
        System.out.println(findMinArrowShots(points2));
    }

    public int findMinArrowShots14ms(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a,b) -> a[1]-b[1]);
//        Arrays.sort(points, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] a, int[] b){
//                return a[1] - b[1];
//            }
//        });
        int count = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++){
            if (points[i][0] <= end){
                continue;
            }
            count++;
            end = points[i][1];
        }
        return count;
    }

    public static int findMinArrowShots(int[][] points) {

        int count = 0;

        if (points == null) {
            return count;
        }
        if (points.length <=1) {
            return points.length;
        }

        sortbyColumn(points, 0);

        int min;
        for (int i = 0; i< points.length ; i++) {

            min = points[i][1];

            if(min>=points[i][0]) {
                while(i < points.length && min>=points[i][0]) {
                    if(points[i][1] < min) {
                        min = points[i][1];
                    }
                    i++;
                }
                i--;
            }

            count++;
        }
        return count;
    }

    // Function to sort by column
    public static void sortbyColumn(int arr[][], int col) {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }


    public static int findMinArrowShots2(int[][] points) {

        int count = 0;

        if (points == null) {
            return count;
        }
        if (points.length <=1) {
            return points.length;
        }

        sortbyColumn(points, 0);

        int l = points[0][0];
        int r = points[0][1];

        int min = r;
        for (int i = 0; i< points.length ; i++) {

            if(min>=points[i][0]) {

                while(i < points.length && min>=points[i][0]) {
                    if(points[i][1] < min) {
                        min = points[i][1];
                    }
                    i++;
                }

                i--;
                if(i+1 < points.length){
                    min = points[i+1][1];
                }
            } else {

                min = points[i][1];
            }

            count++;

//            if(min >= points[i][0] && min <= points[i][1]){
//                count++;
//            } else {
//                min = points[i+1][1];
//            }
        }

        return count;
    }

    public static int findMinArrowShots1(int[][] points) {

        int count = 0;

        if (points == null) {
            return count;
        }
        if (points.length <=1) {
            return points.length;
        }

        sortbyColumn(points, 0);

        int l = points[0][0];
        int r = points[0][1];

        int min = r;
        for (int i = 1; i< points.length ; i++) {

            boolean flag = false;
            while(i < points.length && min>=points[i][0]) {
                flag = true;
                if(points[i][1] < min) {
                    min = points[i][1];
                }
                i++;
            }

            if(flag){
                count++;
                i--;
            }

            count++;

            if(i+1 < points.length){
                min = points[i+1][1];
            }

//            if(min >= points[i][0] && min <= points[i][1]){
//                count++;
//            } else {
//                min = points[i+1][1];
//            }
        }

        return count;
    }




}
