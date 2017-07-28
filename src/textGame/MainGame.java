package textGame;

import java.util.Random;
import java.util.Scanner;

public class MainGame 
{
	int mapDimensionx;
	int mapDimensiony;
	
	int generatorRange;
	
	int playerX;
	int playerY;
	
	String[][] board;
	

	public static void main(String[] args) 
	{
		MainGame x = new MainGame();
		
		System.out.println("Enter Game board Dimensions X, Y");
		
		x.init(x.inputNum(),x.inputNum());
		x.generate();
		//System.out.println("x:"+x.playerX + " " + "y:"+x.playerY);
		
		x.printBoard(); //inital generation and player pos test - works
		

		//maybe move to init or generate - works
		x.placeObject();
		x.placeObject();
		x.placeObject();
		
		x.placeEnemy();
		x.placeEnemy();
		x.placeEnemy();
		
		x.printBoard();
		
		
		
		
		
		

	}

	public void init(int x, int y) //set dimensions to odd number to start in middle
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
	
	public void goNorth() //works
	{
		playerY =  playerY - 1;
		board[playerY][playerX] = "X";
	}
	
	public void goEast() //works
	{
		playerX = playerX + 1;
		board[playerY][playerX] = "X";
	}
	
	public void goSouth() //works
	{
		playerY = playerY + 1;
		board[playerY][playerX] = "X";
	}
	
	public void goWest() //works
	{
		playerX = playerX - 1;
		board[playerY][playerX] = "X";
	}
	
	public int randomNum() //works
	{	
		return 	(int) Math.floor(Math.random() * generatorRange);
	}
	
	public void placeObject() //works with collision check
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
	
	
	public enum Directions //works
	{
		  EAST, 
		  WEST, 
		  NORTH, 
		  SOUTH
	}
	
}
