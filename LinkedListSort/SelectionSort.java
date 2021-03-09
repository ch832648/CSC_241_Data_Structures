/**
Name: Caitlin Harris
Date: 11/18/2019
Title: SelectionSort.java
Description: This program reads integers from a file, stores
them in a linked list and sorts the linked list using a
modified Selection Sort algorithm
**/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Node{
  int data;
  Node next;

  //Constructor 1
  Node(int d){
  data = d;
  next = null;
  }
} //End of Node class

  public class SelectionSort{

      Node head;
      Node sorted;

      public static void main(String args[]) throws IOException {
        //File object
        File file1 = new File(args[0]);
        //Scanner object
        Scanner in = new Scanner(file1);

        //Read in integers into linked List
        SelectionSort list = new SelectionSort();
        //total number of integers in file
        int count = 0;
        while(in.hasNextInt()){
          list.push(in.nextInt());
          count++;
        }

      //insertion sort our linked list
      list.selectionSort(list.head);

        //Print the linked list
        Node current = list.head;
         while(current.next!=null){
             System.out.print(current.data+" ");
             current = current.next;
         }
         System.out.println(current.data);
         //System.out.println(count);

      } //End of main

      void push(int data) {
          //create new node
          Node newNode = new Node(data);
          //push integer into list
          newNode.next = head;
          head = newNode;
      }//end of push

    //Algorthim adpated from Geeksforgeeks for insertion sorting a linked list
    void selectionSort(Node head){
       for(Node x = head; x != null; x = x.next){
         Node temp = x;
         for(Node y = x; y != null; y = y.next){
           if(temp.data < y.data){
             temp = y;
           }
         }
         Node temp2 = new Node(x.data);
         x.data = temp.data;
         temp.data = temp2.data;
       }

    }//End of selectionSort

  }//End of Insertion Sort
