import java.util.Arrays;
/**
 *
 * @author Morgan Benavidez
 */
public class CountingSort {
    /*public static void main(String[] args){
        System.out.println("Counting Sort");
        int[] input = {10, 9, 8, 8, 13, 12, 3, 5, 4};
        int k = 13;
        countingSort(input, k);
        System.out.println(Arrays.toString(input));
    }*/
    public static void countingSort(int[] input, int k)
    {
        //create buckets
        int counter [] = new int[k + 1];
        
        //fill buckets
        for(int i : input) {
            counter[i]++;
        }
        
        //sort array
        int ndx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (0 < counter[i]) {
                input[ndx++] = i;
                counter[i]--;
            }
    }
}

}
