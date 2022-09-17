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
   private String moves[][];

   /*
   * Each pokemon's moves and their types!
   * (So I don't have to keep copy and pasting them into constructors.)
   */
   private String fuecocoMoves[][] = {
           {"Ember", "fire"},
           {"Scratch", "normal"},
           {"Swift", "normal"},
           {"Brick break", "fighting"}};

   private String pikachuMoves[][] = {
           {"Electro Ball", "electric"},
           {"Quick Attack", "normal"},
           {"Play Rough", "fairy"},
           {"Mega Punch", "normal"}};

   private String turtwigMoves[][] = {
           {"Razor Leaf", "grass"},
           {"Bite", "dark"},
           {"Facade", "normal"},
           {"Rock Smash", "fighting"}};

   private String froakieMoves[][] = {
           {"Bubble", "water"},
           {"Pound", "normal"},
           {"Lick", "ghost"},
           {"Fling", "normal"}};

   /**
    * @author Rianna McIntyre
    * Overloaded pokemon constructor with nickname. Added this to work more easily with capturing pokemon.
    * @param speciesName name of the pokemon's species. First letter has to be capitalized.
    * @param nickName what the player chooses to call this pokemon.
    */
   public Pokemon(String speciesName, String nickName) {
      this.name = nickName;
      switch (speciesName) {
         case "Fuecoco":
            this.speciesName = "Fuecoco";
            this.name = "Fuecoco";
            this.type = Type.FIRE;
            this.appearance = "/images/Fuecoco.png";
            this.moves= fuecocoMoves;
            break;
         case "Pikachu":
            this.speciesName = "Pikachu";
            this.name = "Pikachu";
            this.type = Type.ELECTRIC;
            this.appearance = "/images/Pikachu.png";
            this.moves= pikachuMoves;
            break;
         case "Turtwig":
            this.speciesName = "Turtwig";
            this.name = "Turtwig";
            this.type = Type.GRASS;
            this.appearance = "/images/Turtwig.png";
            this.moves= turtwigMoves;
            break;
         case "Froakie":
            this.speciesName = "Froakie";
            this.type = Type.WATER;
            this.appearance = "/images/Froakie.png";
            this.moves = froakieMoves;
            break;
      }
   }

   /**
    * @author Rianna McIntyre
    * Overloaded pokemon constructor without a nickname.
    * @param speciesName name of the pokemon species we're creating. First letter has to be capitalized.
    */
   public Pokemon(String speciesName) {

      switch (speciesName) {
         case "Fuecoco":
            this.speciesName = "Fuecoco";
            this.name = "Fuecoco";
            this.type = Type.FIRE;
            this.appearance = "/images/Fuecoco.png";
            this.moves= fuecocoMoves;
            break;
         case "Pikachu":
            this.speciesName = "Pikachu";
            this.name = "Pikachu";
            this.type = Type.ELECTRIC;
            this.appearance = "/images/Pikachu.png";
            this.moves= pikachuMoves;
            break;
         case "Turtwig":
            this.speciesName = "Turtwig";
            this.name = "Turtwig";
            this.type = Type.GRASS;
            this.appearance = "/images/Turtwig.png";
            this.moves= turtwigMoves;
            break;
         case "Froakie":
            this.speciesName = "Froakie";
            this.name = "Froakie";
            this.type = Type.WATER;
            this.appearance = "/images/Froakie.png";
            this.moves= froakieMoves;
            break;
      }
   }

   /**
    * @author Rianna McIntyre
    * @return the pokemon's current name/nickname
    */
   public String getName() {
      return this.name;
   }

   /**
    * @author Rianna McIntyre
    * @param newName the new nickname for this pokemon
    */
   public void setName(String newName) {
      this.name = newName;
   }

   /**
    * @author Rianna McIntyre
    * @return the pokemons current health as an int
    */
   public int getHealth() {
      return this.health;
   }

   /**
    * @author Rianna McIntyre
    * @param newHealth the pokemons current health as an int
    */
   public void setHealth(int newHealth) {
      this.health = newHealth;
   }

   /**
    * @author Rianna McIntyre
    * @return path of appearance's image as a string
    */
   public String getAppearance() {
      return this.appearance;
   }

   /**
    * @param newAppearance new image path to use as the pokemon's appearance.
    */
   public void setAppearance(String newAppearance) {
      this.appearance = newAppearance;
   } //might not be needed due to constructor

   /**
    * @author Rianna McIntyre
    * @return the elemental type enum of the pokemon.
    */
   public Type getType() {
      return this.type;
   }

   /**
    * @author Rianna McIntyre
    * @return pokemon's type enum converted to a lowercase string.
    */
   public String getTypeAsString(){
      return this.type.name().toLowerCase();
   }

   /**
    * @author Rianna McIntyre
    * @return the pokemon's current location as an enum of type Location.
    */
   public Location getLocation() {
      return this.location;
   } //might be redundant??

   /**
    * @author Rianna McIntyre
    * @param newLocation the pokemons new location as an enum of type Location.
    */
   public void setLocation(Location newLocation) {
      this.location = newLocation;
   } //also might be redundant??

   /**
    * @author Rianna McIntyre
    * @return name of this species of pokemon.
    */
   public String getSpeciesName() {
      return speciesName;
   }

   /**
    *
    * @param moveChoice an index number 0 through 3 that corresponds to
    * the number of moves a pokemon can have (four moves).
    * @return the name of the move at that index number for this pokemon.
    */
   public String getMoveName (int moveChoice){
      if(moveChoice > 3 || moveChoice < 0){
         throw new IllegalArgumentException("This number is not in the accepted range of 0 through 3 inclusive.");
      }
      return this.moves[moveChoice][0];
   }

   /**
    * @author Rianna McIntyre
    * @param moveChoice an index number 0 through 3 that corresponds to
    * the number of moves a pokemon can have (four moves).
    * @return the elemental type of the move at that index number for this pokemon in string form.
    */
   public String getMoveType (int moveChoice){
      if(moveChoice > 3 || moveChoice < 0){
         throw new IllegalArgumentException("This number is not in the accepted range of 0 through 3 inclusive.");
      }
      return moves[moveChoice][1];
   }

   /**
    * @author Rianna McIntyre
    * @param moveChoice an index number 0 through 3 that corresponds to
    * the number of moves a pokemon can have (four moves).
    * @return the elemental type of the move at that index number for this pokemon in enum-type form.
    */
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
      Player myPlayer= new Player("Ri","feminine", new Pokemon("Pikachu"));
      myPlayer.setCurrentBattlePokemon(0);
      myGameMaster.setCurrentEnemyPokemon(Location.EAST);
      for (int i = 0; i < 4; i++) {
         int ourChosenRandomMove = myGameMaster.chooseWildAttack();
         int enemyChosenRandomMove = myGameMaster.chooseWildAttack();
         System.out.println("= = = =  NEW TURN = = = =");
         System.out.println("Our " + myPlayer.getCurrentBattlePokemon().getName() +"'s chosen attack was "
                 + myPlayer.getCurrentBattlePokemon().getMoveName(ourChosenRandomMove)
                 + " and it did "
                 + myGameMaster.calculateDamage(myGameMaster.getCurrentEnemyPokemon().getType(),
                 myPlayer.getCurrentBattlePokemon().getMoveTypeAsType(ourChosenRandomMove))
                 + " damage to the wild " + myGameMaster.getCurrentEnemyPokemon().getTypeAsString()
                 + " type " + myGameMaster.getCurrentEnemyPokemon().getName() + "!"
         );

         System.out.println("Enemy " + myGameMaster.getCurrentEnemyPokemon().speciesName +"'s chosen attack was "
                 + myGameMaster.getCurrentEnemyPokemon().getMoveName(enemyChosenRandomMove)
                 + " and it did "
                 + myGameMaster.calculateDamage(myPlayer.getCurrentBattlePokemon().getType(),
                 myGameMaster.getCurrentEnemyPokemon().getMoveTypeAsType(enemyChosenRandomMove))
                 + " damage to our " + myPlayer.getCurrentBattlePokemon().getTypeAsString()
                 + " type " +  myPlayer.getCurrentBattlePokemon().getName() + "!"
         );
         //Updates our pokemon's health
         myPlayer.getCurrentBattlePokemon().setHealth(
                 (myPlayer.getCurrentBattlePokemon().getHealth())
                 -
                 (myGameMaster.calculateDamage(myPlayer.getCurrentBattlePokemon().getType(),
                 myGameMaster.getCurrentEnemyPokemon().getMoveTypeAsType(enemyChosenRandomMove)))
         );
         System.out.println("Our " + myPlayer.getCurrentBattlePokemon().getName() + "'s current health is "
                 + myPlayer.getCurrentBattlePokemon().getHealth());
         //Updates the enemy pokemon's health
         myGameMaster.getCurrentEnemyPokemon().setHealth(
                 (myGameMaster.getCurrentEnemyPokemon().getHealth())
                 -
                 (myGameMaster.calculateDamage(myGameMaster.getCurrentEnemyPokemon().getType(),
                 myPlayer.getCurrentBattlePokemon().getMoveTypeAsType(ourChosenRandomMove)))
         );
         System.out.println("Enemy " + myGameMaster.getCurrentEnemyPokemon().getName() + "'s current health is "
                 + myGameMaster.getCurrentEnemyPokemon().getHealth());
         System.out.println("The game's lose condition is " + myGameMaster.isGameLost(myPlayer) + ".");
         System.out.println();
      }
      System.out.println("Added two of the pokemon at the current location");
      myPlayer.addPkmntoPrty(new Pokemon(myGameMaster.getCurrentEnemyPokemon().getSpeciesName()));
      myPlayer.addPkmntoPrty(new Pokemon(myGameMaster.getCurrentEnemyPokemon().getSpeciesName()));
      System.out.println("The game's win condition is " + myGameMaster.isGameWon(myPlayer));
   }
}
