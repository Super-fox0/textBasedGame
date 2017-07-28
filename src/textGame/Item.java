package textGame;

public class Item 
{

	String name;
	int durability;
	
	
	public Item(String name, int durability) {
		super();
		this.name = name;
		this.durability = durability;
	}
	
	public int getDurability() 
	{
		return durability;
	}
	
	public void setDurability(int durability) 
	{
		this.durability = durability;
	}
	
	public String getName() {
		return name;
	}
	
	
	
}
