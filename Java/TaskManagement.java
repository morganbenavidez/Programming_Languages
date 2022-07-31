import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// Programmer: Sammy Student
public class TaskManagement 
{

    public static void main(String[] args) 
    {        
	try 
	{
	  Scanner scan = new Scanner(System.in);

	  // define the tasks
	  ArrayList<String> theTasks = new ArrayList<String>
	  (Arrays.asList("Task 1", "Task 2", "Task 3", "Task 4", "Task 5"));
	      
	  // define the task durations
	  ArrayList<Integer> theDurations = new ArrayList<Integer>
	  (Arrays.asList(20, 25, 18, 9, 13));
	      
	  // define the task status
	  ArrayList<String> theStatus = new ArrayList<String>
	  (Arrays.asList("Open", "Open", "Open", "Open", "Open"));
	      
	  // define the current task
	  int num = 0;
	   
	  // define the processors
	  int processor1 = 0;
	  int processor2 = 0;
	     
	  // define the total running time
	  int TRT = 0;
          int TRT1 = 0;
          int TRT2 = 0;
      
	  // display initial data
	  listTasks(theTasks);
	  listDurations(theDurations);
	  listStatus(theStatus);      
	      
	  // commence the processing
	  // assign the duration of Task 1 to processor 1
	  // change the status of Task 1
	  // update the total running time of the complete process
	  for(int i =0; i < theTasks.size(); i++)
          {
            if(theDurations.get(i) == 20)
            {   
                num += 1;
                processor1 = theDurations.get(i);
                theStatus.set(i, "In Use"); 
                TRT1 += theDurations.get(i);
                showProgress(num, processor1, theStatus.get(i), TRT1);
            }
            else if (theDurations.get(i) == 25)
            {
                num += 1;
                processor2 += theDurations.get(i);
                theStatus.set(i, "In Use");
                TRT2 += theDurations.get(i);
                showProgress(num, processor2, theStatus.get(i), TRT2);
            
            }
            else if(theDurations.get(i) == 18)
            {   
                num += 1;
                processor1 = theDurations.get(i);
                theStatus.set(i, "In Use"); 
                TRT1 += theDurations.get(i);
                showProgress(num, processor1, theStatus.get(i), TRT1);
            }
            else if (theDurations.get(i) == 9)
            {
                num += 1;
                processor2 += theDurations.get(i);
                theStatus.set(i, "In Use");
                TRT2 += theDurations.get(i);
                showProgress(num, processor2, theStatus.get(i), TRT2);
            
            }
            else if (theDurations.get(i) == 13)
            {
                num += 1;
                processor1 += theDurations.get(i);
                theStatus.set(i, "In Use");
                TRT1 += theDurations.get(i);
                showProgress(num, processor1, theStatus.get(i), TRT1);
            }
            // show current process processor1
            TRT = TRT1 + TRT2;
          }
          
          System.out.println("The Total Run Time for Processor 1 = " + TRT1);
          System.out.println("The Total Run Time for Processor 2 = " + TRT2);
          System.out.println("The Total Run Time = " + TRT);
            System.out.println(theDurations.get(2));
            System.out.println(theTasks.get(1).toUpperCase());
          
          /*
          num += 1;
          processor2 += theDurations.get(1);
          theStatus.set(1, "In Use");
          TRT += theDurations.get(1);
          // show current process processor2
	  showProgress(num, processor2, theStatus.get(1), TRT);
          */
	  // display current data
	  listTasks(theTasks);
	  listDurations(theDurations);
	  listStatus(theStatus); 

	  // continue the task processing   
	  
        scan.close();
	}
	catch (Exception e) 
	{         
	  e.getMessage();
	}
    }
    public static void listTasks(ArrayList<String> tasks)
    {
    	System.out.println(" ");
    	for (int i = 0; i < tasks.size(); i++) 
      {
 	  System.out.print(tasks.get(i) + "\t");
  	}
    	System.out.println(" ");
    }
    public static void  listDurations(ArrayList<Integer> durations)
    {
    	System.out.println(" ");
    	for (int i = 0; i < durations.size(); i++) 
      {
 	  System.out.print(durations.get(i) + "\t"); 			
  	}
    	System.out.println(" ");
    }
    public static void listStatus(ArrayList<String> status)
    {
    	System.out.println(" ");
    	for (int i = 0; i < status.size(); i++) 
      {
 	  System.out.print(status.get(i) + "\t");
   	}
    	System.out.println(" ");
    }

    public static void showProgress(int n, int processor, String s, int total)
    {
    	System.out.println(" ");
    	System.out.println("Task Number" + "\t" + n );
    	System.out.println("task time" + "\t" + processor );
    	System.out.println("task status" + "\t" + s );
    	System.out.println("total time" + "\t" + total );
    	System.out.println(" ");
    }
}

