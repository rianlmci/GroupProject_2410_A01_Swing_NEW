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

    /**
     * Overloaded constructor for a park location
     * @author Jasmine Robbins for names descriptions and images. Rianna for everything else.
     * @param location cardinal direction as enum that sets everything up based on method presets.
     */
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
                    externalLocationName = "The Grand Canyon";
                    internalLocation = Location.NORTH;
                    description = "<html><p><h3>The Grand Canyon:</h3></p>" +
                            "<p>is considered one of the finest examples of arid-land erosion in the world." +
                            " Incised by the Colorado River, the canyon is immense, averaging 4,000 feet deep for its " +
                            "entire 277 miles. It is 6,000 feet deep at its deepest point and 18 miles at its widest (NPS).</p></html>";
                    this.appearance = "/images/north/grand-canyon-aerial-map.jpeg";
                    wildPokemon = new Pokemon("Fuecoco");
                    break;

                case SOUTH:
                    externalLocationName = "Yosemite";
                    internalLocation = Location.SOUTH;
                    description = "<html><p><h3>Yosemite:</h3></p>" +
                            "<p>It is internationally recognized for its granite cliffs," +
                            " waterfalls, clear streams, giant sequoia groves, lakes, mountains, meadows, " +
                            "glaciers, and biological diversity.</p></html>";
                    this.appearance = "/images/south/yosemite.jpeg";
                    wildPokemon = new Pokemon("Turtwig");
                    break;

                case EAST:
                    externalLocationName = "Banff";
                    internalLocation = Location.EAST;
                    description = "<html><p><h3>Banff:</h3></p>" +
                            "<p>Banff National Park is famous for its surreally coloured lakes, majestic mountains," +
                            "ice fields, and glaciers.</p></html>";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Froakie");
                    break;

                case WEST:
                    externalLocationName = "Zion";
                    internalLocation = Location.WEST;
                    description = "<html><p><h3>Zion:</h3></p>" +
                            "<p>Consisting of high plateaus, a maze of narrow, deep, sandstone canyons, and the Virgin " +
                            "River and its tributaries. Zion also has 2,000-foot Navajo Sandstone cliffs, " +
                            "pine- and juniper-clad slopes, and seeps, springs, and waterfalls supporting lush " +
                            "and colorful hanging gardens.</p></html>";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    break;

                case ORIGIN:
                    this.wildPkmnPresent = false;
                    externalLocationName = "Home";
                    internalLocation = Location.ORIGIN;
                    description = "Home Screen";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    break;
            }
        }
    }

    /**
     * @author Rianna McIntyre
     * @return the eternal location name of this area as a string. EX."The Grand Canyon"
     */
    public String getParkLocName(){return this.externalLocationName;}

    /**
     * @author Rianna McIntyre
     * @return html formatted string describing the ParkLocation. The string is intended to go inside a Jlabel.
     */
    public String getDescription(){return this.description;}

    /**
     * @author Rianna McIntyre
     * @return the enum that is this ParkLocation's cardinal direction. EX. "Location.NORTH"
     */
    public Location getInternalLocation() {return internalLocation;}
    /**
     * @author Rianna McIntyre
     * @return path of appearance's image as a string
     */
    public String getAppearance(){return this.appearance;}

    /**
     * @author Rianna McIntyre
     * @return boolean value of if a wild pokemon is in this ParkLocation.
     */
    public boolean isWildPkmnPresent(){
        if(this.wildPkmnPresent){return true;}
       return false;
    }

    /**
     * Changes the boolean value of if a wild pokemon is in this ParkLocation or not.
     * @author Rianna McIntyre
     * @param isPresent
     */
    public void setWildPkmnPresent(boolean isPresent) {this.wildPkmnPresent = isPresent;}

    /**
     * @author Rianna McIntyre
     * @return the pokemon object at this ParkLocation.
     */
    public Pokemon getWildPokemon(){return this.wildPokemon;}

    public void setWildPokemon(Pokemon wildPkmn){this.wildPokemon = wildPkmn;} //Might be redundant due to constructor??

}
