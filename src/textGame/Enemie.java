package textGame;

public class Enemie 
{

	int health;
	int damage;
	int armour;
	
	public Enemie(int health, int damage, int armour) 
	{
		super();
		this.health = health;
		this.damage = damage;
		this.armour = armour;
	}
	
	public int getHealth() 
	{
		return health;
	}
	
	public void setHealth(int health) 
	{
		this.health = health;
	}
	
	public int getDamage() 
	{
		return damage;
	}
	
	public void setDamage(int damage) 
	{
		this.damage = damage;
	}
	
	public int getArmour() 
	{
		return armour;
	}
	
	public void setArmour(int armour) 
	{
		this.armour = armour;
	}
	
	
	
	
	
	
}
