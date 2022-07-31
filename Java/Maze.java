import java.util.Scanner;
 //Morgan Benavidez, Programmer
 public class Maze 
 {
  static Scanner sc = new Scanner(System.in);
  // maze movements
  static char myMove = '\0';
  // cell position
  static int currentCell = 0;
  static int score = 0;
  static int totalScore = 0;
  static int moves = 0;
  static int totalMoves = 0;
  static boolean advance = true;
  static boolean checkThis = false;
  public static void main(String args[])
  {
   // the local variables declared and initialized
   char answer = 'Y';
  
   displayMenu();  
      
   while(answer == 'Y' || answer == 'y') 
   {
	displayMovement();
	makeYourMove();
	checkThis = checkYourMove();
	mazeStatus();
      
        if (currentCell == 10)
        {
        System.out.println("Play again(Y or N)?");
        answer = sc.next().charAt(0);
            if (answer == 'Y')
            {
                currentCell = 0;
                System.out.println("\nTotal Moves = " + totalMoves);
                System.out.println("Total Score = " + totalScore);
                    if (totalScore == 5)
                    {
                        System.out.println("Perfect Score!");
                        System.out.println("You're the Maze Runner!\n");
                        totalScore = 0;
                    }
            }
            if (answer == 'N')
            {
                System.out.println("\nTotal Moves = " + totalMoves);
                System.out.println("Total Score = " + totalScore);
                    if (totalScore == 5)
                    {
                         System.out.println("Perfect Score!");
                         System.out.println("You're the Maze Runner!\n");
                         totalScore = 0;
                    }
            }
        
        }
	//System.out.println("move again(Y or N)?");

        //answer = sc.next().charAt(0);
      
  }
   System.out.println("***************************");
}// end main() method

  
  
static void displayMenu()
{
   System.out.println("");
   System.out.println("***************************");
   System.out.println("----The Maze Strategy---");
   System.out.println("");
}// end method
static void displayMovement()
{
	if(currentCell == 0)
	{
		System.out.println("\nYou have entered the maze!!");
                System.out.println("The lower your score, the better.");
		System.out.println("There is no turning back!!");
		currentCell = 1;
		mazeStatus();
		advance = true;
	}
      System.out.println("make your move (U, L, D, R)");
      System.out.println("U = up, L = left, D = down, R = right)");
}// end method

static void makeYourMove()
{
	myMove = sc.next().charAt(0);
	
	switch(myMove)
	{
	  case 'U': { MoveUp(); break; }
          case 'u': { MoveUp(); break; }
	  case 'L': { MoveLeft(); break; }
          case 'l': { MoveLeft(); break; }
	  case 'D': { MoveDown(); break; }
          case 'd': { MoveDown(); break; }
	  case 'R': { MoveRight(); break; }
          case 'r': { MoveRight(); break; }
	}
   // end program menu
 }// end method
static boolean checkYourMove()
{
	if(currentCell == 1 && advance == true)
	{
		if (myMove == 'U' || myMove == 'u')
		{
			currentCell = 1;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("YOU'VE HIT A WALL.");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
			currentCell = 1;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("THERE IS NO TURNING BACK!");
			return advance;
		}
                if (myMove == 'R' || myMove == 'r')
		{
			currentCell = 2;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("CONTINUE THROUGH MAZE.");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
                        currentCell = 1;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("YOU'VE HIT A WALL.");
			return advance;
		}
	}
	if(currentCell == 2 && advance == true)
	{
		if (myMove == 'U' || myMove == 'u')
		{
			currentCell = 2;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("YOU'VE HIT A WALL.");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 1;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'R' || myMove == 'r')
		{
                        currentCell = 2;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("YOU'VE HIT A WALL.");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
			currentCell = 5;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
        }
        if(currentCell == 5 && advance == true)
	{
                if (myMove == 'U'|| myMove == 'u')
		{
			currentCell = 2;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("continue through the maze");
                    	return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 5;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'R' ||  myMove == 'r')
		{
			currentCell = 6;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
			currentCell = 5;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
        }
        if(currentCell == 6 && advance == true)
	{
		if (myMove == 'U'|| myMove == 'u')
		{
			currentCell = 3;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 5;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'R' ||  myMove == 'r')
		{
			currentCell = 6;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
			currentCell = 9;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
        }
if(currentCell == 3 && advance == true)
	{
		if (myMove == 'U'|| myMove == 'u')
		{
			currentCell = 3;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 3;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'R' || myMove == 'r')
		{
			currentCell = 3;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
			currentCell = 6;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
        }
if(currentCell == 9 && advance == true)
	{
		if (myMove == 'U'|| myMove == 'u')
		{
			currentCell = 6;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 8;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze.");
			return advance;
		}
		if (myMove == 'R' || myMove == 'r')
		{
                        currentCell = 9;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
                        currentCell = 10;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = false;
			System.out.println("YOU'VE COMPLETED THE MAZE!!!");
                        return advance;
		}

	}
if(currentCell == 8 && advance == true)
	{
		if (myMove == 'U'|| myMove == 'u')
		{
			currentCell = 8;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 7;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'R' || myMove == 'r')
		{
			currentCell = 9;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
			currentCell = 8;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
        }
if(currentCell == 7 && advance == true)
	{
		if (myMove == 'U'|| myMove == 'u')
		{
			currentCell = 4;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 7;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'R' || myMove == 'r')
		{
			currentCell = 8;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
			currentCell = 7;
                        score = 5;
                        totalScore += score;
			moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
        }
if(currentCell == 4 && advance == true)
	{
		if (myMove == 'U'|| myMove == 'u')
		{
			currentCell = 4;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'L' || myMove == 'l')
		{
                        currentCell = 4;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'R' || myMove == 'r')
		{
			currentCell = 4;
                        score = 5;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
                        advance = true;
			System.out.println("You've hit a wall.");
			return advance;
		}
		if (myMove == 'D' || myMove == 'd')
		{
			currentCell = 7;
                        score = 1;
                        totalScore += score;
                        moves = 1;
                        totalMoves += moves;
			advance = true;
			System.out.println("continue through the maze");
			return advance;
		}
        }

/*
if (currentCell == 9 && myMove == 'D')
        {
            char answer = 'Y';
        }
if (currentCell != 9 && myMove != 'D')
        {
            char answer = 'N';
        }
*/
        //score = 1;
        //totalScore += score;
        //totalMoves += moves;
	return advance;
        
        
	// end program menu
 }// end method
static void MoveLeft()
{
   System.out.println("you moved to the left");
   
}//end method
static void MoveRight()
{
	 System.out.println("you moved to the right");
	
}//end method
static void MoveUp()
{
	System.out.println("you moved up (forward)");
	
}//end method
static void MoveDown()
{
	System.out.println("you moved down (downward)");
	
}//end method
static void mazeStatus()
{
	System.out.println("current position: cell " + currentCell);
}//end method
}// end class

