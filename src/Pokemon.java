import java.util.Arrays;
import java.util.Locale;

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
   private static String moves[][] = {
           {"Fire Attack", "fire"},
           {"Water Attack", "water"},
           {"Grass Attack", "grass"},
           {"Electric Attack", "electric"}
   };

   /**
    * Pokemon constructor with nickname. Added this to work more easily with capturing pokemon.
    *
    * @param speciesName name of the pokemon's species
    * @param nickName    what the player chooses to call this pokemon.
    */
   public Pokemon(String speciesName, String nickName) {
      this.name = nickName;
      switch (speciesName) {
         case "Fuecoco":
            this.speciesName = "Fuecoco";
            this.name = "Fuecoco";
            this.type = Type.FIRE;
            this.appearance = "/images/Fuecoco.png";
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Pikachu":
            this.speciesName = "Pikachu";
            this.name = "Pikachu";
            this.type = Type.ELECTRIC;
            this.appearance = "/images/Pikachu.png";
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Turtwig":
            this.speciesName = "Turtwig";
            this.name = "Turtwig";
            this.type = Type.GRASS;
            this.appearance = "/images/Turtwig.png";
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Froakie":
            this.speciesName = "Froakie";
            this.type = Type.WATER;
            this.appearance = "/images/Froakie.png";
            //TODO SET MOVE SET TO 2D ARRAY
            break;
      }
   }

   /**
    * Pokemon constructor without nickname.
    *
    * @param speciesName name of the pokemon's species.
    */
   public Pokemon(String speciesName) {

      switch (speciesName) {
         case "Fuecoco":
            this.speciesName = "Fuecoco";
            this.name = "Fuecoco";
            this.type = Type.FIRE;
            this.appearance = "/images/Fuecoco.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Pikachu":
            this.speciesName = "Pikachu";
            this.name = "Pikachu";
            this.type = Type.ELECTRIC;
            this.appearance = "/images/Pikachu.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Turtwig":
            this.speciesName = "Turtwig";
            this.name = "Turtwig";
            this.type = Type.GRASS;
            this.appearance = "/images/Turtwig.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
         case "Froakie":
            this.speciesName = "Froakie";
            this.type = Type.WATER;
            this.appearance = "/images/Froakie.png"; //TODO
            //TODO SET MOVE SET TO 2D ARRAY
            break;
      }
   }

   public String getName() {
      return this.name;
   }

   public void setName(String newName) {
      this.name = newName;
   } //might not be needed due to constructor

   public int getHealth() {
      return this.health;
   }

   public void setHealth(int newHealth) {
      this.health = newHealth;
   }

   /**
    * @return path of appearance's image as a string
    */
   public String getAppearance() {
      return this.appearance;
   }

   public void setAppearance(String newAppearance) {
      this.appearance = newAppearance;
   } //might not be needed due to constructor

   /**
    * @return the elemental type of the pokemon
    */
   public Type getType() {
      return this.type;
   }

   /**
    *
    * @return pokemon's type enum converted to a lowercase string
    */
   public String getTypeAsString(){
      return this.type.name().toLowerCase();
   }

   public Location getLocation() {
      return this.location;
   } //might be redundant??

   public void setLocation(Location newLocation) {
      this.location = newLocation;
   } //also might be redundant??

   public String getSpeciesName() {
      return speciesName;
   }

   public String getMoveName (int moveChoice){
      return this.moves[moveChoice][0];
   }

   public String getMoveType (int moveChoice){
      return moves[moveChoice][1];
   }

   public Type getMoveTypeAsType (int moveChoice){
      String typeAsString = moves[moveChoice][1];
      switch(typeAsString){
         case "normal":
            return Type.NORMAL;
         case "fire":
            return Type.FIRE;
         case "water":
            return Type.WATER;
         case "grass" :
            return Type.GRASS;
         case "electric" :
            return Type.ELECTRIC;
         case "ice":
            return Type.ICE;
         case "fighting":
            return Type.FIGHTING;
         case "poison":
            return Type.POISON;
         case "ground":
            return Type.GROUND;
         case "flying":
            return Type.FLYING;
         case "psychic":
            return Type.PSYCHIC;
         case "bug":
            return Type.BUG;
         case "rock":
            return Type.ROCK;
         case "ghost":
            return Type.GHOST;
         case "dark":
            return Type.DARK;
         case "dragon":
            return Type.DRAGON;
         case "steel":
            return Type.STEEL;
         case "fairy":
            return Type.FAIRY;
      }
      throw new IllegalArgumentException("This is not a valid pokemon type. Check your capitalization and spelling.");
   }
   //= = = TEST CLIENT = = =//
   public static void main(String[] args) {
      GameMaster myGameMaster = new GameMaster();
      Pokemon myPokemon = new Pokemon("Fuecoco");
      Pokemon enemyPokemon = new Pokemon("Turtwig");
      int ourChosenRandomMove = myGameMaster.chooseWildAttack();
      int enemyChosenRandomMove = myGameMaster.chooseWildAttack();

      System.out.println(myPokemon.speciesName +"'s chosen attack was " + myPokemon.getMoveName(ourChosenRandomMove)
              + " and it did "
              + myGameMaster.calculateDamage(enemyPokemon.getType(), myPokemon.getMoveTypeAsType(ourChosenRandomMove))
              + " damage to the " + enemyPokemon.getTypeAsString() + " type " + enemyPokemon.getName() + "!"
      );

      System.out.println(enemyPokemon.speciesName +"'s chosen attack was " + enemyPokemon.getMoveName(enemyChosenRandomMove)
              + " and it did "
              + myGameMaster.calculateDamage(myPokemon.getType(), enemyPokemon.getMoveTypeAsType(enemyChosenRandomMove))
              + " damage to the " + myPokemon.getTypeAsString() + " type " + myPokemon.getName() + "!"
      );
   }
}


