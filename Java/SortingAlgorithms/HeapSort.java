import java.util.Arrays;
/**
 * @author Morgan Benavidez
 */
public class HeapSort {
    
    public void heapSort(int heapArray[]){
        int heapArrayLength = heapArray.length; 
        
        //Here we build a heap (re-arrange the array)
        
        for (int i = heapArrayLength/2 - 1; i >= 0; i--){
            heapify(heapArray, heapArrayLength, i);
        }
        
        /*One at a time, extract the MAXIMUM element from heap 
            and replace it with the last element in the heapArray
        */
        
        for (int i = heapArrayLength-1; i>=0; i--){
            
            //heapArray[0] is the root of the array and therefore the max element.
            
            int root = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = root;
            
            /* Call max heapify on the heap with the last item of the aray now 
                at the root.
            */
            
            heapify(heapArray, i, 0);
        }
    }
    
    // This is where we create the heapify function, to heapify a subtree with node i
    
    void heapify(int heapArray[], int heapArrayLength, int i){
        
        int largest = i; // Initialize largest as root
        int leftChildIndex = (2*i) + 1; // Left = (2*i) + 1
        int rightChildIndex = (2*i) + 2; // Right = (2*i) + 2
        
        // If left child is larger than root
        
        if ((leftChildIndex < heapArrayLength) && heapArray[leftChildIndex] > heapArray[largest])
            largest = leftChildIndex;
        
        // If right child is larger than largest so far
        
        if ((rightChildIndex < heapArrayLength) && heapArray[rightChildIndex] > heapArray[largest])
            largest = rightChildIndex;
        
        // If largest is not the root
        
        if (largest != i) {
            
            int placeHolder = heapArray[i];
            heapArray[i] = heapArray[largest];
            heapArray[largest] = placeHolder;
            
            // Recursive heapify call to heapify the sub-tree
            
            heapify(heapArray, heapArrayLength, largest);
            
        }
        
    }
}
