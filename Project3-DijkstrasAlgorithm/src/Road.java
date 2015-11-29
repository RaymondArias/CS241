
public class Road {
	private City target;
	private int weight;
	
	public Road(City target, int weight)
	{
		this.target = target;
		this.weight = weight;
	}

	public City getTarget()
	{
		return target;
	}

	public void setTarget(City target) 
	{
		this.target = target;
	}

	public int getWeight() 
	{
		return weight;
	}

	public void setWeight(int weight) 
	{
		this.weight = weight;
	}

}
