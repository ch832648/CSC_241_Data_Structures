/**
Name: Caitlin Harris
Date: 11/11/2019
Title: StreamingIntegers.java
Description: This program accepts input from the user
and puts it into a priority queue. The program then sorts
the priority queue in ascending order.
**/
import java.util.*;

public class StreamingIntegers{
  public static void main(String[]args){

//Create Priority Queue
PriorityQueue<Integer> q = new PriorityQueue<Integer>();
//Scanner object
Scanner in = new Scanner(System.in);
//Read in integers from user until "END"
while (true) {

      String s = in.nextLine();
      if (s.compareTo("END") == 0) break;

      else {
        String[] splited = s.split(" ");
        for (String part : splited) {
        q.add(Integer.parseInt(part));
      }
    }
}

    //Print the sorted queue
    while (!q.isEmpty()) {
        Integer i = q.poll();

        if(q.size()==0)
          System.out.print(i + "");
        else
          System.out.print(i + " ");
    }
  }
}
