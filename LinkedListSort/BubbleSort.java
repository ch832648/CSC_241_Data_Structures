/**
Name: Caitlin Harris
Date: 11/18/2019
Title: BubbleSort.java
Description: This program reads integers from a file, stores
them in a linked list and sorts the linked list using a
modified Bubble Sort algorithm
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

  public class BubbleSort{

    Node head;
    Node sorted;

    public static void main(String args[]) throws IOException {
      //File object
      File file1 = new File(args[0]);
      //Scanner object
      Scanner in = new Scanner(file1);

      //Read in integers into linked List
      BubbleSort list = new BubbleSort();
      //total number of integers in file
      int count = 0;
      while(in.hasNextInt()){
        //
        list.push(in.nextInt());
        count++;
      }

    //bubble sort our linked list
     list.bubbleSort(list.head);

      //Print the linked list
      Node current = list.head;
       while(current.next!=null){
           System.out.print(current.data+" ");
           current = current.next;
       }
       System.out.println(current.data);
       //System.out.println(count);

    } //End of main

    void push(int data)
    {
        //create new node
        Node newNode = new Node(data);
        //push integer into list
        newNode.next = head;
        head = newNode;
    }

    //Algorthim adapted from geeksforgeeks to bubble sort a linked list
    void bubbleSort(Node head){
       Node current;
       Node current2;
       int key = 1;

       while(key != 0){
       key = 0;
       current = head.next;
       current2 = head;

       while (current != null){
          if (current.data > current2.data){
             Node temp = new Node(current.data);
             current2.next.data = current2.data;
             current2.data = temp.data;
             key++;
          }
          current = current.next;
          current2 = current2.next;
        }
      }
    }
  } //End of Bubble Sort Class
