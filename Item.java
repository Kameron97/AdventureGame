//Item class that holds player's inventory and option

class Item {
	private String name;
	Item(String name) {
		this.name = name;
	
	} 
	String getName() { 
		if (name == null){
			name = "Empty";
		}
		return name;
	
	}


	void eat() {
		if(name == "Mushroom") {
			System.out.println("You ate the Mushroom");
			System.out.println("You don't feel too good");
			System.out.println("Your surroundings look different");
		}
	}

	void drink() {
		if(name == "Potion") {
			System.out.println("You drank the Potion");
			System.out.println("Turns out it was only water");
			System.out.println("Well, at least you're hyrdated now");
		}
	
	}
	void read() {
		if(name == "Scroll") {
			System.out.println("You opened the scroll and read it");
			System.out.println("'Finding the key opens the way'");
		}
	}
} 
