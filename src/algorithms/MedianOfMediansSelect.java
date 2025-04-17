package algorithms;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.swap;

public class MedianOfMediansSelect {

    public static int MedSelect(int[] a, int k){    //returns kth smallest in a
        if (a.length<= 5){ //just sort and return kth
            return MergeSelect.MSelect(a, k);
        }else {
            return MedSelector(a, 0, a.length - 1, k);
        }
    }

    public static int MedSelector(int[] a, int left, int right, int k){
        if (left==right) return a[left];

        //divide into 5
        int pivot = medianofmedians(a, left, right);
        int pivotIndex = 0;
        while (pivotIndex < right && a[pivotIndex]!= pivot){
            pivotIndex++;
        }

        swap(a, pivotIndex, right); //place pivot


        pivotIndex = PartitionSelect.partition(a, left, right);

        if (pivotIndex == k-1){
            return a[pivotIndex];
        }else if (k-1 < pivotIndex){
            return MedSelector(a, left, pivotIndex-1, k);
        }else{
            return MedSelector(a, pivotIndex+1, right, k);
        }
    }

    private static int medianofmedians(int[] a, int left, int right) { //returns value of pivot
        int n = right - left + 1;

        int num = (int) Math.ceil(n/5.0);
        int[] meds = new int[num]; //array to hold medians


        int i=0;
        for (; i< n/5; i++){ //populating median array with median of groups
            int start = left + i * 5;
            meds[i] = findMedian(a, start, 5);
        }

        if (i*5 < n){ // array not even divisible
            int start = left + i * 5;
            int remaining = n - i * 5;
            meds[i] = findMedian(a, start, remaining);
        }

        //medofmeds recursion
        if (meds.length==1) return meds[0];
        return medianofmedians(meds, 0, meds.length-1);
    }

    private static int findMedian(int[] a, int start, int distance) {
        Arrays.sort(a, start, start+distance);
        return a[start + distance / 2]; //return median after sorting
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
