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
	
	int exitX;
	int exitY;
	
	int powerCores =0;
	
	String[][] board;
	
	String tileValue;
	
	int itemCount =0;
	

	public static void main(String[] args) 
	{
		MainGame x = new MainGame();
		
		Item rustySword = new Sword("Rusty Sword", 100, 20, 0);
		Item excalibur = new Sword("Excalibur", 10000, 100, 1000000);
		Item Sheild = new Shield("Steel Square Shield", 100, 100);
		
		Enemie light = new Enemie(25, 25, 25);
		Enemie medium = new Enemie(50, 50, 50);
		Enemie heavy = new Enemie(500, 100, 100);
		
		System.out.println("Enter Your Hero's Name:");
		Player p = new Player(x.inputString()); //set name for hero
		
		
		System.out.println("Enter Game board Dimensions X, Y");
		System.out.println();
		
		
		x.init(x.inputNum(),x.inputNum()); //make board -empty
		
		System.out.println(x.description() + p.getName()); // inital description
		System.out.println(x.mapDimensionx +" " + x.mapDimensiony );
		
		x.generate(); //place player
		//System.out.println("x:"+x.playerX + " " + "y:"+x.playerY);
		
		x.placeExit();
		
		x.printBoard(); //inital generation and player pos test - works
		

		//maybe move to init or generate - works
		x.placeObject();
		x.placeObject();
		x.placeObject();
		
		x.placeEnemy();
		x.placeEnemy();
		x.placeEnemy();
		
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
		mapDimensionx = x;
		mapDimensiony = y;
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
		board[exitY][exitX] = "T";
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
		if(playerY-1 <0)
		{
			edgeHit();
		}
		else
		{
			playerY =  playerY - 1;
			tileValue = board[playerY][playerX];
			board[playerY][playerX] = "X";
		}	
	}
	
	public void goEast() //works
	{
		if(playerX+1 == mapDimensionx)
		{
			edgeHit();
		}
		else
		{
			playerX = playerX + 1;
			tileValue = board[playerY][playerX];
			board[playerY][playerX] = "X";
		}
	}
	
	public void goSouth() //works
	{
		if(playerY+1 == mapDimensiony)
		{
			edgeHit();
		}
		else
		{
			playerY = playerY + 1;
			tileValue = board[playerY][playerX];
			board[playerY][playerX] = "X";
		}	
	}
	
	public void goWest() //works
	{
		if(playerX-1 < 0)
		{
			edgeHit();
		}
		else
		{
			playerX = playerX - 1;
			tileValue = board[playerY][playerX];
			board[playerY][playerX] = "X";
		}
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
			exitX = x;
			exitY = y;
		}
		else
		{
			placeExit();
		}
	}
	
	public void encounterCheck() //works
	{
		if(tileValue == "E") //do fight system
		{
			System.out.println("Enemy encountered, fight or die");
			if(powerCores == 0)
			{
				
			}
		}
	}
	
	public void objectCheck() //works
	{
		if(tileValue == "O")
		{
			itemCount = itemCount + 1;
			System.out.println("You see something shiny by your feet and proceed to pick it up");
		}
		if(itemCount == 1)
		{
			System.out.println("you found a rusty sword, not the best quality, but you'll slice up any foe who crosses your path");
		}
		if(itemCount == 2)
		{
			System.out.println("you found a Steel Square shield, this should prove helpful");
		}
		if(itemCount == 3)
		{
			System.out.println("as you approach the object, the earth trembles around you revealing a sword dug deep within a stone");
			System.out.println("you proceed towards the sword and hear a sharp resonating sound every step closer you take");
			System.out.println("you clasp the hilt of the sword, hearing the roar of a blazing inferno in your head as you proceed to pull with all your might");
			System.out.println("the sword begins to screech as inch by inch it reveals it's blade from the stone");
			System.out.println("the sword finally breaks free from the stone from where it laid with a slight glow on the gem encrusted hilt");
			System.out.println("along the blade is etched the words, 'THE HOLY SWORD EXCALIBUR'");
			System.out.println("This should prove useful");
		}
		
	}
	
	public void exitCheck() //works  -- need to implement keys from enemies (power cores)
	{
		if(tileValue == "T" && powerCores == 3)
		{
			System.out.println("You have stumbled upon a teleporter, as you pass through it you return to where you once came");
			gameOver = true;
		}
		else if(tileValue == "T" && powerCores < 3)
		{
			System.out.println("You have stumbled upon a teleporter, but it is not powered. Maybe you can find a way to power it");
		}
	}
	
	public void fight()
	{
		
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

	public void edgeHit()
	{
		String s = "you approach the edge of a cliff, there's no longer anywhere to go";
		System.out.println(s);

	}
}
