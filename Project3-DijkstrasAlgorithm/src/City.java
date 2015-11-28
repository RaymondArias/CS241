
public class City {
	private int number;
	private String cityCode;
	private String cityName;
	private int population;
	private int elevation;
	
	public City()
	{
		number = 0;
		cityCode = null;
		cityName = null;
		population = 0;
		elevation = 0;
	}
	public City(int number, String cityCode, String cityName,
			int population, int elevation)
	{
		this.number = number;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.population = population;
		this.elevation = elevation;
	}
	public int getNumber() 
	{
		return number;
	}
	public void setNumber(int number) 
	{
		this.number = number;
	}
	public String getCityCode() 
	{
		return cityCode;
	}
	public void setCityCode(String cityCode) 
	{
		this.cityCode = cityCode;
	}
	public String getCityName() 
	{
		return cityName;
	}
	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}
	public int getPopulation() 
	{
		return population;
	}
	public void setPopulation(int population) 
	{
		this.population = population;
	}
	public int getElevation() 
	{
		return elevation;
	}
	public void setElevation(int elevation) 
	{
		this.elevation = elevation;
	}
	

}
