/**
 * Acts as the players avatar.
 * @author Rianna McIntyre and Jasmine Robbins
 */
public class Player {
    private String name;
    private Location playerLocation = Location.ORIGIN;
    private String appearance;
    Pokemon capturedPokemon [] = new Pokemon [4];
    private Pokemon currentBattlePokemon;

    /**
     * Overloaded constructor for a player with a name, appearance, and starter pokemon requirement.
     * @author Rianna McIntyre
     * @param name name the player wishes to be called.
     * @param chosenAppearance must be lowercase "masculine".
     * or lowercase "feminine" to work.
     * @param starterPokemon the pokemon the player chose as a starter pokemon.
     */
    Player(String name, String chosenAppearance, Pokemon starterPokemon){
        this.name= name;
        switch(chosenAppearance){
            case "masculine":
                this.appearance = "/images/Masculine.png"; //TODO
                break;
            case "feminine":
                this.appearance = "/images/Feminine.png"; //TODO
                break;
        }
        this.capturedPokemon[0] = starterPokemon;
    }

    /**
     * Adds their very first pokemon to the capture pokemon array,
     * it adds this pokemon to index 0.
     * @author Rianna McIntyre
     * @param chosenPokemon
     */
    public void chooseStarterPokemon(Pokemon chosenPokemon){
        capturedPokemon[0] = chosenPokemon;
    }

    /** Adds a pokemon to an open slot in the captured
     * pokemon array.
     * @author Rianna McIntyre
     * @param caughtMon the pokemon the player just caught
     */
    public void addPkmntoPrty(Pokemon caughtMon){
        for(int i = 1; i < capturedPokemon.length; i++){
            if(capturedPokemon[i] == null){
                capturedPokemon[i] = caughtMon;
                i = capturedPokemon.length; //should exit the loop?
            }
        }
    }

    /**
     * Unimplemented, do not use.
     * @author Rianna McIntyre
     */
    public void startBattle(){/*TODO*/} //might need to go in GameMaster

    /**
     * @author Rianna McIntyre
     * @param bPkmn index location of the chosen battle pokemon in the players party
     */
    public void setCurrentBattlePokemon(int bPkmn){
        this.currentBattlePokemon = capturedPokemon[bPkmn];
    }

    /**
     * Unimplemented, do not use.
     * @author Rianna McIntyre
     * @return N/A
     */
    public int chooseBattleAttack(){return 0; /*TODO*/} //Might be redundant because the pokemon gets an int for its attack too??

    /**
     * @author Rianna McIntyre
     * @return the players chosen name
     */
    public String getName(){return this.name;}

    /**
     * @author Rianna McIntyre
     * @return path of appearance's image as a string
     */
    public String getAppearance(){return this.appearance;}

    /**
     * @author Rianna McIntyre
     * @return
     */
    public Location getPlayerLocation(){return this.playerLocation;}

    /**
     * Updates the players location enum variable
     * @author Rianna McIntyre
     * @param playerLocation the players new location in the game
     */
    public void setPlayerLocation(Location playerLocation){this.playerLocation = playerLocation;}

    /**
     * Player either chooses a masculine or feminine appearance
     * and this method updates the appearance string to the corresponding
     * internal image path location based on that choice.
     * @author Rianna McIntyre
     * @param chosenAppearance
     */
    public void setAppearance(String chosenAppearance){
        switch(chosenAppearance){
            case "feminine":
                this.appearance= this.appearance = "/images/Feminine.png";
                break;
            case "masculine":
                this.appearance = "/images/Masculine.png";
                break;
        }}

    /**
     * @author Rianna McIntyre
     * @return number of pokemon that the player has caught so far.
     */
    public int getCapturedPkmnNum(){
        int capturedCount = 0;
        for(int i = 0; i < capturedPokemon.length; i++){
            if(capturedPokemon[i] != null){
                capturedCount++;
            }
        }
        return capturedCount;
    }

    /**
     * @author Rianna McIntyre
     * Gives pokemon information as a String
     * @return html formatted string to put inside a JLabel
     */
    public String getCapturedPkmnInfo(){
        StringBuilder capturedMonInfo = new StringBuilder();
        capturedMonInfo.append("<html><center><p><h3>Captured Pokemon Total:</h3></p>"+this.getCapturedPkmnNum()+"<h3>Your Pokemon Team:</h3>");
        for (int i = 0; i < capturedPokemon.length; i++) {
            if(capturedPokemon[i] != null){
                capturedMonInfo.append(
                    "<p>Nickname: " + capturedPokemon[i].getName() + "</p>" +
                    "<p>Species: " + capturedPokemon[i].getSpeciesName() + "</p>" +
                    "<p>Health: " + capturedPokemon[i].getHealth() + "</p><p></p>"
                );
            }
        }
        capturedMonInfo.append("</center></html>");
        return capturedMonInfo.toString();
    }

    /**
     * @author Rianna McIntyre
     * @return the pokemon the player chose for the battle
     */
    public Pokemon getCurrentBattlePokemon() {
        return currentBattlePokemon;
    }

    /**
     * @author Rianna McIntyre
     * @param newName new name for the player character
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * @author Rianna McIntyre
     * @return an array that contains all the pokemon the player has caught so far
     */
    public Pokemon[] getCapturedPokemon() {
        return capturedPokemon;
    }

    //= = = TEST CLIENT = = =//
    public static void main(String[] args) {
        //test code here if needed
    }
}


