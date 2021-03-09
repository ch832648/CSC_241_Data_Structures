/**
Name: Caitlin Harris
Date: 9/15/2019
Title: InsertionSort.java
Description: This program sorts a text file of Strings using the
insertion sort algorithm
**/

import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class InsertionSort{
   public static void main(String args[]) throws FileNotFoundException {


     //CLA the num of strings & text path
     //Number of Strings in file && Path to the textfile
       int num = Integer.parseInt(args[0]);
       String path = args[1];

      //File & Scanner objects
      File file = new File(path);
      Scanner in = new Scanner(file);

      //String arrays & variables
      String ary[] = new String [num];
      //String key;

      //read string from text file into unsorted array
      for(int i=0;i<ary.length;i++){
         if(in.hasNextLine()){
           ary[i]=in.nextLine();
         }
      }

      InsertionSort sort1 = new InsertionSort();
      String [] sorted = new String[ary.length];
      sorted = sort1.sort(ary);

      //print sorted array
      for(int k=0;k<ary.length;k++){
        System.out.println(ary[k]);
      }

   }

   public String [] sort(String [] ary){
     String key;
     //insertion algorithm
     for(int j=1;j<ary.length;j++){
        key = ary[j];
        int i = j-1;

        while(i>=0){
           if(key.compareTo(ary[i]) >= 0){
              break;
           }
           ary[i + 1] = ary[i];
           i--;
        }
        ary[i + 1] = key;
     }
    return ary;
   }

}
