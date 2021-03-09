/**
Name: Caitlin Harris
Date: 10/9/2019
Title: BubleSort.java
Description: This program sorts a text file of integers using the
bubble sort algorithm
**/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class BubleSort{
  public static void main (String [] args) throws FileNotFoundException{

    //Array List to read in text File
    ArrayList <Integer> temp = new ArrayList<>();
    //CLA the path to text file & create file object
    File file = new File(args[0]);
    //Scanner
    Scanner in = new Scanner(file);
    //Read in File
    while(in.hasNextInt()){
      temp.add(in.nextInt());
    }
    //Array to be sorted
    int[] ary = new int[temp.size()];
    //Put array list into for loop
    for(int i=0; i<temp.size(); i++){
      ary[i]=temp.get(i);
    }

    //Bubble Sort Object, Sort Array, Print Array
    BubleSort b = new BubleSort();
    b.Sort(ary);
    printAry(ary);

    //Test Prints
    //System.out.println(temp);
    //System.out.println(Arrays.toString(ary));
  }

  public static void Sort (int[] ary){
    //Bubble Sort
    int n = ary.length;
    for(int i=0; i <n-1; i++){
      for(int j=0; j< n-i-1; j++){
        if(ary[j] > ary[j+1]){
          //swap ary[j+1] and ary[i]
          int tempNum = ary[j];
          ary[j] = ary[j+1];
          ary[j+1] = tempNum;
        }
      }
    }
  }

  public static void printAry(int [] ary){
    //Print ary, descending order
        for(int i=0; i<ary.length; i++) {
            if(i == ary.length-1)
              System.out.println(ary[i] + "");
            else
              System.out.print(ary[i] + " ");
        }
      }
}
