import java.util.Arrays;
/**
 *
 * @author Morgan Benavidez Seat # 7 
 */

//InsertionSort
public class InsertionSort {
    public void insertionSort(int[] list){
        int i,j,key,temp;
        for (i =1; i< list.length; i++){
            key = list[i];
            j = i-1;
            while (j >= 0 && key < list[j]){
                //swap
                temp = list[j];
                list[j] = list[j+1];
                list[j+1] = temp;
                j--;
            }
        }
    }
}
