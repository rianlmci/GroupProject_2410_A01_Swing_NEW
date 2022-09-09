/**
 * The creatures that the player catches and does battle with.
 * @author Rianna McIntyre and Jasmine Robbins
 */
public class Pokemon {
   private String name;
   private int health = 80;
   private String appearance;
   private String speciesName;
   private Type type;
   private Location location; //might be redundant?
   /* TODO:
    * RIANNA'S NOTE:
    * Review how 2D arrays work. The idea I has with the first dimension is move name, and the second dimension is elemental type.
    * On the UML I had 3D array but on second thought it's really not needed I don't think.
    */
   private String moves [] [] = new String [4] [1];

   public Pokemon(String nickname, String speciesName){
      this.name = nickname;

      switch(speciesName){
         case "Fuecoco":
            this.speciesName = "Fuecoco";
            this.type = Type.FIRE;
            this.appearance = "/images/Placeholder.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Pikachu":
            this.speciesName = "Pikachu";
            this.type = Type.ELECTRIC;
            this.appearance = "/images/Placeholder.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Turtwig":
            this.speciesName = "Turtwig";
            this.type = Type.GRASS;
            this.appearance = "/images/Placeholder.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Froakie":
            this.speciesName = "Froakie";
            this.type = Type.WATER;
            this.appearance = "/images/Placeholder.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         }
      }

   public String getName(){return this.name;}

   public void setName(String newName){this.name = newName;} //might not be needed due to constructor

   public int getHealth(){return this.health;}

   public void setHealth(int newHealth){this.health = newHealth;}

   /**
    *
    * @return path of appearance's image as a string
    */
   public String getAppearance(){return this.appearance;}

   public void setAppearance(String newAppearance){this.appearance=newAppearance;} //might not be needed due to constructor

   /**
    *
    * @return the elemental type of the pokemon
    */
   public Type getType(){return this.type;}

   /**
    *
    * @param chosenAtk the index number of the selected move
    * @return the elemental type of the selected move
    */
   public Type getMoveType(int chosenAtk){return null;  /*TODO*/}

   public Location getLocation(){return this.location;} //might be redundant??

   public void setLocation(Location newLocation){this.location = newLocation;} //also might be redundant??

}
