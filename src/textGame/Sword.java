package textGame;

public class Sword extends Item 
{

	int damage = 10;
	int ultimate = 10000;
	
	public Sword(String name, int durability, int damage, int ultimate) 
	{
		super(name, durability);
		this.damage = damage;
		this.ultimate = ultimate;
	}

	public int getDamage() 
	{
		return damage;
	}

	public void setDamage(int damage) 
	{
		this.damage = damage;
	}

	public int getUltimate() 
	{
		return ultimate;
	}

	public void setUltimate(int ultimate) 
	{
		this.ultimate = ultimate;
	}

	
	

}
