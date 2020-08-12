import java.util.Arrays;
import java.util.Random;

/**
 * @author schandna created on 16/04/20
 */
public class ReservoirSampling {

    // A function to randomly select k items from stream[0..n-1].
    static void selectKItems(int stream[], int n, int k)
    {
        int i;   // index for elements in stream[]

        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        int reservoir[] = new int[k];
        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random r = new Random();

        // Iterate from the (k+1)th element to nth element
        for (; i < n; i++)
        {
            // Pick a random index from 0 to i.
            int j = r.nextInt(i + 1);

            // If the randomly  picked index is smaller than k,
            // then replace the element present at the index
            // with new element from stream
            if(j < k)
                reservoir[j] = stream[i];
        }

        System.out.println("Following are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
    }

    //Driver Program to test above method
    public static void main(String[] args) {
//        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int stream[] = { -1, 4, 9, 7, 7, 2, 7, 3, 0, 9, 6, 5,
                7, 8, 9 };
        int n = stream.length;
        int k = 1;
        selectKItems(stream, n, k);
    }

//    // Driver code
//    public static void main(String[] args)
//    {
//        // input array
//        int arr[] = { -1, 4, 9, 7, 7, 2, 7, 3, 0, 9, 6, 5,
//                7, 8, 9 };
//        int n = arr.length;
//        findRandomIndexOfMax(arr, n);
//    }
}

// METHOD 3 (Using Moore’s Voting Algorithm):
class MajorityElement
{
    /* Function to print Majority Element */
    void printMajority(int a[], int size)
    {
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size);

        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }

    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++)
        {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++)
        {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }

    /* Driver program to test the above functions */
    public static void main(String[] args)
    {
        MajorityElement majorelement = new MajorityElement();
        int a[] = new int[]{1, 3, 3, 1, 2};
        int size = a.length;
        majorelement.printMajority(a, size);
    }
}
