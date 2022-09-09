/**
 * Contains information for the locations that the player will visit.
 * @author Rianna McIntyre and Jasmine Robbins
 */
public class ParkLocation {

    private String externalLocationName;
    private Location internalLocation;
    private String description;
    private String appearance;
    private boolean wildPkmnPresent = true;
    private Pokemon wildPokemon = new Pokemon("Pikachu");;
    public ParkLocation(Location location){
        if(
            location == Location.NORTH ||
            location == Location.SOUTH ||
            location == Location.EAST ||
            location == Location.WEST ||
            location == Location.ORIGIN
        )
        {
            switch(location){
                case NORTH:
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    //TODO SET INTERNAL LOCATION TO ENUM
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                    * TODO: replace above with a pokemon that fits the chosen area.
                    */
                    break;
                case SOUTH:
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    //TODO SET INTERNAL LOCATION TO ENUM
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                     * TODO: replace above with a pokemon that fits the chosen area.
                     */
                    break;
                case EAST:
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    //TODO SET INTERNAL LOCATION TO ENUM
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                     * TODO: replace above with a pokemon that fits the chosen area.
                     */
                    break;
                case WEST:
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    //TODO SET INTERNAL LOCATION TO ENUM
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                     * TODO: replace above with a pokemon that fits the chosen area.
                     */
                    break;
                case ORIGIN:
                    this.wildPkmnPresent = false;
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    //TODO SET INTERNAL LOCATION TO ENUM
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon(null);
                    break;
            }
        }
    }
    public String getParkLocName(){return this.externalLocationName;}

    public String getDescription(){return this.description;}
    /**
     *
     * @return path of appearance's image as a string
     */
    public String getAppearance(){return this.appearance;}

    public boolean isWildPkmnPresent(){
        if(this.wildPkmnPresent){return true;}
        else return false;
    }

    public void setWildPkmnPresent(boolean isPresent) {this.wildPkmnPresent = isPresent;}

    public Pokemon getWildPokemon(){return this.wildPokemon;}

    public void setWildPokemon(Pokemon wildPkmn){this.wildPokemon = wildPkmn;} //Might be redundant due to constructor??

}
