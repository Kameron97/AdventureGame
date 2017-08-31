/**
 * The starter for an adventure game.
 */
import java.util.Scanner;
import java.lang.Object;
import java.lang.Math;
class Adventure {
  static final Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    Player player = new Player();
    Room entryWay = makeWorld(); //have this line active for fixed world
    //Room entryWay = makeRandom(); //have this line active for random world
    player.goTo(entryWay);
    printInstructions();
    play(player);   
  }
  
  /**
   * Main play loop of the game. 
   */
  static void play(Player player) {
    while(input.hasNextLine()) {
      String cmd = input.nextLine();
      //commands that connect each input to what the player does
      if (cmd.equals("quit")) {
        return;
      }
      else if (cmd.equals("north")) {
        player.goNorth(); 
        System.out.println("You are in " + player.currentLocation());
      }
      else if (cmd.equals("east")) {
        player.goEast();
        System.out.println("You are in " + player.currentLocation());
      }
      else if (cmd.equals("south")) {
        player.goSouth();
        System.out.println("You are in " + player.currentLocation());
      }
      else if (cmd.equals("west")) {
        player.goWest();
        System.out.println("You are in " + player.currentLocation());
      }
      else if (cmd.equals("inventory")) {
        player.checkInventory();
      }
      else if (cmd.equals("check")) {
        System.out.println("You are in " + player.currentLocation());
        player.checkRoom();
      }
      else if (cmd.equals("take")) {
        player.takeItem();
      }
      else if (cmd.equals("drop")) {
        player.dropItem();
      }
      else if (cmd.equals("eat")){
        player.eatItem();
      }
      else if (cmd.equals("drink")){
        player.drinkItem();
      }
      else if (cmd.equals("read")) {
        player.readItem();
      }
      else if (cmd.equals("help")){
        helpInstructions();
      }
      else { 
        System.out.println("What are you doing?");
      }
    }      
  }
  /**
   * Construct a world
   * @return a reference to the room where the player enters the world.
   */ 
  static Room makeWorld() {  
    Room entryWay = new Room("Entry Chamber");
    Room room1 = new Room("Room 1");  
    Room room2 = new Room("Room 2");  
    Room room3 = new Room("Room 3");
    Room room4 = new Room("Room 4");
    Room exit = new Room("Exit");
    //there are items in each room and rooms are created
    Item idol = new Item("Idol");
    Item mushroom = new Item("Mushroom");  
    Item potion = new Item("Potion");   
    Item scroll= new Item("Scroll");
    //go from room to room
    entryWay.setNorth(room1);
    entryWay.setWest(room2);
    entryWay.setEast(room3);
    entryWay.setSouth(room4);
    room1.setSouth(entryWay); 
    room2.setNorth(entryWay);
    room1.setItem(mushroom);
    room2.setItem(potion); 
    room3.setItem(scroll);
    room4.setItem(idol); 
    return entryWay;
  }
  static Room makeRandom(){
    Room entryWay = new Room("Entry Chamber");
    Room room1 = new Room("Room 1");  
    Room room2 = new Room("Room 2");  
    Room room3 = new Room("Room 3");
    Room room4 = new Room("Room 4");
    Room exit = new Room("Exit");
    Room [] theRooms = {entryWay, room1, room2, room3, room4};
    //for loop to make Rooms random
    for (int i=0; i < theRooms.length-1; i++) {
      int pick = (int) (Math.random()*theRooms.length-1);
      Room x = theRooms [pick]; 
      
      System.out.println(pick);
      theRooms[i].setNorth(x);  
    }
    for (int i=0; i < theRooms.length-1; i++) {
      int pick = (int) (Math.random()*theRooms.length-1);
      Room x = theRooms [pick];
      theRooms[i].setSouth(x); 
    }
    for (int i=0; i < theRooms.length-1; i++) {
      int pick = (int)(Math.random()*theRooms.length-1);
      Room x = theRooms [pick];
      theRooms[i].setWest(x);
    }
    for (int i=0; i < theRooms.length-1; i++) {
      int pick = (int)(Math.random()*theRooms.length-1);
      Room x = theRooms [pick];
      theRooms[i].setEast(x);
    }
    //there are items in each room and rooms are created
    Item idol = new Item("Idol");
    Item mushroom = new Item("Mushroom");  
    Item potion = new Item("Potion");   
    Item scroll= new Item("Scroll");
    room1.setItem(mushroom);
    room2.setItem(potion); 
    room3.setItem(scroll);
    room4.setItem(idol); 
    return theRooms[0];
  }
  //Instructions explaining the objective of the game and how to play
  static void printInstructions() {
    System.out.println("Welcome to our Adventure! Find your way through the maze.");
    System.out.println("The objective of the game is to find the idol.");
    System.out.println("Type 'help' for further instructions.");
    System.out.println("Good luck on your adventure!");
  }
  static void helpInstructions(){
    System.out.println("All commands are case sensitive.");
    System.out.println("'north' 'south' 'east' and 'west' move you in that direction.");
    System.out.println("'check' lets you look around the room you're currently in.");
    System.out.println("'take' adds an item into your inventory.");
    System.out.println("'drop' removes the newest item from your inventory and places it in a room.");
    System.out.println("Note: You can carry unlimited items.");
    System.out.println("'inventory' lets you see the newest item in your inventory.");
    System.out.println("Note: Nothing happens if inventory is empty.");
    System.out.println("'eat' 'drink' and 'read' lets you eat food, drink liquids, and read books.");
  }
}