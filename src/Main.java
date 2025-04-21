import java.util.Arrays;
import algorithms.MedianOfMediansSelect;
import algorithms.MergeSelect;
import algorithms.PartitionSelect;
import utils.ArrayGenerator;
import utils.FileHandler;
import utils.Timer;



public class Main {

    public static void main(String[] args){

        int[] test = {25, 18, 22, 20, 24};
//        System.out.println("Merge select result: "+MergeSelect.MSelect(test, 2));
//        System.out.println("Partition select result: "+PartitionSelect.PSelect(test, 2));
        System.out.println("Median of Median select result: "+MedianOfMediansSelect.MedSelect(test, 2));
    }

    public static void TestSelect(){
        int num_of_tests = 10;
        int array_size = 2; //subject to change

        //generate array
        int[] arr = ArrayGenerator.generateArray(array_size);
        int kth = 1; //placeholder

        //save array to file
        FileHandler.saveResults("data/input_arrays.txt", "Test: \n"+Arrays.toString(arr)+"\n");

        //Testing Speed
        for (int i=0; i<num_of_tests; i++){

            Timer timer = new Timer();

            //test merge select algorithm
            timer.start();
            int resultMerge = MergeSelect.MSelect(arr, kth);
            timer.stop();
            long timeMerge = timer.getElapsedTime();
            FileHandler.saveResults("data/results.txt", "Test " + (i+1) + " Merge Select: " + timeMerge + "ms");

            //test partition select algorithm
            timer.start();
            int resultPartition = PartitionSelect.PSelect(arr, kth);
            timer.stop();
            long timePartition = timer.getElapsedTime();
            FileHandler.saveResults("data/results.txt", "Test " + (i+1) + " Partition Select: " + timePartition + "ms");


            //test median of medians algorithm
            timer.start();
            int resultMedian = MedianOfMediansSelect.MedSelect(arr, kth);
            timer.stop();
            long timeMedian = timer.getElapsedTime();
            FileHandler.saveResults("data/results.txt", "Test " + (i+1) + " Median Select: " + timeMedian + "ms");


            System.out.println("Test "+(i+1)+ " completed.");
        }
    }
}
