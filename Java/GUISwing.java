package com.mycompany.insertionandmergesort;

/**
 *
 * @author Morgan Benavidez, Seat = #7
 */

import static com.mycompany.insertionandmergesort.MergeSort.mergeSort;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Dimension;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.JPanel;
import javax.swing.*;


public class GUISwing {
    public static void main(String args[]){
       SwingUtilities.invokeLater(new Runnable() {
           public void run(){
               
               //creating random numbers to populate the array.
               SecureRandom generator = new SecureRandom();
               
               //creating a random number of items to be in the array.
               int min = 100;
               int max = 2000;
               int random_int = (int)(Math.random() * (max - min +1) + min);
               String F = String.valueOf(random_int);
               //create unordered array of random # of ints between 10 - 2000
               int[] data = generator.ints(random_int, 10, 1000).toArray();
               int[] data2 = data.clone();
               
               //Merge Sort Instantiation and Timing of Function
               System.out.printf("Merge Sort unsorted array: %s%n%n", Arrays.toString(data));
               long msstartTime = System.nanoTime();
               mergeSort(data); // sort array
               long msendTime = System.nanoTime();
               long mselapsedTime = msendTime - msstartTime;
               String A = String.valueOf(mselapsedTime);
               System.out.printf("Merge Sort sorted array: %s%n", Arrays.toString(data));
               System.out.println("Merge Sort Time: ");
               System.out.println(mselapsedTime); //in nano seconds
               
               System.out.println(" ");
               
               //Insertion Sort Instantiation and Timing of Function
               System.out.printf("Insertion Sort unsorted array: %s%n%n", Arrays.toString(data2));
               InsertionSort Number2 = new InsertionSort();
               long isstartTime = System.nanoTime();
               Number2.insertionSort(data2);
               long isendTime = System.nanoTime();
               long iselapsedTime = isendTime - isstartTime;
               String B = String.valueOf(iselapsedTime);
               System.out.printf("Insertion Sort sorted array: %s%n", Arrays.toString(data2));
               System.out.println("Insertion Sort Time: ");
               System.out.println(iselapsedTime); //in nano seconds
               
               //Speed is calculated my subtracting insertion sort time from merge sort time.
               int Speed = (int) (mselapsedTime - iselapsedTime);
               String D = String.valueOf(Speed);
               
               String C;
               
               //String C is determined by the int Speed through if/else statements.
               if (Speed < 0) {
                   C = "Merge Sort is Faster by (nanoseconds): ";
                   System.out.println("Merge Sort is Faster than Insertion Sort by (nanoseconds): ");
               }
               else if (Speed > 0) {
                   C = "Insertion Sort is Faster by (nanoseconds): ";
                   System.out.println("Insertion Sort is Faster than Merge Sort by (nanoseconds): ");
               }
               else {
                   C = "Merge Sort and Insertion Sort are equal in Speed";
                   System.out.println("Merge Sort and Insertion Sort are equal in Speed.");
               }
               
               //This will tell us how much faster one sort is than the other.
               int absoluteSpeed = Math.abs(Speed);
               String E = String.valueOf(absoluteSpeed);
               
               //Creation of the GUI
               JFrame frame = new JFrame("Insertion and Merge Sort");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setSize(600,300);
               
               JLabel label1 = new JLabel("Insertion Sort Speed in Nanoseconds: ");
               frame.getContentPane().add(label1);
               JButton button = new JButton(B);
               frame.getContentPane().add(button);
               
               JLabel label2 = new JLabel("Merge Sort Speed in Nanoseconds: ");
               frame.getContentPane().add(label2);
               JButton button2 = new JButton(A);
               frame.getContentPane().add(button2);
               
               JLabel label3 = new JLabel(C);
               frame.getContentPane().add(label3);
               JButton button3 = new JButton(E);
               frame.getContentPane().add(button3);
               
               JLabel label4 = new JLabel("Number of Items Sorted: ");
               frame.getContentPane().add(label4);
               JButton button4 = new JButton(F);
               frame.getContentPane().add(button4);
               
               frame.setLayout(new GridLayout(4,2));
               frame.setVisible(true);
               
               
               
           }
       });
       
    }
}
