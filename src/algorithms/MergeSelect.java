package algorithms;
import java.util.Arrays;

public class MergeSelect {

    public static int MSelect(int[] a, int k){ //return kth smallest in a
        MSort(a);
        return a[k-1];
    }

    public static void MSort(int[] a) {  //merge sort for array
        if (a.length < 2) return; //base case
        int mid = a.length/2;  //mid point

        int[] left = Arrays.copyOfRange(a, 0, mid);     //array of left side
        int[] right = Arrays.copyOfRange(a, mid, a.length);    //array of right side

        MSort(left); //recursively sort left
        MSort(right);   //recursively sort right
        merge(a, left, right);  //merge them together
    }

    private static void merge(int[] a, int[] left, int[] right) { //merge left and right into a
        int i=0; //left index
        int j=0; //right index
        int k=0; //a index

        while (i < left.length && j < right.length) {
            a[k++] = (left[i] <= right[j]) ? left[i++] : right[j++]; //add smaller values in order to a and increment
        }

        //leftovers from either array
        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }

    }
}
