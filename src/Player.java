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

    public Player() {

    }

    public void chooseStarterPokemon(Pokemon chosenPokemon){
        capturedPokemon[0] = chosenPokemon;
    } //Might be redundant due to constructor??


    public void addPkmntoPrty(Pokemon caughtMon){
        for(int i = 1; i < capturedPokemon.length; i++){
            if(capturedPokemon[i] == null){
                capturedPokemon[i] = caughtMon;
                i = capturedPokemon.length; //should exit the loop?
            }
        }
    }
    public void startBattle(){/*TODO*/} //might need to go in GameMaster

    /**
     * @param bPkmn index location of the chosen battle pokemon in the players party
     */
    public void setCurrentBattlePokemon(int bPkmn){
        this.currentBattlePokemon = capturedPokemon[bPkmn];
    }

    public int chooseBattleAttack(){return 0; /*TODO*/} //Might be redundant because the pokemon gets an int for its attack too??

    public String getName(){return this.name;}

    /**
     *
     * @return path of appearance's image as a string
     */
    public String getAppearance(){return this.appearance;}

    public Location getPlayerLocation(){return this.playerLocation;}

    public void setPlayerLocation(Location playerLocation){this.playerLocation = playerLocation;}

    public void setAppearance(String chosenAppearance){
        switch(chosenAppearance){
            case "feminine":
                this.appearance= this.appearance = "/images/Masculine.png"; //TODO
                break;
            case "masculine":
                this.appearance = "/images/Masculine.png";
                break;
        }}

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
     * Gives pokemon information as a String
     * @return html formatted string to put inside a JLabel
     */
    public String getCapturedPkmnInfo(){
        StringBuilder capturedMonInfo = new StringBuilder();
        capturedMonInfo.append("<html><center><p><h1>Captured Pokemon Total:</h1></p>"+this.getCapturedPkmnNum()+"<h1>Your Pokemon Team:</h1>");
        for (int i = 0; i < capturedPokemon.length; i++) {
            if(capturedPokemon[i] != null){
                capturedMonInfo.append(
                    "<p>Nickname: " + capturedPokemon[i].getName() + "</p>" +
                    "<p>Species: " + capturedPokemon[i].getSpeciesName() + "</p>" +
                    "<p>Health: " + capturedPokemon[i].getHealth() + "</p><p></p>"
                );
            }
        capturedMonInfo.append("</center></html>");
        }
        return capturedMonInfo.toString();
    }

    public Pokemon getCurrentBattlePokemon() {
        return currentBattlePokemon;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
