/**
Name: Caitlin Harris
Date: 10/20/2019
Title: DualPivotQuickSort.java
Description: This program sorts a text file of integers using the
dual pivot quick sort algorithm
**/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class DualPivotQuickSort {
  public static void main (String[]args) throws FileNotFoundException{

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
    //int [] ary = {13,19,9,5,12,8,7,4,11,2,6,21};
    //Put array list into for loop
    for(int i=0; i<temp.size(); i++){
      ary[i]=temp.get(i);
    }
    //Print original Array
    //printAry(ary);
    //System.out.println(Arrays.toString(ary));

    DualPivotQuickSort b = new DualPivotQuickSort();
    b.Sort(ary, 0, ary.length-1);
    //Print Array
    printAry(ary);
    //System.out.println(Arrays.toString(ary));


  }

  public static void Sort (int[] A, int left, int right){
    //System.out.println(Arrays.toString(A));

    //Dual Pick Quicksort Yaroslaskiy
    int temp = 0;

    if(right-left >= 1){
      //Print statement for checking
      int p = A[left];
      int q = A[right];
      if(p < q){
        temp = q;
        q = p;
        p = temp;

        temp = A[left];
        A[left] = A[right];
        A[right] = temp;
      }

      int l = left + 1;
      int g = right - 1;
      int k = l;

      while(k <= g){
        if(A[k] > p){
          temp = A[k];
          A[k] = A[l];
          A[l] = temp;
          l = l + 1;
        }
        else {
          if(A[k] < q){

            while(A[g] < q && k < g){
              g = g - 1;
            }

            temp = A[k];
            A[k] = A[g];
            A[g] = temp;
            g = g - 1;

            if(A[k] > p){
              temp = A[k];
              A[k] = A[l];
              A[l]=temp;
              l = l + 1;
            }
          }
        }
        k = k + 1;
      }
      l = l - 1;
      g = g + 1;

      temp = A[left];
      A[left] = A[l];
      A[l] = temp;

      temp = A[right];
      A[right] = A[g];
      A[g] = temp;

//System.out.println(Arrays.toString(A));

      Sort(A, left, l-1);
      Sort(A, l+1, g-1);
      Sort(A, g+1, right);

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
