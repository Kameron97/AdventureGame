/**
 * Represents the player in an adventure game.
 */
import java.util.ArrayList;

class Player {
	private Room location;
	private ArrayList<Item> inventory = new ArrayList<Item>(1);
	void goTo(Room room) {
		location = room;
	}
	void goNorth() {
		location = location.north();
	}
	void goEast() {
		location = location.east();
	}
	void goSouth() {
		location = location.south();
	}
	void goWest() {
		location = location.west();
	}
	Room currentLocation() {
		return location;
	}
	void checkInventory() {
		for (int i = 0; i < inventory.size(); i++){
			if (inventory.get(i) != null) {
				System.out.println(inventory.get(i).getName());
			}
		}
	}
	void checkRoom() {
		location.check();
	}
	void takeItem() {
		if (location.check() != null) {
			System.out.println("You took the " + location.check().getName());
			inventory.add(location.take());
		}
		else if (location.check() == null) {
			System.out.println("What are you taking?");
		}
	}
	void dropItem() {
		for (int i = 0; i < inventory.size(); i++){
			if (inventory.get(i) != null){
				location.setItem(inventory.remove(i));
				System.out.println("You dropped the " + location.check().getName());
			}
		}
	}
	void eatItem(){
		for (int i = 0; i < inventory.size(); i++){
			if (inventory.get(i).getName() == "Mushroom"){
				inventory.get(i).eat();
				inventory.remove(i);
				location = location.south();
			}
		}
	} 
	void drinkItem(){
		for (int i = 0; i < inventory.size(); i++){
			if (inventory.get(i).getName() == "Potion"){
				inventory.get(i).drink();
				inventory.remove(i);
			}
		}
	}
	void readItem(){
		for (int i = 0; i < inventory.size(); i++){
			if (inventory.get(i).getName() == "Scroll"){
				inventory.get(i).read();
			}
		}
	}
}
