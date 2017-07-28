package textGame;

public class Shield extends Item 
{

	int defence = 50;

	public Shield(String name, int durability, int defence) 
	{
		super(name, durability);
		this.defence = defence;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	

}
