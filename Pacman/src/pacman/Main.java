package pacman;

import java.util.Scanner;

public class Main {
	int x,y;
	String f;
	Location loc = new Location();
	Boolean running = true;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}
	
	//showMenu to give an overview of the program
	
	public void showMenu() {
		System.out.println("Welcome to the Pacman Simulator");
		System.out.println("The permitted inputs are:");
		System.out.println("0 to 4: For row positions (X-axis)");
		System.out.println("0 to 4: For column positions (Y-axis)");
		System.out.println("Commands: \nPLACE X,Y,F - put the Pacman on the grid in positon X,Y and facing NORTH,SOUTH, EAST or WEST.\n"+
				"MOVE - move Pacman one unit forward in the direction it is currently facing.\r\n"+
				"LEFT - rotate Pacman 90 degrees in the LEFT without changing the position of Pacman.\r\n"+
				"RIGHT - rotate Pacman 90 degrees in the RIGHT without changing the position of Pacman.\r\n"+
				"REPORT - announce the X,Y and F of Pacman.");
		System.out.println("\nEnter 1 to Start  the Game.");	
		Scanner obj = new Scanner(System.in);
		String input = obj.nextLine();
		processShowMenuChoice(input);
	}
	
	public void processShowMenuChoice(String choice) {
	
		if(choice.equals("1")) {
			startGame();
		}
		else {
			showMenu();
		}
	}
	
	//startGame() to run all the functionalities of the program
	
	public void startGame() {
		Scanner myObj = new Scanner(System.in);
		
		// initial values, which the user can't see (to make sure the program runs without errors
		int x =9;
		int y=9;
		String f = "top";
		
		do {
			System.out.println("Please enter the commands or enter 'end' to finish the game:");
			String inputCommand = myObj.nextLine();
			String command = inputCommand.toUpperCase();
			
			// to set the place if it is valid or not
			if(command.contains("PLACE")) {
				String[] arrOfStr = command.split(",", -2); 
				String xTemp1 = arrOfStr[0].replaceAll("\\s+","");
				int xTemp = Integer.parseInt(xTemp1.substring(xTemp1.length()-1, xTemp1.length()));
				int yTemp = Integer.parseInt(arrOfStr[1].replaceAll("\\s+",""));
				String fTemp = arrOfStr[2].replaceAll("\\s+","");
				if(loc.CheckLocation(xTemp, yTemp, fTemp)) {
					x = xTemp; y = yTemp; f = fTemp;
				}
				else {System.out.println("Invalid position try again");}
			}
			
			// conditions to rotate the face depending upon the current position
			else if(command.contains("LEFT")) {
				if(f.equals("NORTH")) { f = "WEST";}
				else if(f.equals("SOUTH")) { f = "EAST";}
				else if(f.equals("EAST")) { f = "NORTH";}
				else if(f.equals("WEST")) { f = "SOUTH";}
			}
			else if(command.contains("RIGHT")) {
				if(f.equals("NORTH")) { f = "EAST";}
				else if(f.equals("SOUTH")) { f = "WEST";}
				else if(f.equals("EAST")) { f = "SOUTH";}
				else if(f.equals("WEST")) { f = "NORTH";}
			}
			
			// conditions to check if the move is possible or not
			else if(command.contains("MOVE")) {
				if(f.equals("NORTH")) {
					int yNew = y+1;
					if(loc.CheckLocation(x, yNew, f)) {
						y = yNew;
					} else {System.out.println("move not possible");}
				}
				else if(f.equals("SOUTH")) { 
					int yNew = y-1;
					if(loc.CheckLocation(x, yNew, f)) {
						y = yNew;
					} else {System.out.println("move not possible");}
				}
				else if(f.equals("EAST")) { 
					int xNew = x+1;
					if(loc.CheckLocation(xNew, y, f)) {
						x = xNew;
					} else {System.out.println("move not possible");}
				}
				else if(f.equals("WEST")) { 
					int xNew = x-1;
					if(loc.CheckLocation(xNew, y, f)) {
						x = xNew;
					} else {System.out.println("move not possible");}
				}
			}

			// condition to show the final location if it is valid
			else if(command.contains("REPORT")) {
				if(loc.CheckLocation(x, y, f)) {
					System.out.println("OUTPUT: "+x+","+y+","+f);
					
				}
				else if(!loc.CheckLocation(x, y, f)) {
					System.out.println("Please enter a valid location first (PLACE).");
				}
			}
			// condition to end the game
			else if(command.contains("END")) {
				running = false;
				System.out.println("Thanks for playing the game");
			}
				
		} while (running);
		
	}

}
