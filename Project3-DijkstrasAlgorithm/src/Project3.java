import java.io.*;
import java.util.*;

public class Project3 {
	private Graph<City> cities;
	
	public Project3()
	{
		cities = new Graph<>();
	}
	public void addCity(int number, String cityCode, String cityName, int population, int elevation)
	{
		cities.addCityInfo(new City(number, cityCode, cityName, population, elevation));
	}
	public void readCityData()
	{
		String fileInput = null;
		String []lineArr = null;
		try {
			FileReader fileReader = new FileReader("city.dat.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((fileInput = bufferedReader.readLine()) != null)
			{
				lineArr = stringTokenizer(fileInput);
				if(lineArr.length == 0)
					return;
				if(Character.isDigit(lineArr[3].charAt(0)))
				{
					addCity(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], Integer.parseInt(lineArr[3]), Integer.parseInt(lineArr[4]));
				}
				else
				{
					addCity(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2] +lineArr[3], Integer.parseInt(lineArr[4]), Integer.parseInt(lineArr[5]));
					
				}
				
				System.out.println(fileInput);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void readRoadData()
	{
		cities.setRoadWeightLinkedList();
		String fileInput = null;
		String []lineArr = null;
		try {
			FileReader fileReader = new FileReader("road.dat.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((fileInput = bufferedReader.readLine()) != null)
			{
				lineArr = stringTokenizer(fileInput);
				if(lineArr.length == 0)
					return;
				cities.setRoadWeight(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]));
				System.out.println(fileInput);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String [] stringTokenizer(String line)
	{
		ArrayList <String> tempList = new ArrayList<>();
		String []tempArray = line.split(" ");
		for(int i = 0; i < tempArray.length; i++)
		{
			if(!tempArray[i].equals(""))
				tempList.add(tempArray[i]);
		}
		tempArray = new String[tempList.size()];
		return tempList.toArray(tempArray);
	}
	public City[] Dijkstra(int source)
	{
		source = source - 1;
		LinkedList<City> vertices = cities.getCityInfo();
		City []previous = new City[vertices.size()];
		PriorityQueue<Integer> priorityVertice = new PriorityQueue<>();
		int []distance = new int[vertices.size()];
		for(int i = 0; i < vertices.size(); i++)
		{
			distance[i] = Integer.MAX_VALUE;
			previous[i] = new City();
			priorityVertice.add(distance[i]);
			
			
		}
		
		distance[source] = 0;
		priorityVertice.add(distance[source]);
		
		while(!priorityVertice.isEmpty())
		{ 
			int smallestIndex = indexForSmallestDistance(priorityVertice.remove(), distance);
			
			if(smallestIndex == -99)
				break;
			if(distance[smallestIndex] == Integer.MAX_VALUE)
				break;
			
			City smallestCity = vertices.get(smallestIndex);
			Road []smallestCityNeighbor = cities.neighbors(smallestIndex);
			for(int i = 0; i < smallestCityNeighbor.length; i++)
			{
				int alt = distance[smallestIndex] + smallestCityNeighbor[i].getWeight();
				int cityNeighbor = smallestCityNeighbor[i].getTarget().getNumber() - 1;
				if (alt < distance[cityNeighbor])
				{
					int temp = distance[cityNeighbor];
					distance[cityNeighbor] = alt;
					previous[cityNeighbor] = smallestCity;
					priorityVertice.remove(temp);
					priorityVertice.add(alt);
					System.out.println(distance[smallestCityNeighbor[i].getTarget().getNumber() - 1]);
				}
			}
			System.out.println(smallestCity);
			
			
		}
		
		
		
		return previous;
	}
	public int indexForSmallestDistance(int value, int[] vertex)
	{
		for(int i = 0; i < vertex.length; i++)
		{
			if(vertex[i] == value)
				return i;
		}
		return -99;
	}
	class MyComparator implements Comparator<Graph>
	{
		public int compare(Integer a, Integer b)
		{
			if(a > b)
				return 1;
			if (a < b)
				return -1;
			return 0;
		}

		@Override
		public int compare(Graph o1, Graph o2) {
			
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project3 test = new Project3();
		test.readCityData();
		test.readRoadData();
		test.Dijkstra(2);
		System.out.println();

	}

}
