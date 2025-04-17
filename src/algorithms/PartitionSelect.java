package algorithms;

import java.util.Arrays;

public class PartitionSelect {

    public static int PSelect(int[] a, int k){ //returns kth smallest in a

        return PSelecter(a, 0, a.length-1, k);
    }

    private static int PSelecter(int[] a, int left, int right, int k) {
        if (left==right) { return a[left];}

        int pivot_index = partition(a, left, right);

        if (pivot_index == k-1) {
//            System.out.println(Arrays.toString(a));
            return a[pivot_index];
        }else if (k-1<pivot_index) {
//            System.out.println("going from "+left+" to "+(pivot_index-1));
            return PSelecter(a, left, pivot_index-1, k);
        }else{ // k is bigger than pivot_index
//            System.out.println("going from "+(pivot_index+1)+" to "+right);
            return PSelecter(a, pivot_index+1, right, k);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[right];
//        System.out.println("pivot chosen: "+pivot);
        int pivot_location = left;
        //moving lesser values left of pivot
        for (int i = left; i < right; i++) {
            if (a[i] < pivot){
                int temp = a[i];
                a[i] = a[pivot_location];
                a[pivot_location] = temp;
                pivot_location++;
            }
        }
//        System.out.println("partitioned: "+Arrays.toString(a));
        //swapping pivot back to position
        int temp = a[right];
        a[right] = a[pivot_location];
        a[pivot_location] = temp;

        return pivot_location;
    }
}
