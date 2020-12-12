/**
* This class operates as a stack using a an array data structure. Countries are entered into the 
* stack using the push method that pushes country objects into the next index. The pop method 
* removes the first country object and removes it. isfull returns true if it is full and isempty returns true if the stack is empty.
* The printStack method prints every item in the stack by popping the item.
*
* @author Nathanial Smith
* @version 10/01/2020
*/
public class Stack {
	private int Size;
	private Country[] countries;
	private int Back = 0;
	
	/**
	* This is the constructor of the Stack class. the size is passed in as a parameter and then the objects Size is updated. 
	* then a new array of countries[] is created based on the Size
	*
	* @param int size - passed in to declare size of priority queue
	*/
	Stack(int size) {
		Size = size;
		countries = new Country[Size];
	}
	
	/**
	* The push method will take in a parameter of a country object and then set countries[] at the index "Back" = to the passed in country and
	* at the end Back will be incremented by 1.
	*
	* @param Country country - this is a country object
	*/
	public void push(Country country) {
		countries[Back] = country;
		Back++;
	}
	
	/**
	* This method returns a Country object. First a temp Country object is made with null parameters. Then temp is set
	* equal to countries at index Back - 1. Then Back is decremented by 1 and temp is returned.
	*
	* @return temp - temp is a Country object 
	*/
	public Country pop() {
		Country temp = new Country(null, null, null, null, null, null);
		temp = countries[Back - 1];
		Back--;
		return temp;
	}
	
	/**
	* This queue prints the stack by creating a temporary Country object. Then a for loop 
	* runs as long as j < 153 and  countries[j] is not equal to null. Then a country is popped 
	* from the stack and set = to the temporary Country and then the different aspects of the temp1 are printed.
	*
	*/
	public void printStack() {
		int j = 0;
		Country temp1 = new Country(null, null, null, null, null, null);
		System.out.println("Name                               Capitol              Population      GDP             Cases     Deaths");
        System.out.println("--------------------------------------------------------------------------------------------------------");
		while(j < 153 && countries[j] != null){
			temp1 = pop();
			System.out.printf("%-32s   %-14s\t%-10d\t", temp1.Get_Name(), temp1.Get_Capitol(), temp1.Get_Population());
			System.out.printf("%-14.0f", temp1.Get_GDP());
			System.out.printf("\t%-7d\t  %-7d\n", temp1.Get_Covid_Cases(), temp1.Get_Covid_Deaths());
			j++;
		}
	}
	
	/**
	* This method uses if and else to determine if the stack is empty based on whether Back is less than 0, if it is then true is returned because it is empty, otherwise
	* it has something in it and false is returned.
	*
	* @return true - returns true if it's empty
	* @return false - returns false if it's not empty
	*/
	public boolean isEmpty() {
		if(Back < 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	* This method uses if and else to determine if the stack is full based on whether Back is greater than Size - 1, if it is then true is returned because it is full, otherwise
	* it is not full and false is returned.
	* 
	* @return true - returns true if it's full
	* @return false - returns false if it's not full
	*/
	public boolean isFull() {
		if(Back > Size - 1) {
			return true;
		} else {
			return false;
		}
	}
}
