/**
 * This Class acts as the object Country. This class contains a constructor that takes parameters
 * for the object name, capital, population, GDP, Covid-19 cases, and Covid-19 deaths. There are getter
 * and setter methods for each field of name, capital, population, GDP, Covid-19 cases, and Covid-19 deaths.
 * There are methods that compare two names, calculate CFR, calculate GDP per capita, and two print statements that
 * are formatted to print one country or all countries.
 * 
 * @author Nathanial Smith
 * @version 10/01/2020
 */
public class Country {
	
	private String Name;
	private String Capitol;
	private Long Population;
	private Double GDP;
	private Long Covid_Cases;
	private Long Covid_Deaths;
	
	/**
	 * This is the class constructor, it takes a string for name, String for capital, Long for population, cases and deaths, and a Double for gdp
	 * 
	 * @param String name is the the value passed in to be used as the objects Name, @param String capitol is the the value that will be used for Capitol,
	 * @param Long population is the value that will be used for Population, @param Double gdp is the value that will be used for GDP, 
	 * @param Long cases is the value that will be used for Covid_Cases, @param Long deaths is the value that will be used for Covid_Deaths
	 */
	Country(String name, String capitol, Long population, Double gdp, Long cases, Long deaths) {
		Name = name;
		Capitol = capitol;
		Population = population;
		GDP = gdp;
		Covid_Cases = cases;
		Covid_Deaths = deaths;
	}
	/**
	* Gets the Name of the object
	* @return returns the value for Name
	*/
	public String Get_Name() {
		
		return Name;
	}
	
	/**
	* This method Sets the Name for the current object
	* @param passes in a String value for the Name
	*/
	public void Set_Name(String Name) {
		this.Name = Name;
	}
	
	/**
	* Gets the Capital of the object
	* @return returns the value for Capitol
	*/
	public String Get_Capitol() {
		return Capitol;
	}
	
	/**
	* This method Sets the capital for the current object
	* @param passes in a String value for the Capital
	*/
	public void Set_Capitol(String Capitol) {
		this.Capitol = Capitol;
	}
	
	/**
	* Gets the Population of the object
	* @return returns the value for Population
	*/
	public Long Get_Population() {
		return Population;
	}
	
	/**
	* This method Sets the population for the current object
	* @param passes in a Long value for the Population
	*/
	public void Set_Population(Long Population) {
		this.Population = Population;
	}
	
	/**
	* Gets the GDP of the object
	* @return returns the value for GDP
	*/
	public Double Get_GDP() {
		return GDP;
	}
	
	/**
	* This method Sets the GDP for the current object
	* @param passes in a Double value for the GDP
	*/
	public void Set_GDP(Double GDP) {
		this.GDP = GDP;
	}
	
	/**
	* Gets the Covid-19 cases of the object
	* @return returns the value for Covid_Cases
	*/
	public Long Get_Covid_Cases() {
		return Covid_Cases;
	}
	
	/**
	* This method Sets the Covid-19 cases for the current object
	* @param passes in a Long value for the Covid_Cases
	*/
	public void Set_Covid_Cases(Long Covid_Cases) {
		this.Covid_Cases = Covid_Cases;
	}
	
	/**
	* Gets the Covid-19 deaths of the object
	* @return returns the value for Covid_Deaths
	*/
	public Long Get_Covid_Deaths() {
		return Covid_Deaths;
	}
	
	/**
	* This method Sets the Covid-19 Deaths for the current object
	* @param passes in a Long value for the Covid_Deaths
	*/
	public void Set_Covid_Deaths(Long Covid_Deaths) {
		this.Covid_Deaths = Covid_Deaths;
	}
	
	
	/**
	* This method calculates the country's cfr by dividing deaths by cases
	*/
	public Double Get_CFR() {
		Double cfr, deaths, cases;
		deaths = (double)Covid_Deaths;
		cases = (double)Covid_Cases;
		cfr = deaths / cases;
		return cfr;
	}
}