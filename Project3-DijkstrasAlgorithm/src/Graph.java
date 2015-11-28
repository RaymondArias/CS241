import java.util.Arrays;

public class Graph <E>{
	private E[] cityInfo;		
	private Integer [][]roadWeight;
	
	public Graph(int size)
	{
		roadWeight = new Integer[size][size];
		cityInfo = (E[]) new Object[size];
	}
	public void addCityInfo(E newCity)
	{
		cityInfo[cityInfo.length -1] = newCity;
		
	}
	public void setCityInfo(int vertex, E newCity)
	{
		cityInfo[vertex] = newCity;
	}
	public void setRoadWeight(int source, int target, int weight)
	{
		roadWeight[source][target] = weight;
		
	}
	public boolean isEdge(int source, int target)
	{
		return roadWeight[source][target] != null;
	}
	public int[] neighbors(int city)
	{
		int i;
		int count = 0;
		int []answers;
		
		for(i = 0; i < cityInfo.length; i++)
		{
			if(isEdge(city,i))
			{
				count++;
			}
		}
		answers = new int[count];
		count = 0;
		for(i = 0; i < cityInfo.length; i++)
		{
			if(isEdge(city, i))
			{
				answers[count++] = i;
			}
		}
		return answers;
		
	}
	public int size()
	{
		return cityInfo.length;
	}
	public void newCityInfoGraph()
	{
		this.cityInfo = Arrays.copyOf(cityInfo, cityInfo.length + cityInfo.length / 2);
	}

}
