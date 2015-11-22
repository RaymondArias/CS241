
public class Project3 {
	private Graph<City> cities;
	
	public Project3()
	{
		cities = new Graph<>(20);
	}
	public void addCity(int number, String cityCode, String cityName, int population, int elevation)
	{
		cities.addCityInfo(new City(number, cityCode, cityName, population, elevation));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
