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
     * @author Rianna McIntyre
     * @param name
     * @param chosenAppearance
     * @param starterPokemon
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
     * @author Rianna McIntyre
     * @param chosenPokemon
     */
    public void chooseStarterPokemon(Pokemon chosenPokemon){
        capturedPokemon[0] = chosenPokemon;
    }

    /**
     * @author Rianna McIntyre
     * @param caughtMon
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
     * @author Rianna McIntyre
     * @return
     */
    public int chooseBattleAttack(){return 0; /*TODO*/} //Might be redundant because the pokemon gets an int for its attack too??

    /**
     * @author Rianna McIntyre
     * @return
     */
    public String getName(){return this.name;}

    /**
     *
     * @return path of appearance's image as a string
     */
    public String getAppearance(){return this.appearance;}

    /**
     * @author Rianna McIntyre
     * @return
     */
    public Location getPlayerLocation(){return this.playerLocation;}

    /**
     * @author Rianna McIntyre
     * @param playerLocation
     */
    public void setPlayerLocation(Location playerLocation){this.playerLocation = playerLocation;}

    /**
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
     * @return
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
     * @return
     */
    public Pokemon getCurrentBattlePokemon() {
        return currentBattlePokemon;
    }

    /**
     * @author Rianna McIntyre
     * @param newName
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * @author Rianna McIntyre
     * @return
     */
    public Pokemon[] getCapturedPokemon() {
        return capturedPokemon;
    }

    //= = = TEST CLIENT = = =//
    public static void main(String[] args) {
        //test code here if needed
    }
}


