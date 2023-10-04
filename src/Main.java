import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.xml.stream.events.Namespace;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<String> deckNamesList = new ArrayList<>();
	ArrayList<Integer> quantitiesList = new ArrayList<>();
	ArrayList<String> randomNumberList = new ArrayList<>();

	public Main() {
		Integer chosenNumber = 0;
		String randomId = "";
		do {
			printGreetings();
			chosenNumber = chooseMenu();
			randomId = randomDeckId();
			
			if(chosenNumber == 1) {
				menu1();
			}else if(chosenNumber == 2) {
				menu2();
			}else if(chosenNumber == 3) {
				menu3();
			}
			
		}while(chosenNumber != 4);
		
		System.out.println("Goodbye!");
		
	}
	
	void printGreetings() {
		System.out.println("Finished Orders: " + deckNamesList.size());
		System.out.println("\n1. Order Kard Deck");
		System.out.println("2. View All Kard Decks");
		System.out.println("3. Send Kard Deck Order");
		System.out.println("4. Exit");
	}
	
	Integer chooseMenu() {
		int choose = 0;
		
		System.out.print(">> ");
		choose = scan.nextInt();
		scan.nextLine();
		
		return choose;
	}
	
	String randomDeckId() {
		Random number = new Random();
		
		int randomNumber1 = number.nextInt(10);
		String rN1 = String.valueOf(randomNumber1);
		
		int randomNumber2 = number.nextInt(10);
		String rN2 = String.valueOf(randomNumber2);
		
		int randomNumber3 = number.nextInt(10);
		String rN3 = String.valueOf(randomNumber3);
		
		String deckId = rN1 + rN2 + rN3;
		
		randomNumberList.add(deckId);
		
		return deckId;
	}
	
	void menu1() {
		if(deckNamesList.size() == 10) {
			System.out.println("You've reached the maximum number of orders...");
		}else {
			String name = "";
			
			do {
				System.out.print("Input Deck name [At least 10 characters and ends with 'Deck']: ");
				name = scan.nextLine();
			}while(name.length() < 10 || !name.endsWith("Deck"));
			
			int quantity = 0;
			
			do {
				System.out.print("Input Quantity [At least 10]: ");
				quantity = scan.nextInt();
				scan.nextLine();
			}while(quantity < 10);
			
			deckNamesList.add(name);
			quantitiesList.add(quantity);
			
			System.out.println("Kard Deck Ordered...");
		}
	}
	
	void menu2() {
		if(deckNamesList.isEmpty()) {
			System.out.println("There are no orders...");
		}else {
			for(int i = 0; i < deckNamesList.size() - 1; i++) {
				for(int j = 0; j < deckNamesList.size() - i - 1; j++) {
					if(deckNamesList.get(j).compareTo(deckNamesList.get(j + 1)) > 0) {
						Collections.swap(deckNamesList, j, j + 1);
					}
				}
			}
			for(int i = 0; i < deckNamesList.size(); i++) {
				System.out.println((i + 1) + " | " + randomNumberList.get(i) + " | " + deckNamesList.get(i) + " | " + quantitiesList.get(i) + " | ");
				
			}
		}
	}
	
	void menu3( ) {
		if(deckNamesList.isEmpty()) {
			System.out.println("There are no orders...");
		}else {
			for(int i = 0; i < deckNamesList.size() - 1; i++) {
				for(int j = 0; j < deckNamesList.size() - i - 1; j++) {
					if(deckNamesList.get(j).compareTo(deckNamesList.get(j + 1)) > 0) {
						Collections.swap(deckNamesList, j, j + 1);
					}
				}
			}
			
			int index = 0;
			do {
				System.out.print("Input Order to Send [1-1]: ");
				index = scan.nextInt();
				scan.nextLine();
			}while(index < 1 || index > deckNamesList.size());
			
			index -= 1;
			deckNamesList.remove(index);
			quantitiesList.remove(index);
			
			System.out.println("Order Completed...");
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
