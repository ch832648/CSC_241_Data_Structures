/*
NAME: Caitlin Harris
PROGRAM: CountingSort.java
SUMMARY: Counting Sort Algorithm
*/


import java.util.Arrays;

public class CountingSort{
  public static void main(String [] args){
  System.out.println("This is counting sort");

  int [] unsorted= {14,23,5,67,1,54,121,8,12};

  for(int i=0;i<unsorted.length;i++){
    System.out.print(unsorted[i] + " ");
    }
System.out.println("");

  int [] sorted= sorted(unsorted);

  for(int i=0;i<sorted.length;i++){
  System.out.print(sorted[i] + " ");
  }
  System.out.println("");
}

public static int [] sorted(int[] unsorted){
int [] sorted = unsorted;
int [] COUNT = new int[unsorted.length];

//C1
for(int i=0;i<COUNT.length;i++){
COUNT[i] = 0;
  }
//C2
for(int i = COUNT.length-1; i>= 1; i--){
//C3
  for(int j = i - 1; j >= 0; j--){
    //C4
    if(unsorted[i] < unsorted[j]){
      COUNT[j]++;
      }
    else{
      COUNT[i]++;
    }

  }

}

  return sorted;

  }
}
