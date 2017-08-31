class makeWorld {

	Rooms [] theRooms = new theRooms[4];
	for (int i=0; i < theRooms.length-1; i++) {
		int pick = Math.Random()*theRooms.length()
			Room x = theRooms [north];
		theRooms[i].setNorth(x);
	}
	for (int i=0; i < theRooms.length-1; i++) {
		int pick = Math.Random()*theRooms.length()
			Room x = theRooms [south];
		theRooms[i].setSouth(x);
	}
	for (int i=0; i < theRooms.length-1; i++) {
		int pick = Math.Random()*theRooms.length()
			Room x = theRooms [west];
		theRooms[i].setWest(x);
	}
	for (int i=0; i < theRooms.length-1; i++) {
		int pick = Math.Random()*theRooms.length()
			Room x = theRooms [east];
		theRooms[i].setEast(x);
	}
}
