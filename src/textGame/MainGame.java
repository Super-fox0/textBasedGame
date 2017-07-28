package textGame;

import java.util.Scanner;

public class MainGame 
{
	int mapDimensionx;
	int mapDimensiony;
	
	int playerX;
	int playerY;
	
	String[][] board;
	

	public static void main(String[] args) 
	{
		MainGame x = new MainGame();
		
		System.out.println("Enter Game board Dimensions X, Y");
		
		x.init(x.inputNum(),x.inputNum());
		x.generate();
		System.out.println("x:"+x.playerX + " " + "y:"+x.playerY);
		
		x.printBoard(); //inital generation and player pos test
		
		x.goNorth();
		System.out.println("x:"+x.playerX + " " + "y:"+x.playerY);
		x.printBoard();
		
		x.goEast();
		System.out.println("x:"+x.playerX + " " + "y:"+x.playerY);
		x.printBoard();
		
		x.goSouth();
		System.out.println("x:"+x.playerX + " " + "y:"+x.playerY);
		x.printBoard();
		
		x.goSouth();
		x.printBoard();
		
		x.goWest();
		x.printBoard();
		
		
		
		
		
		
		

	}

	public void init(int x, int y) //set dimensions to odd number to start in middle
	{
		board = new String[y][x];
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
	}	
	public void printBoard() //works
	{
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
	
	
	
	public enum Directions
	{
		  EAST, 
		  WEST, 
		  NORTH, 
		  SOUTH
	}
	
}
