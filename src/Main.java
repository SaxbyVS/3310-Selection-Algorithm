import java.util.Arrays;
import algorithms.MedianOfMediansSelect;
import algorithms.MergeSelect;
import algorithms.PartitionSelect;
import utils.ArrayGenerator;
import utils.FileHandler;
import utils.Timer;



public class Main {

    public static void main(String[] args){

       int[] test = {4, 6, 1, 2, 6, 8};
       System.out.println(MedianOfMediansSelect.MedSelect(test, 3));
    }

    public static void TestSelect(){
        int num_of_tests = 10;
        int array_size = 2; //subject to change

        //generate array
        int[] arr = ArrayGenerator.generateArray(array_size);

        //save array to file
        FileHandler.saveResults("data/input_arrays.txt", "Test: \n"+Arrays.toString(arr)+"\n");

        //Testing Speed
        for (int i=0; i<num_of_tests; i++){

            Timer timer = new Timer();

            //test merge select algorithm


            //test partition select algorithm


            //test median of medians algorithm


            System.out.println("Test "+(i+1)+ " completed.");
        }
    }
}
