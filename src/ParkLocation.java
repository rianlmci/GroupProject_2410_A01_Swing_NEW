/**
 * Contains information for the locations that the player will visit.
 * @author Rianna McIntyre and Jasmine Robbins
 */
public class ParkLocation {

    private Location location;
    private String externalLocationName;
    private Location internalLocation;
    private String description;
    private String appearance;
    private boolean wildPkmnPresent = true;
    private Pokemon wildPokemon = new Pokemon("Pikachu");
    public ParkLocation(Location location){
        this.location = location;
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
                    // SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    externalLocationName = "The Grand Canyon";
                    // SET INTERNAL LOCATION TO ENUM
                    internalLocation = Location.NORTH;
                    // SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    description = "The Grand Canyon: \n" +
                            "is considered one of the finest examples of arid-land erosion in the world." +
                            " Incised by the Colorado River, the canyon is immense, averaging 4,000 feet deep for its " +
                            "entire 277 miles. It is 6,000 feet deep at its deepest point and 18 miles at its widest (NPS).";
                    //todo SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/north/grand-canyon-aerial-map.jpeg";
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                     * TODO: replace above with a pokemon that fits the chosen area.
                     */
                    break;

                case SOUTH:
                    // SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    externalLocationName = "Yosemite";
                    // SET INTERNAL LOCATION TO ENUM
                    internalLocation = Location.SOUTH;
                    // SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    description = "Yosemite: \n" +
                            "is internationally recognized for its granite cliffs," +
                            " waterfalls, clear streams, giant sequoia groves, lakes, mountains, meadows, " +
                            "glaciers, and biological diversity.";
                    //todo SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/south/yosemite.jpeg;
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                     * TODO: replace above with a pokemon that fits the chosen area.
                     */
                    break;

                case EAST:
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    externalLocationName = "Banff";
                    //TODO SET INTERNAL LOCATION TO ENUM
                    internalLocation = Location.EAST;
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    description = "Banff: \n" +
                            "Banff National Park is famous for its surreally coloured lakes, majestic mountains," +
                            "ice fields, and glaciers.";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                     * TODO: replace above with a pokemon that fits the chosen area.
                     */
                    break;

                case WEST:
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    externalLocationName = "ZION";
                    //TODO SET INTERNAL LOCATION TO ENUM
                    internalLocation = Location.WEST;
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    description = "Zion: \n" +
                            " high plateaus, a maze of narrow, deep, sandstone canyons, and the Virgin " +
                            "River and its tributaries. Zion also has 2,000-foot Navajo Sandstone cliffs, " +
                            "pine- and juniper-clad slopes, and seeps, springs, and waterfalls supporting lush a" +
                            "nd colorful hanging gardens.";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    /*
                     * TODO: replace above with a pokemon that fits the chosen area.
                     */
                    break;

                case ORIGIN:
                    this.wildPkmnPresent = false;
                    //TODO SET EXTERNAL LOCATION TO A STRING OF WHATEVER CHOSEN LOCATION WILL BE CALLED
                    externalLocationName = "Home";
                    //TODO SET INTERNAL LOCATION TO ENUM
                    internalLocation = Location.ORIGIN;
                    //TODO SET STRING DESCRIPTION TO SHORT DESCRIPTION OF CHOSEN LOCATION
                    description = "Home Screen";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon(null);
                    break;
            }
        }
    }
    public String getParkLocName(){return this.externalLocationName;}

    public String getDescription(){return this.description;}

    public Location getInternalLocation() {return internalLocation;}
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
