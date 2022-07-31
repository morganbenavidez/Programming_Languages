import java.util.Random;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
// MORGAN BENAVIDEZ, Programmer
public class RPGSimulator {
		
	public static void main(String args[]) throws InterruptedException
	{
		Random rand1 = new Random();
		Random rand2 = new Random();
                Scanner input = new Scanner(System.in);
                
								
		String mission1 = "Capture the Castle";
		String mission2 = "Enter the Hidden City";
		String mission3 = "Rescue the Princess";
		String mission4 = "Traverse the Forest";
		String mission5 = "Locate the Tunnel Entrance";
                String mission6 = "Escape the Volcano";
                String mission7 = "Save the Village";
//ADDED TWO MISSIONS
		String player1 = "", player2 = "", player3 = "";
							
		char letter = '\0', role = '\0';
                
		
		// initial health and treasures for the two players
		int number = 0, mission = 0, health1 = 100, health2 = 100, health3 = 10000;
		int treasure1 = 100, treasure2 = 100, treasure3 = 10000, encounter = 0;
                String action1 = "", action2 = "";
                


		// define your mission
                
		number = rand2.nextInt(4) + 1;
		System.out.print("your mission is: ");
		switch(number)
		{
		  
                  case 1: System.out.println(mission1); mission = 1; break;
		  case 2: System.out.println(mission2); mission = 2; break;		  
                  case 3: System.out.println(mission3); mission = 3; break;                    
		  case 4: System.out.println(mission4); mission = 4; break;		  
                  case 5: System.out.println(mission5); mission = 5; break;
                  case 6: System.out.println(mission6); mission = 6; break;
                  case 7: System.out.println(mission7); mission = 7; break;
                  
		}
//ADDED TWO MISSIONS    

		System.out.println("");
                

// ADDED A WOODLAND ELF, YOU WILL ONLY SEE HIM ON TRAVERSE THE FOREST
// YOU WILL ONLY SEE HIS INCREDIBLE STATS ON THE 1ST ENCOUNTER INTENTIONALLY
// YOU WILL ALSO SEE A MASSIVE STATS BOOST ON THE NEXT ENCOUNTER
// THE PLAYER WILL ALSO DIALOGUE WITH HIM
                
             // define your role

                role = (char)(rand1.nextInt(26) + 'a');
                if(mission == 4 && role >= 'a' && role <= 'z')
                {
                  
                    player1 = "protagonist";
                    player2 = "opponent";
                    player3 = "woodland elf";
                }else
                {
                
                            role = (char)(rand1.nextInt(26) + 'a');
                            if(role >= 'a' && role <= 'm' ) 
                            {
                                    player1 = "protagonist";
                                    player2 = "opponent";
                                    

                            }
                            else 
                            {
                                    player1 = "opponent";
                                    player2 = "protagonist";
                            }
                }
                System.out.println("you are the " + player1 + "\n");
		// let the game simulation commence (limit the # of encounters)
		for (encounter = 1; encounter <= 20; encounter++)
		{
			letter = (char)(rand1.nextInt(5) + 'a');
			number = rand2.nextInt(10) + 1;
			// randomly encounter the enemy
			if(letter == 'a' || letter == 'b')
			//if(mission == 1 || mission == 2 || mission == 3)
			{
			  health1 -= 10;
			  health2 += 15;
                          health3 += 150;
			  treasure1 += 10;
			  treasure2 -= 10;
                          treasure3 += 150;
			  //Thread.sleep(5000);
			  System.out.print("battle: " + encounter);
			  System.out.println("\t" + "health" + "\t" + "treasure");
			  System.out.println(player1 + "\t" + health1 + "\t" + treasure1);
			  System.out.println(player2 + "\t" + health2 + "\t" + treasure2);
                            System.out.println(player3);
			  System.out.println("");
			  //encounter++;
			}	
                        else if(letter == 'c' || letter == 'd')
                        {
                          health1 += 20;
                          health2 -= 30;
                          treasure1 += 40;
                          treasure2 -= 20;
                          //Thread.sleep(500);
                          System.out.print("battle: " + encounter);
                          System.out.println("\t" + "health" + "\t" + "treasure");
                          System.out.println(player1 + "\t" + health1 + "\t" + treasure1);
                          System.out.println(player2 + "\t" + health2 + "\t" + treasure2);
                          System.out.println(player3);
                          System.out.println("");
                          //break;
                        }
                        
//ADDED ADDITIONAL IF/ELSE IF STATEMENTS FOR MORE INTERACTIVE GAMEPLAY
                        
                        else if((letter == 'e' || letter == 'f') && encounter >= 3)
                        {
                            System.out.print("To attack, enter 1.  To run, enter 2.\n");
                            action1 = input.next();
                            int y = Integer.parseInt(action1);
                            if (y == 1){
                                health1 += 35;
                                health2 -= 20;
                                treasure1 -= 40;
                                treasure2 -= 20;
                                //Thread.sleep(500);
                                System.out.print("battle: " + encounter);
                                System.out.println("\t" + "health" + "\t" + "treasure");
                                System.out.println(player1 + "\t" + health1 + "\t" + treasure1);
                                System.out.println(player2 + "\t" + health2 + "\t" + treasure2);
                                System.out.println(player3);
                                System.out.println("");
                            }
                            else
                            {
                                health1 += 45;
                                health2 += 45;
                                treasure1 += 45;
                                treasure2 += 45;
                                System.out.print("battle: " + encounter + " FLED!!");
                                System.out.println("\t" + "health" + "\t" + "treasure");
                                System.out.println(player1 + "\t" + health1 + "\t" + treasure1);
                                System.out.println(player2 + "\t" + health2 + "\t" + treasure2);
                                System.out.println(player3);
                                System.out.println("LIVE TO FIGHT ANOTHER DAY!!\n");
                            }
                            
                                
                        }
                        else
                        {
                          health1 += 30;
                          health2 -= 20;
                          treasure1 -= 30;
                          treasure2 += 20;
                          //Thread.sleep(500);
                          System.out.print("battle: " + encounter);
                          System.out.println("\t" + "health" + "\t" + "treasure");
                          System.out.println(player1 + "\t" + health1 + "\t" + treasure1);
                          System.out.println(player2 + "\t" + health2 + "\t" + treasure2);
                          System.out.println(player3);
                          System.out.println("");
                          //break;
                         }
                
                        if (mission == 4 && encounter == 1)
                {
                        
                         health1 += 100;
                         treasure1 += 100;
                         health2 += 15;
                         treasure2 += 15;
                         System.out.println("Hello adventurer, I am Asrai, a Magical Woodland Elf.");
                         System.out.println("What is your name? ");
                         String theName = input.nextLine();
                         System.out.println("A pleasure to meet you " + theName + "!" );
                         System.out.println("I have been sent by the counsel to guide you safely");
                         System.out.println("through our lands.");
                         System.out.println("Is that ok with you?");
                         System.out.println("Type 1 for yes, or type 2 for no.");
                         action2 = input.next();
                            int d = Integer.parseInt(action2);
                            if (d == 1){
                                System.out.println("Wonderful!  I will follow \n"
                                        + "you closely until you traverse this forest safely.");
                            }else
                            {
                                System.out.println("Be that as it may, the counsel has given me orders.  \nI will "
                                        + "keep my distance but will make sure you traverse this forest safely.");
                            }
                         System.out.println("May fortune favor your journey, " + theName + "!\n");
                         System.out.print("battle: " + encounter);
			 System.out.println("\t" + "health" + "\t" + "treasure");
			 System.out.println(player1 + "\t" + health1 + "\t" + treasure1);
			 System.out.println(player2 + "\t" + health2 + "\t" + treasure2);
                          System.out.println(player3 + "\t" + health3 + "\t" + treasure3);
			 System.out.println("");
                 }

		 health1 -= 5;
		 health2 -= 5;
		 treasure1 -= 5;
		 treasure2 -= 5;
//ADDED BONUS HEALTH AND TREASURE FOR ENCOUNTER 5 AND 10                 
                 if (encounter == 5)
                 {
                     health1 += 50;
                     health2 += 50;
                     treasure1 += 50;
                     treasure2 += 50;
                 }
                 if (encounter == 10)
                 {
                     health1 += 50;
                     health2 += 50;
                     treasure1 += 50;
                     treasure2 += 50;
                 }
		 if (health1 <= 0 || health2 <= 0 || treasure1 <= 0 || treasure2 <= 0)
		 {
		  //System.out.print("encounter: " + encounter + " action status: ");
		  break;
		 }
		}
		System.out.println("simulation has ended\n");
		System.out.println("results:\n");
		System.out.println("\t\t" + "health" + "\t" + "treasure");
		System.out.println(player1 + "\t" + health1 + "\t" + treasure1);
		System.out.println(player2 + "\t" + health2 + "\t" + treasure2);
	}
}

