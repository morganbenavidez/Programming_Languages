
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
// Programmer Morgan Benavidez

public class RetailStore 
{
    Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]) 
    {
        int rows = 7;
        int columns = 8;
        int customerTotal = 0;
        int [ ][ ] table = new int[rows][columns];
        
        Random randomGen = new Random();
        StringBuilder s = new StringBuilder();
        int randomInt1 = 0;
        int randomInt2 = 0;
        
        //generate column titles
        for (int j = 0; j< columns; j++)
        {
            s.append("\thr " + (j + 1));
        }
        s.append("\n\n");
        //populate data for each cashier lane
        for (int i = 0; i < rows; i++)
        {
            s.append("lane " + (i + 1));
            s.append("\t");
            for (int j = 0; j < columns; j++)
            {
                //express checkout lane
                randomInt1 = 1 + randomGen.nextInt(20);
                //standard checkout lane
                randomInt2 = 1 +randomGen.nextInt(10);
                if(i == 0)
                {
                    table[i][j] = randomInt1;
                    customerTotal += randomInt1;
                }
                else
                {
                    table[i][j] = randomInt2;
                    customerTotal += randomInt2;
                }
                s.append(table[i][j]);
                s.append(" ");
                s.append("\t");
            }
            s.append("\n");
        }
        System.out.println("Total customers = " + customerTotal);
        System.out.println("data simulation: \n\n" + s);
        System.out.println("");
        
        // perform data analysis
        // row analysis
        String str = JOptionPane.showInputDialog(null, "enter a cashier lane number: ");
        //subtract 1 to compensate for a zero indexed array
        int laneNum = Integer.parseInt(str) - 1;
        double average = 0.0, sum = 0.0;
        for (int j = 0; j < columns ; j++)  
	  {
		  sum += table[laneNum][j];
	  }
	  average = sum / columns;
	  System.out.println( "" );
	  
	  String outputMsg = "";
	  outputMsg += "\n for cashier lane " + (laneNum + 1);
	  outputMsg += "\n the data analysis is: ";
	  outputMsg += "\n customer count -> " + Math.round(sum);
	  outputMsg += "\n average -> " + Math.round(average);
          if (average >= 10){
              outputMsg += "\n Schedule another bagging clerk.";
          }
       
	  
	  JOptionPane.showMessageDialog(null, outputMsg,
	  "Data Row Analysis", JOptionPane.PLAIN_MESSAGE);
	  
	  // column analysis
	  str = JOptionPane.showInputDialog(null, "enter an hour number : ");
	  // subtract 1 to compensate for a zero indexed array
	  int hourNum = Integer.parseInt(str) - 1;
          // reset the accumulating variable
	  sum = 0;	  
	  for (int i = 0; i < rows ; i++)  
	  {
		  sum += table[i][hourNum];
		  System.out.println( table[i][hourNum] );
	  }
	  average = sum / rows;
	  System.out.println( "" );
	  outputMsg = "";
	  outputMsg += "\n for hour number " + (hourNum + 1);
	  outputMsg += "\n the data analysis is: ";
	  outputMsg += "\n customer count -> " + Math.round(sum);
	  outputMsg += "\n average -> " + Math.round(average);
          
          if (average >= 10)
          {
              outputMsg += "\n Schedule another bagging clerk.";
          }
	  JOptionPane.showMessageDialog(null, outputMsg,
	  "Data Column Analysis", JOptionPane.PLAIN_MESSAGE);
  }
}

               