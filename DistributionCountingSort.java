/**
Name: Caitlin Harris
Date: 9/15/2019
Title: DistributionCountingSort.java
Description: This program sorts a text file of integers using the
distribution sort algorithm
**/

import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class DistributionCountingSort{
  public static void main(String[]args) throws FileNotFoundException{

    //CLA total # of ints, text path, minimum int value, maximum int value
    int total= Integer.parseInt(args[0]);
    String path= args[1];
    int min= Integer.parseInt(args[2]);
    int max= Integer.parseInt(args[3]);

    //Scanner & file objects
    File file = new File(path);
    Scanner in = new Scanner(file);

    //Unsorted array
    int [] ary1 = new int [total];
    //Sorted array
    int [] ary2 = new int [ary1.length];

    //Read in ints from text file
    for(int i = 0; i<ary1.length;i++){
      if(in.hasNextLine()){
        ary1[i]=in.nextInt();
      }
    }
    //Close scanner object
    in.close();

    //Print unsorted array
    //System.out.println(Arrays.toString(ary1));

    //Create sort object and save sorted array
    DistributionCountingSort sort1 = new DistributionCountingSort();
    ary2 = sort1.sort(ary1, max);

    //Print the sorted array, one int per line
    for(int c=0; c<ary2.length; c++){
    System.out.println(ary2[c]);
    }

  }

  public int[] sort(int [] ary1, int max){
//Count & Sorted arrays
  int [] COUNT = new int[max + 1];
  int [] ary2 = new int[ary1.length];
//Sum & num variables
  int sum = 0;
  int num;

  //initialize all values in count array to zero
  for(int k=0; k<COUNT.length; k++){
    COUNT[k]=0;
  }

  //Add 1 to each index of COUNT each time a corresponding int occurs in ary1
  for(int i=0; i<ary1.length; i++){
  num = ary1[i];
  COUNT[num]++;
  }

  //Add the sum of the preceding element to the next element
  for(int j=0; j< COUNT.length; j++){
  sum += COUNT[j];
  COUNT[j] = sum;
  }

  /*Starting at the last element in ary1, use COUNT to place the int in
  the right index, subtract 1 from COUNT value each time*/
  for (int m = ary2.length-1; m >=0; m--){
  int num2 = ary1[m];
  int temp = COUNT[num2];
  ary2[temp-1]=ary1[m];
  COUNT[num2]--;
  }
  //return sorted array
  return ary2;
  }
}
