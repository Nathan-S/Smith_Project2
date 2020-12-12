import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
* COP 3530: Project 2 – Stacks and Priority Queues
* <p>
* Description of the class using as many lines as needed
* with <p> between paragraphs. Including descriptions of the
* input required and output generated.
* 
* This is the driver file that reads in 153 countries from a csv file and then enters the countries into 5
* Priority Queues based on their Covid fatality rate and then printed. Then the countries are removed from one Queue at a time
* and pushed into a stack which is then printed.
* <p>
* The file starts by creating a global Country[] array with a size of 153 then the program enters main. It starts by creating a scanner and creeating 5 Priority objects with size
* passed in as the parameter. A Stack object is then created and the size is passed in as the parameter. Then the BufferedReader is created and set = to null two delimiters are made for "," and " ".
* Two Strings name and capitol, Double gdp, three Longs; population, cases, and deaths are all initialized. Then a While loop is made until i is not == to 0. Then a line is read and
* a new while loop is entered that runs until the file returns null data. This while loop enters a try statement and reads six indexes separated by commas and then assigns the data to 
* the 6 variables from earlier and passes them as parameters to a country object at index i. There are two catches, FileNotFoundException and IOException. Then a for loop is entered that 
* runs through the array country[] and begins to pass them into the appropriate Priority object based on that country's CFR. This is done using if/else statements and before a country is entered into a
* Priority, the statement checks if it is full if its full it doesn't enter the country. If it's not full it enters the country. After the loop, the contents of all 5 Priority objects are printed.
* <p>
* Finally, a temp Country object is created. Then there are 5 while loops that remove an item from the Priority object and then push it onto the stack while also checking if the stack is full before it tries 
* to push something. Once everything is pushed onto the stack, then the contents of the stack are printed and the program ends.
* 
*
* @author Nathanial Smith
* @version 10/2/2020
*/

public class Project2 {
	static Country[] country = new Country[153];
	
	public static void main(String[] args) {
		System.out.println("COP3530 Project 2");
		System.out.println("Instructor: Xudong Liu\n");
		System.out.println("Stacks and Priority Queues\n\n");
		
		Scanner input = new Scanner(System.in);
		
		Priority excellent = new Priority(153);
		Priority vgood = new Priority(153);
		Priority good = new Priority(153);
		Priority fair = new Priority(153);
		Priority poor = new Priority(153);
		
		Stack stack = new Stack(153);
		
		System.out.print("Enter name of file: ");
		
		BufferedReader read = null;
		String split = ",";
		String line = "";
		
		String name, capitol;
		Double gdp;
		Long population, cases, deaths;
		
		int i = 0;
		while(i == 0) {
			
			String file = input.nextLine();
			try {
			
				read = new BufferedReader(new FileReader(file));
				read.readLine();
				while ((line = read.readLine()) != null) {
					String[] countries = line.split(split);
				
				
					name = countries[0];
					capitol = countries[1];
					population = Long.parseLong(countries[2]);
					gdp = Double.parseDouble(countries[3]);
					cases = Long.parseLong(countries[4]);
					deaths = Long.parseLong(countries[5]);
				
					country[i] = new Country(name, capitol, population, gdp, cases, deaths);
				
					i++;
				}
				
					read.close();
				}
			catch(FileNotFoundException e) {
				System.out.println("Can't open file");
				System.out.print("Enter the name of the file: ");
			}
			catch(IOException e) {
				System.out.println("Problem with reading file");
	
	
			}
		}
		
		
		for(int j = 0; j < 153; j++) {
			
			if(country[j].Get_CFR() < .01) {
				if(excellent.isFull()) {
					System.out.println("Stack is full");
				} else {
					excellent.insert(country[j]);
				}
			} else if (country[j].Get_CFR() < .02 && country[j].Get_CFR() >= .01) {
				if(vgood.isFull()) {
					System.out.println("Stack is full");
				} else {
					vgood.insert(country[j]);
				}
			} else if (country[j].Get_CFR() < .05 && country[j].Get_CFR() >= .02) {
				if(good.isFull()) {
					System.out.println("Stack is full");
				} else {
					good.insert(country[j]);
				}
			} else if (country[j].Get_CFR() < .1 && country[j].Get_CFR() >= .05) {
				if(fair.isFull()) {
					System.out.println("Stack is full");
				} else {
					fair.insert(country[j]);
				}
			} else if (country[j].Get_CFR() >= .1) {
				if(poor.isFull()) {
					System.out.println("Stack is full");
				} else {
					poor.insert(country[j]);
				}
			}
			
		}
		
		System.out.println("\nPOOR Priority Queue Contents: \n");
		poor.printQueue();
		System.out.println("\nFAIR Priority Queue Contents: \n");
		fair.printQueue();
		System.out.println("\nGOOD Priority Queue Contents: \n");
		good.printQueue();
		System.out.println("\nVGOOD Priority Queue Contents: \n");
		vgood.printQueue();
		System.out.println("\nExcellent Priority Queue Contents: \n");
		excellent.printQueue();
		
		Country temp = new Country(null, null, null, null, null, null);
		
		while(!poor.isEmpty()) {
			temp = poor.remove();
			if(stack.isFull()) {
				System.out.println("Stack is full");
			} else {
				stack.push(temp);
			}
		}
		
		while(!fair.isEmpty()) {
			temp = fair.remove();
			if(stack.isFull()) {
				System.out.println("Stack is full");
			} else {
				stack.push(temp);
			}
		}
		
		while(!good.isEmpty()) {
			temp = good.remove();
			if(stack.isFull()) {
				System.out.println("Stack is full");
			} else {
				stack.push(temp);
			}
		}
		
		while(!vgood.isEmpty()) {
			temp = vgood.remove();
			if(stack.isFull()) {
				System.out.println("Stack is full");
			} else {
				stack.push(temp);
			}
		}
		
		while(!excellent.isEmpty()) {
			temp = excellent.remove();
			if(stack.isFull()) {
				System.out.println("Stack is full");
			} else {
				stack.push(temp);
			}
		}
		
		System.out.println("\n\nStack Contents: \n");
		stack.printStack();
		
	}
	

}
