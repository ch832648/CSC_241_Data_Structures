/**
Name: Caitlin Harris
Date: 11/18/2019
Title: InsertionSort.java
Description: This program reads integers from a file, stores
them in a linked list and sorts the linked list using a
modified Insertion Sort algorithm
**/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Node{
  int data;
  Node next;

  //Constructor 1
  public Node(int d){
  this.data = d;
  }
} //End of Node class

  public class InsertionSort{

    Node head;
    Node sorted;

    public static void main(String args[]) throws IOException {
      //File object
      File file1 = new File(args[0]);
      //Scanner object
      Scanner in = new Scanner(file1);

      //Read in integers into linked List
      InsertionSort list = new InsertionSort();
      //total number of integers in file
      int count = 0;
      while(in.hasNextInt()){
        //
        list.push(in.nextInt());
        count++;
      }

    //insertion sort our linked list
    list.insertionSort(list.head);

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

//Algorthims adapted from Geeksforgeeks to Insertion Sort a linked list
    void insertionSort(Node headref){
        // Initialize sorted linked list
        sorted = null;
        Node current = headref;
        while (current != null)
        {
            //store next
            Node next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            //update current
            current = next;
        }
        //update head
        head = sorted;
    }//end of insertionSort

    void sortedInsert(Node newNode) {
        if (sorted == null || sorted.data <= newNode.data)
        {
            newNode.next = sorted;
            sorted = newNode;
        }
        else
        {
            Node current = sorted;
            while (current.next != null && current.next.data > newNode.data)
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    } //end of sortedInsert

  } //End of Bubble Sort Class
