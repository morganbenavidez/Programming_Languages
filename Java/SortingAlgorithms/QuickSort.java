/**
 * @author Morgan Benavidez
 */
public class QuickSort {
    
    // Create function quickSort
    public static void quickSort(int quickArray[], int start, int end){
        
        // Create Partition
        int partition = partition(quickArray, start, end);
        
        // Recursively calling the quickSort function to the left of the partition.
        if(partition-1 > start) {
            quickSort(quickArray, start, partition-1);
        }
        
        // Recursively calling the quickSort function to the right of the partition.
        if(partition+1 < end) {
            quickSort(quickArray, partition + 1, end);
        }
    }
    
    // Create function partition
    public static int partition(int quickArray[], int start, int end){
        
        // Create a pivot
        int pivot = quickArray[end];
        
        // Loop through the partition to compare and sort with pivot
        for(int i = start; i < end; i++){
            
            if(quickArray[i] < pivot){
                int placeHolder = quickArray[start];
                quickArray[start] = quickArray[i];
                quickArray[i] = placeHolder;
                start++;
            }
        }
        
        int placeHolder = quickArray[start];
        quickArray[start] = pivot;
        quickArray[end] = placeHolder;
        
        return start;
    }

    
}
