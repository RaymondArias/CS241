
import java.util.*;

public class Graph <E>{
	private LinkedList<E> cityInfo;		
	private LinkedList<Road>[]roadWeight;
	
	public Graph()
	{
		roadWeight = null;
		cityInfo = new LinkedList<>();
	}
	public void addCityInfo(E newCity)
	{
		cityInfo.add(newCity);
		
	}
	public void setCityInfo(int vertex, E newCity)
	{
		cityInfo.add(vertex, newCity);
	}
	public void setRoadWeightLinkedList()
	{
		roadWeight = new LinkedList[cityInfo.size()];
		for(int i = 0; i < roadWeight.length; i++)
			roadWeight[i] = new LinkedList<>();
	}
	public void setRoadWeight(int source, int target, int weight)
	{
		Road tempRoad = new Road((City) cityInfo.get(target - 1), weight);
		roadWeight[source-1].add(tempRoad);
		
		
	}
	public LinkedList<E> getCityInfo() {
		return cityInfo;
	}
	public void setCityInfo(LinkedList<E> cityInfo) {
		this.cityInfo = cityInfo;
	}
	public LinkedList<Road>[] getRoadWeight() {
		return roadWeight;
	}
	public LinkedList<Road> getRoadWeights(int source)
	{
		return roadWeight[source];
	}
	public void setRoadWeight(LinkedList<Road>[] roadWeight) {
		this.roadWeight = roadWeight;
	}
	public boolean isEdge(int source, int target)
	{
		//return roadWeight[source][target] != null;
		return true;
	}
	public Road[] neighbors(int city)
	{
		Road []retRoads = new Road[roadWeight[city].size()];
		retRoads = roadWeight[city].toArray(retRoads);
		return retRoads;
		
		
	}
	public int size()
	{
		return cityInfo.size();
	}
	/*public void newCityInfoGraph()
	{
		this.cityInfo = Arrays.copyOf(cityInfo, cityInfo.length + cityInfo.length / 2);
	}*/

}
