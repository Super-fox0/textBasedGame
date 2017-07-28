package textGame;

import java.util.Random;
import java.util.Scanner;

public class MainGame 
{
	boolean gameOver = false;
	
	int mapDimensionx;
	int mapDimensiony;
	
	int generatorRange;
	
	int playerX;
	int playerY;
	
	String[][] board;
	
	String tileValue;
	
	int itemCount =0;
	

	public static void main(String[] args) 
	{
		MainGame x = new MainGame();
		
		System.out.println("Enter Your Hero's Name:");
		Player p = new Player(x.inputString()); //set name for hero
		
		
		System.out.println("Enter Game board Dimensions X, Y");
		System.out.println();
		
		
		
		x.init(x.inputNum(),x.inputNum()); //make board -empty
		
		System.out.println(x.description() + p.getName()); // inital description
		x.generate(); //place player
		//System.out.println("x:"+x.playerX + " " + "y:"+x.playerY);
		
		x.printBoard(); //inital generation and player pos test - works
		

		//maybe move to init or generate - works
		x.placeObject();
		x.placeObject();
		x.placeObject();
		
		x.placeEnemy();
		x.placeEnemy();
		x.placeEnemy();
		
		x.placeExit();
		
		x.printBoard();
		
		
		System.out.println();
		
		while(x.gameOver == false)
		{
			System.out.println("Which way master:");
			String s = x.inputString();
			switch (s) //works
			{
			case "NORTH":
				x.goNorth();
				break;
			
			case "EAST":
				x.goEast();
				break;
				
			case "SOUTH":
				x.goSouth();
				break;
				
			case "WEST":
				x.goWest();		
				break;
			}
			x.printBoard();
			x.encounterCheck();
			x.objectCheck();
			x.exitCheck();
			
			
		}
		
		
		
		

	}

	public void init(int x, int y) //works
	{
		board = new String[y][x];
		generatorRange = x;
		
		playerX = x/2;
		playerY = y/2;	
	}
	
	public void generate() //works
	{
		for (int i = 0; i < board.length; i++) 
		{
		    for (int j = 0; j <board[i].length; j++) 
		    {
		    	board[i][j] = "0";
		        System.out.print(board[i][j] + " ");
		    }
		    board[playerX][playerY] = "X";
		    System.out.println(" ");
		}	
		System.out.println();
	}	
	
	public void printBoard() //works
	{
		System.out.println("x:"+playerX + " " + "y:"+playerY);
		for (int i = 0; i < board.length; i++) 
		{
		    for (int j = 0; j <board[i].length; j++) 
		    {
		        System.out.print(board[i][j] + " ");
		    }
		    System.out.println(" ");
		}
		System.out.println(" ");
	}
	
	public int inputNum() // works
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		return a;
	}
	
	public String inputString() // works
	{
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		return a;
	}
	
	public void goNorth() //works
	{
		playerY =  playerY - 1;
		tileValue = board[playerY][playerX];
		board[playerY][playerX] = "X";
	}
	
	public void goEast() //works
	{
		playerX = playerX + 1;
		tileValue = board[playerY][playerX];
		board[playerY][playerX] = "X";
	}
	
	public void goSouth() //works
	{
		playerY = playerY + 1;
		tileValue = board[playerY][playerX];
		board[playerY][playerX] = "X";
	}
	
	public void goWest() //works
	{
		playerX = playerX - 1;
		tileValue = board[playerY][playerX];
		board[playerY][playerX] = "X";
	}
	
	public int randomNum() //works
	{	
		return 	(int) Math.floor(Math.random() * generatorRange);
	}
	
	public void placeObject() //works 
	{
		int x = randomNum();
		int y = randomNum();
		if(board[y][x] == "0")
		{
			board[y][x] = "O";
		}
		else
		{
			placeObject();
		}
	}
	
	public void placeEnemy() //works
	{
		int x = randomNum();
		int y = randomNum();
		if(board[y][x] == "0")
		{
			board[y][x] = "E";
		}
		else
		{
			placeEnemy();
		}
	}
	
	public void placeExit() //works
	{
		int x = randomNum();
		int y = randomNum();
		if(board[y][x] == "0")
		{
			board[y][x] = "T";
		}
		else
		{
			placeExit();
		}
	}
	
	public void encounterCheck() //works
	{
		if(tileValue == "E")
		{
			System.out.println("Enemy encountered, fight or die");
		}
	}
	
	public void objectCheck() //works
	{
		if(tileValue == "O")
		{
			itemCount = itemCount + 1;
			System.out.println("You see something shiny by your feet and proceed to pick it up");
		}
	}
	
	public void exitCheck() //works  -- need to implement keys from enemies (power cores)
	{
		if(tileValue == "T")
		{
			System.out.println("You have stumbled upon a teleporter, as you pass through it you return to where you once came");
			gameOver = true;
		}
	}
	
	
//	public enum Directions //works
//	{
//		  EAST, 
//		  WEST, 
//		  NORTH, 
//		  SOUTH
//	}
	
	public String description()
	{
		String s = "You awake with nothing but a pair of torn shorts and your bare hands, you must survive this desolate waste land using your mind and courage to disuade any foe. you are the hero of your own fate ";
		return s;
	}
}
