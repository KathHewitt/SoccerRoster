/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author kathr_000
 */
import java.util.Scanner;
import java.util.ArrayList;

public class PlayerRoster {
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String args[]) {

      ArrayList<Player> myTeam = new ArrayList<Player>();
		
		initializeRoster(myTeam);
		menu(myTeam);
        
      System.out.println("End of PlayerRoster run.");
	}
	
	public static void initializeRoster(ArrayList<Player> team) {		

      int numPlayers = 0;
      String name;
      
      do {
         Player player = new Player();
         
         System.out.print("Enter player name (hit enter to quit): ");
         name = scnr.nextLine();
         player.setName(name);
         
         if (!name.equals("")) {
      
            System.out.print("Enter " + player.getName() + "'s jersey number: ");
            player.setJerseyNum(scnr.nextInt());
      
            System.out.print("Enter " + player.getName() + "'s rating: ");
            player.setRating(scnr.nextInt());
      
            team.add(player);
            numPlayers++;
         
            scnr.nextLine();
         }
         
         System.out.println("");
         
      } while (!name.equals(""));
         
      System.out.println(numPlayers + " players were entered.");
    }
	
	public static void outputRoster(ArrayList<Player> team) {

      System.out.println("Team is: ");
      
      Player currentPlayer;
      
      for (int i = 0; i < team.size(); i++) {
         currentPlayer = team.get(i);
         System.out.println("\t" + currentPlayer.getName() + " has jersey number " + currentPlayer.getJerseyNum() + " and rating " + currentPlayer.getRating());
      }
      
      System.out.println("End of team.");
	}
	
	public static void updateRating(ArrayList<Player> team) {
      /* Complete this method so that it updates the rating of a player
         identified by their jersey number.
           
         Here are the prompts/messages:
         System.out.print("Enter a new rating for player: ");
         System.out.println("There is no player with jersey number: " + playerJersey);
      */
		System.out.print("Enter a jersey number: ");
		int playerJersey = scnr.nextInt();
		
		Player currentPlayer;
		int i = 0;
		boolean found = false;
		
		while ((i < team.size()) && (!found)) {
		   currentPlayer = team.get(i);
		   if (currentPlayer.getJerseyNum() == playerJersey) {
		      found = true;
		   }
		   i++;
		}
		
		if (!found) 
		   System.out.println("There is no player with jersey number: " + playerJersey);
		 
		else {
		   System.out.print("Enter a new rating for player: ");
		   int newRating = scnr.nextInt();
		
		   while ((i < team.size()) && (!found)) {
		      currentPlayer = team.get(i);
		      if (currentPlayer.getJerseyNum() == playerJersey) {
		         found = true;
		         team.remove(currentPlayer);
		         Player player = new Player(currentPlayer.getName(), currentPlayer.getJerseyNum(), newRating);
		         team.set(i, player);
		      }
		      i++;
		   }
		}
		
		
        
	}
	
	public static void outputHighRated(ArrayList<Player> team) {
      /* Complete this method so that it outputs all the players with
         a rating above the user entered rating.
           
         Here is the message:
         System.out.println("\nPlayers above rating " + highRating + ":");
      */
		System.out.print("Enter the rating: ");
		int highRating = scnr.nextInt();
		System.out.println("\nPlayers above rating " + highRating + ":");
		
		Player currentPlayer;
		
		for (int i = 0; i < team.size(); i++) {
		   currentPlayer = team.get(i);
		   if (currentPlayer.getRating() > highRating) {
		      System.out.println("\t" + currentPlayer.getName() + " has jersey number " + currentPlayer.getJerseyNum() + " and rating " + currentPlayer.getRating());
		   }
		}
	}
	
	public static void replacePlayer(ArrayList<Player> team) {
      /* Complete this method so that it replaces a player on the team
         with another player. Be sure to handle the following situations:
         - user entered name is not in the roster
         - user entered jersey number already used by another player
           
         Here are the prompts/messages:
         System.out.println("Enter the new player's name: ");
         System.out.println("Player: " + toReplace + " not in the roster.");
         System.out.print("Enter jersey number for " +  + ": ");
         System.out.println("Jersey number " +  + " is already taken by player " +  + "\nTry again.");
         System.out.print("Enter rating for new player " +  + ": ");
      */
      System.out.println("Enter player's name: ");
		String toReplace = scnr.next();
		
		Player currentPlayer;
		int i = 0;
		boolean foundName = false;
		boolean foundJersey = false;
		
		while ((!foundName) && (i < team.size())) {
		   currentPlayer = team.get(i);
		   if (currentPlayer.getName().equals(toReplace))
		      foundName = true;
		   i++;
		}     
		      
		if (!foundName)
		   System.out.println("Player: " + toReplace + " not in the roster.");
		 
		else {
		   System.out.println("Enter the new player's name:");
		   String newPlayerName = scnr.next());
		
		   System.out.print("Enter jersey number for " + newPlayerName + ": ");
		   int newJersey = scnr.nextInt();
		
		   i = 0;
		
		   while ((!foundJersey) && (i < team.size())) {
		      currentPlayer = team.get(i);
		      if (currentPlayer.getJerseyNum() == newJersey) {
		         foundJersey = true;
		         System.out.println("Jersey number " + newJersey + " is already taken by player " + currentPlayer.getName() + "\nTry again.");
		      }
		      i++;
   		}
   		
   	   if (!foundJersey) {
		      System.out.println("Enter rating for new player:");
		      int newRating = scnr.nextInt();
		   
		      boolean playerReplaced = false;
		
		      while ((i < team.size()) && (!playerReplaced)) {
		         currentPlayer = team.get(i);
		   
		         if (currentPlayer.getName().equals(toReplace)) {
		            team.remove(i);
   		         Player newPlayer = new Player (newPlayerName, newJersey, newRating);
   		         team.add(i, newPlayer);
		         }
		   
		      i++;
		      }
   	   }
		}
	}
		
	
	public static void menu(ArrayList<Player> team) {
        /* This method is complete. Do not modify it.
        */
		char menuOp;
		do {
			System.out.println("\nMENU");
			System.out.println("u - Update player rating");
			System.out.println("h - Output players above a rating");
			System.out.println("r - Replace player");
			System.out.println("o - Output roster");
			System.out.println("q - Quit");
	  
			System.out.println("\nChoose an option:");
			menuOp = scnr.next().toUpperCase().charAt(0);

			if (menuOp != 'Q')
				switch (menuOp) {
					case 'U' :	updateRating(team);
								break;
					case 'H' :	outputHighRated(team);
								break;
					case 'R' :	replacePlayer(team);
								break;
					case 'O' :	outputRoster(team);
								break;
					default	 :	System.out.println("Illegal menu item.");
								break;
				}
		} while (menuOp != 'Q');
	}	
}