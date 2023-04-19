
/*
    Suppose you have an array of integers 'arr', and you want to find the length of the longest increasing
    subsequence (LIS) in the array. An increasing subsequence is a sequence of elements in the array that are in increasing order, but
    not necessarily consecutive.

    For example if arr=[10, 9, 2, 5, 3, 7, 101, 18] then the length of the longest increasing subsequence is 4, which can be achieved
    by selecting subsequence [2, 3, 7, 101].

    Write a dynamic programming solution to find the length of the longest increasing subsequence in the array.
 */


import java.util.ArrayList;


public class Main {
    public static ArrayList<Integer> getLIS(ArrayList<Integer> arr, ArrayList<Integer> result){

        if(arr.get(arr.size() - 1) > arr.get(arr.size() - 2)  && result.size() == 0){
            result.add(arr.get(arr.size() - 1));
            result.add(arr.get(arr.size() - 2));
        }

        else if(arr.get(arr.size() - 1) > arr.get(arr.size() - 2) &&  result.size() != 0 && arr.get(arr.size() - 2) < result.get(result.size() - 1)){
            result.add(arr.get(arr.size() - 2));
        }

        if(arr.size() == 2){
            return result;
        }

        arr.remove(arr.size() -1 );
        result = getLIS(arr, result);

        return result;
    }

    public static int getResult(ArrayList<Integer> arr, ArrayList<Integer> result){
        return getLIS( arr,  result).size();
    }



    public static void main(String[] args) {

       ArrayList<Integer> arr = new ArrayList<>();
       arr.add(10);
        arr.add(1);
        arr.add(97);
        arr.add(107);
        arr.add(7);
        arr.add(101);
        arr.add(18);

        System.out.printf(" " + getResult(arr, new ArrayList<>()));

    }


}
