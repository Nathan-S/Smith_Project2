/**
* This class operates as a priority queue using an array as the data structure. The countries 
* are inserted into the array using the insert method and removed from the queue using the remove method.
* isfull method can be used to check if the queue is full and isempty can be used to check if the queue
* is empty.
*
* @author Nathanial Smith
* @version 10/01/2020
*/
public class Priority {
	private int Size;
	private Country[] countries;
	private int Back = 0;
	private int Front = 0;
	
	/**
	* This is the constructor for the Priority class. size is passed as a parameter and then Size is updated to be = to  size. Then
	* a new countries array is made with Size being passed in to determine the length.
	*
	* @param int size - passed in to determine size of stack
	*/
	public Priority(int size) {
		Size = size;
		countries = new Country[Size];
	}
	
	/**
	* This method inserts a country object that is passed in as a parameter. If the queue is empty then the country is inserted at index 0 and then Back increases.
	* Otherwise it loops staring at the top/back of the queue and determines at which element the object belongs based on CFR. The lower the CFR the higher the priority. 
	* The object is then inserted into the queue and Back is increased by one.
	*
	* @param Country country - This is a country that is being passed in to be inserted into the Queue.
	*/
	public void insert(Country country) {
		
		int j; 
		
		if(Back == 0) {
			countries[Back++] = country;
		} else {
			for(j = Back - 1; j >= 0; j--) {
				if(country.Get_CFR() < countries[j].Get_CFR()) {
					countries[j+1] = countries[j];
				} else {
					break;
				}
			}
			
			countries[j+1] = country;
			Back++;
		}
		
		
	}		
	
	/**
	*This method returns a Country object. this method removes an object from the stack by returning countries at index Front and then front is increased by one.
	*@return countries[Front++] - this returns an object Country from index front in the countries array and then Front is increased by 1.
	*/
	public Country remove() {
		return countries[Front++];
	}
	
	/**
	*This method prints the queue. the loop runs through all of the countries in the stack as long as j < 153 and countries[j] is not == to null
	* and then it calls on the countries at index j for their information.
	*/
	public void printQueue() {
		int j = 0;
		System.out.println("Name                               Capitol              Population      GDP             Cases     Deaths");
        System.out.println("--------------------------------------------------------------------------------------------------------");
		while(j < 153 && countries[j] != null){
			System.out.printf("%-32s   %-14s\t%-10d\t", countries[j].Get_Name(), countries[j].Get_Capitol(), countries[j].Get_Population());
			System.out.printf("%-14.0f", countries[j].Get_GDP());
			System.out.printf("\t%-7d\t  %-7d\n", countries[j].Get_Covid_Cases(), countries[j].Get_Covid_Deaths());
			j++;
		}
	}
	
	/**
	* This method uses if and else to determine if the queue is empty based on whether Back is == to Front, if it is then true is returned because it is empty, otherwise
	* it has something in it and false is returned.
	*
	* @return true - returns true if it's empty
	* @return false - returns false if it's not empty
	*/
	public boolean isEmpty() {
		if(Front == Back) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	* This method uses if and else to determine if the queue is full based on whether Back is == to Size - 1, if it is then true is returned because it is full, otherwise
	* it is not full and false is returned.
	* 
	* @return true - returns true if it's full
	* @return false - returns false if it's not full
	*/
	public boolean isFull() {
		if(Back == Size-1) {
			return true;
		} else {
			return false;
		}
	}
}