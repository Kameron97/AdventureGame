import java.util.ArrayList;

public class Room {
  private Room north, south, east, west;
  private String name;
  private ArrayList<Item> item = new ArrayList<Item>();
   
  Room(String name) {
    this.name = name;
  } 
  
  Room north() {
    return north;
  }
  
  Room south() {
    return south;
  }
  
  Room west() {
    return west;
  }
  
  Room east() {
    return east;
  }
  
  void setNorth(Room room) {
    north = room;
  }
  
  void setSouth(Room room) {
    south = room;
  }
  
  void setEast(Room room) {
    east = room;
  } 
  
  void setWest(Room room) {
    west = room;
  }
  
  public String toString() {
    return name;
  }
  void setItem(Item thing){
    item.add(thing);
  }
  //most of the code for check() taken from lesson on May 4th.
  Item check(){
    Item result = null;
    for (int i = 0; i < item.size(); i++){
        if (item.get(i) != null){
        result = item.get(i);
      }
    }
    if (result == null){
      System.out.println("The room is empty");
    }else {
      System.out.println("There is a " + result.getName());
    }
    return result;
  }
  Item take(){
    Item thing = null;
    for (int i = 0; i < item.size(); i++) {
      if (item.get(i) != null) {
        thing = item.get(i);
        item.remove(i);
        return thing;
      }
      else if (item.get(i) == null){
        System.out.println("What are you taking?");
      }
    }
    return thing;
  }
}