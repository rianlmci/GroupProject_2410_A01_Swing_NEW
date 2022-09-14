import java.util.Random;

/**
 * Controls game logic
 * @author Rianna McIntyre and Jasmine Robbins
 */
public class GameMaster {
    private boolean gameWon = false;
    private boolean gameLost = false;
    //private int battleTurn = 1; redundant
    private Pokemon currentEnemyPokemon = new Pokemon("Fuecoco");
    public static ParkLocation north = new ParkLocation(Location.NORTH);
    public static ParkLocation south = new ParkLocation(Location.SOUTH);
    public static ParkLocation east = new ParkLocation(Location.EAST);
    public static ParkLocation west = new ParkLocation(Location.WEST);
    public static ParkLocation origin = new ParkLocation(Location.ORIGIN);

    /**
     * @author Rianna McIntyre
     * @return the current pokemon the player is battling
     */
    public Pokemon getCurrentEnemyPokemon() {return currentEnemyPokemon;}

    /**
     * Sets the current enemy pokemon based on the player's current location.
     * should send something like "myPlayer.getLocation()" to it.
     * @param playerLocation
     * @author Rianna McIntyre
     */
    public void setCurrentEnemyPokemon(Location playerLocation) {
        if(playerLocation == Location.ORIGIN || playerLocation == Location.PLAYERPARTY || playerLocation == null){
            throw new IllegalArgumentException("There are no pokemon at these locations!");
        }

        switch(playerLocation) {
            case NORTH:
                this.currentEnemyPokemon = north.getWildPokemon();
            case SOUTH:
                this.currentEnemyPokemon = south.getWildPokemon();
            case EAST:
                this.currentEnemyPokemon = east.getWildPokemon();
            case WEST:
                this.currentEnemyPokemon = west.getWildPokemon();
        }
    }

    /**
     * @author Rianna McIntyre
     * @param player the player we are inspecting if they won the game or not.
     * @return if the game is won. True or False.
     */
    public boolean isGameWon(Player player){
        if(player.getCapturedPkmnNum() == 4){gameWon = true;}
        return gameWon;
    }

    /**
     * @author Rianna McIntyre
     * @param player the player we are inspecting if they won the game or not.
     * @return if the game is lost. True or False.
     */
    public boolean isGameLost(Player player){
        if(player.getCurrentBattlePokemon().getHealth() <= 0){gameLost = true;}
        return gameLost;
    }

    /**
     * Picks an index value for the wild pokemons attack that will eventually go to its 2DArray of moves.
     * @author Rianna McIntyre
     * from:
     * https://mkyong.com/java/java-generate-random-integers-in-a-range/
     * @return randomly chosen index number for the wild pokemon's attack
     */
    public int chooseWildAttack(){
        Random random = new Random();
        int randomNumber = random.nextInt((3 - 0) + 1) + 0;
        return randomNumber;}

    /**
     * calculates how much damage is going to be subtracted from the pokemon's health.
     * @author Rianna McIntyre
     * @param targetType elemental type of the pokemon that's being attacked
     * @param moveType  elemental type of the attackers pokemon move
     * @return damage to be applied to the target pokemon
     */
    public int calculateDamage(Type targetType, Type moveType){
        int damage = 20;
        switch (targetType){
            case FIRE:
                if(moveType == Type.GROUND ||
                   moveType == Type.WATER ||
                   moveType == Type.ROCK)
                {damage = 40;}

                else if(moveType == Type.BUG ||
                    moveType == Type.FAIRY ||
                    moveType == Type.FIRE ||
                    moveType == Type.GRASS ||
                    moveType == Type.ICE ||
                    moveType == Type.STEEL)
                {damage = 10;}
                break;

            case WATER:
                if(moveType == Type.ELECTRIC ||
                   moveType == Type.GRASS)
                {damage = 40;}

                else if(moveType == Type.FIRE ||
                    moveType == Type.ICE ||
                    moveType == Type.STEEL ||
                    moveType == Type.WATER)
                {damage = 10;}
                break;

            case GRASS:
                if(moveType == Type.BUG ||
                   moveType == Type.FIRE ||
                   moveType == Type.FLYING ||
                   moveType == Type.ICE ||
                   moveType == Type.POISON)
                {damage = 40;}

                else if(moveType == Type.ELECTRIC ||
                    moveType == Type.GRASS ||
                    moveType == Type.GROUND ||
                    moveType == Type.WATER)
                {damage = 10;}
                break;

            case ELECTRIC:
                if(moveType == Type.GROUND) {damage = 40;}

                else if(moveType == Type.ELECTRIC ||
                    moveType == Type.FLYING ||
                    moveType == Type.STEEL)
                {damage = 10;}
                break;
        }
    return damage;
    }

}
