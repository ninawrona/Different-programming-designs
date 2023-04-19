import java.util.ArrayList;
import java.util.List;

public class DivideAndConquer {

    // Function to find the maximum no.
    // in a given array.
    public static int DivideAndConquer(int[] arr, int index, int l){

        int max;

        if(l-1 == 0){
            return arr[index];
        }
        if( index >= l-2){
            if(arr[index] > arr[index + 1]){
                return arr[index];
            }
            else{
                return arr[index+1];
            }
        }

        // Logic to find the Maximum element
        // in the given array.
        max = DivideAndConquer(arr, index+1, l);
        if(arr[index] > max){
            return arr[index];
        }
        else{
            return max;
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 5, 3, 76, 32, 3};
        int result = DivideAndConquer(list, 0, list.length-1);

        System.out.printf("Result: " + result);
    }
}
