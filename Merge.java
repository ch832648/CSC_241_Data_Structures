/**
Name: Caitlin Harris
Date: 11/10/2019
Title: Merge.java
Description: This program sorts 2 text files of integers using the
Merge sort algorithm
**/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class Merge{
  public static void main(String [] args) throws FileNotFoundException {
    //CLA the text files we are reading from
    File file1 = new File(args[0]);
    File file2 = new File(args[1]);

    //Integer Array List to store the text files
    ArrayList<Integer> temp = new ArrayList<Integer>();

    //Scanner objects
    Scanner in1 = new Scanner(file1);
    Scanner in2 = new Scanner(file2);

    //Scan in file1, put into ary1
    while(in1.hasNextInt()){
      temp.add(in1.nextInt());
    }
    int [] ary1 = new int[temp.size()];
    for(int i=0; i<ary1.length; i++){
      ary1[i] = temp.get(i);
    }

    //Clear the temporary array List
    temp.clear();

    //Scan in file2, put into ary2
    while(in2.hasNextInt()){
      temp.add(in2.nextInt());
    }
    int [] ary2 = new int[temp.size()];
    for(int i=0; i<ary2.length; i++){
      ary2[i] = temp.get(i);
    }
    //Clear the temporary array List
    temp.clear();

    //System.out.println(file1);
    //System.out.println(file2);

    //System.out.println("This is Ary1: " + Arrays.toString(ary1));
    //System.out.println("This is Ary2: " + Arrays.toString(ary2));

    //Sort array 1 and array 2 using insertion sort
    InsertionSort(ary1);
    InsertionSort(ary2);
    //Length of the new merged array
    int mergedLength = ary1.length + ary2.length-1;
    //Create final merged array and call mergeSort
    int [] mergedAry = mergeSort(ary1, ary2);


    //System.out.println("This is sorted Ary1: " + Arrays.toString(ary1));
    //System.out.println("This is sorted Ary2: " + Arrays.toString(ary2));
    //System.out.println("This is sorted MergedAry: " + Arrays.toString(mergedAry));

    //Print Sorted Arrays
    printArys(ary1,ary2,mergedAry);


  }

  public static void InsertionSort(int[] ary){
    for(int j=1; j<ary.length; j++){
      int key = ary[j];
      int i  = j-1;
      while(i>=0 && ary[i]>key){
        ary[i+1] = ary[i];
        i--;
      }
      ary[i+1]=key;
    }
  }

  public static void ReverseSort(int[] ary){
    for (int i = 1; i < ary.length; i++) {
            int key = ary[i];
            int j = i;
            while (j > 0 && ary[j - 1] < key) {
                ary[j] = ary[j - 1];
                j--;
            }
            ary[j] = key;
        }
  }

  public static int[] mergeSort(int[] ary1, int[] ary2) {
    //Create new merged array
    int merged [] = new int[ary1.length + ary2.length];
    //descending array length
    int d = ary2.length - 1;
    //ascending array length
    int a = ary1.length - 1;
    //Sort and merge arrays
    for(int q = 0; q < merged.length; q++) {
      if (d > -1 && a > -1 ) {
        if (ary2[d] > ary1[a]) {
          merged[q] = ary2[d];
          d--;
        }
        else {
          merged[q] = ary1[a];
          a--;
        }
      }
      else if (d <= -1) {
        while (a > -1) {
          merged[q] = ary1[a];
          a--;
          q++;
        }
      }
      else {
        while (d > -1) {
          merged[q] = ary2[d];
          d--;
          q++;
        }
      }
    }
    return merged;
      }


      public static void printArys(int[] ary1, int[] ary2, int[] mergedAry){

        //Print ary1, ascending order
        for(int i=0; i<ary1.length; i++) {
            if(i == ary1.length-1)
              System.out.println(ary1[i] + "");
            else
              System.out.print(ary1[i] + " ");
        }

        //Print ary2, descending order
        for(int j=ary2.length-1; j>=0; j--) {
            if(j == 0)
                System.out.println(ary2[j] + "");
            else
                System.out.print(ary2[j] + " ");
        }

        //Print merged array, descending order
        for(int k=0; k<mergedAry.length; k++) {
            if(k == mergedAry.length-1)
                System.out.println(mergedAry[k] + "");
            else
                System.out.print(mergedAry[k] + " ");
        }
    }
}
