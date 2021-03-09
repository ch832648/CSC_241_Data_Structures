/**
Name: Caitlin Harris
Date: 10/3/2019
Title: SelectionSort.java
Description: This program sorts a text file of integers using the
selection sort algorithm
**/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class SelectionSort{
  public static void main (String [] args) throws FileNotFoundException{
    //CLA the path to the text file to be sorted
    String path = args[0];
    int nums = 0;
    //Create an Array List to temporarily store file integers
    ArrayList <Integer> temp = new ArrayList<>();
    //Scanner & File objects
    File file = new File(path);
    Scanner in = new Scanner(file);

    //Input integers from text file to array list
    while(in.hasNextInt()){
      temp.add(in.nextInt());
      nums++;
    }

    //Put integers from array list into array
    int[] ary = new int[nums];
    for(int i=0; i<temp.size(); i++){
      ary[i]=temp.get(i);
    }

    //Test Arrays Contents
    //System.out.println(Arrays.toString(ary));

//Create SelectionSort object, sort array and store in sorted
SelectionSort sort1 = new SelectionSort();
int sorted[]=new int [ary.length];
sorted = sort1.sort(ary);

    //Print out sorted array
    for(int k=0; k<ary.length; k++){
      System.out.println(ary[k]);
    }
  }

  public int [] sort(int [] ary){
    //Selection Sort algorithm
    int n = ary.length;
        for (int i = 0; i < n-1; i++) {
        // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (ary[j] < ary[min])
                    min = j;
            }
            // Swap the found minimum element with the first element
            int temp2 = ary[min];
            ary[min] = ary[i];
            ary[i] = temp2;
        }
   return ary;
  }

}
