/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaconversion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ronda
 */
public class JavaConversion {
    
    static ArrayList<Player> players = new ArrayList<Player>();

    public static void main(String[] args) {        
        prepopulatePlayersList();
        displayMainMenu();

    
        
    } // main
    
    static void displayMainMenu(){
        // Main Menu options
        System.out.println("MAIN MENU");
        System.out.println("1 - Display all players");
        System.out.println("2 - Display players with odd numbers");
        System.out.println("3 - Display players that start with a letter");
        System.out.println("4 - Add player");
        // Prompt user for selection
        System.out.println("Please enter the number of your selection: ");
        String userSelection = returnUserSelection();
       displayUserSelectionFromMainMenu(userSelection);
    } // displayMainMenu()
    
    static String returnUserSelection(){
        Scanner scanner = new Scanner(System.in);  // Create a scanner object 
        String userSelection = scanner.nextLine(); // Read user input 
        return userSelection;
    } // returnUserSelection()
    
   static void displayUserSelectionFromMainMenu(String userSelection){
       switch(userSelection){
           case "1":
               System.out.println("All players:");
               displayAllPlayers();
               displayMainMenu();
               break;
           case "2":
               System.out.println("Players with odd numbers:");
               displayPlayersWithOddNumbers();
               displayMainMenu();
               break;
           case "3":
               System.out.println("Please enter a capital letter: ");
                String userLetter = returnUserSelection();
               displayPlayersWithLetter(userLetter);
               displayMainMenu();
               break;
           case "4":
               userAddPlayer();
               displayMainMenu();
               break;
           default:
               System.out.println("Please enter a valid selection.");
               displayMainMenu();
       } // switch
   } // displayUserSelectionFromMainMenu
   
   static void displayAllPlayers(){
   for (Player p : players) {
       System.out.println( p.getName() + " " + p.getNumber());
        } // for loop
   } // displayAllPlayers()
   
   static void displayPlayersWithOddNumbers(){
   for (Player p : players) {
       if(p.getNumber() % 2 != 0){
           System.out.println( p.getName() + " " + p.getNumber());
       } // if statement checking for odd number
        } // for loop
   } // displayPlayersWithOddNumbers()

   static void displayPlayersWithLetter(String userLetter){
       // Print menu header
       System.out.println("Players starting with " + userLetter + ":");
       // convert user letter to char
       char[] userChars = userLetter.toCharArray();
       char userChar = userChars[0];
        for (Player p : players) {
            // get player name
            String playerName = p.getName();
            // turn name string into char array
            char[] playerNameLetters = playerName.toCharArray();
            char firstLetter = playerNameLetters[0];
            // prints player info if user letter mathces first letter of player name
            if(firstLetter == userChar){
           System.out.println( p.getName() + " " + p.getNumber());
            } // if statement checking first letter of player name
        } // for loop
   } // displayPlayersWithLetter
   
   static void userAddPlayer(){
       // Promput user for player name
         System.out.println("Please enter new player's name: ");
         String userPlayerName = returnUserSelection();
         // prompt user for player number
         System.out.println("Please enter new player's number: ");
         Scanner scanner = new Scanner(System.in);  // Create a scanner object 
         int userPlayerNumber = scanner.nextInt(); // Read user input int only
         // add new player with user's input
         addPlayer(userPlayerName, userPlayerNumber);
   } // userAddPlayer()
   
   static void addPlayer(String playerName, int playerNumber){
       players.add(new Player(playerName, playerNumber));
   } // addPlayer
    
    static void prepopulatePlayersList(){
        addPlayer("Mulder", 72);
        addPlayer("Calypso", 23);
        addPlayer("Keratin", 40);
        addPlayer("Anderson", 39);
        addPlayer("Ferne", 22);
    } // prepopulatePlayersList()
    
} // class
