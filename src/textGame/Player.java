package textGame;

public class Player 
{
	int health = 100;
	String name;
	
	public Player(int health, String name) 
	{
		super();
		this.health = health;
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	
}


