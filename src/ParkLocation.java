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
     * Overloaded constructor for a park location.
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
                    description = "<html><p><h5>The Grand Canyon:</h5></p>" +
                            "<p>is considered one of the finest examples of arid-land erosion in the world." +
                            " Incised by the Colorado River, the canyon is immense, averaging 4,000 feet deep for its " +
                            "entire 277 miles. It is 6,000 feet deep at its deepest point and 18 miles at its widest (NPS).</p></html>";
                    this.appearance = "/images/north/grand-canyon-aerial-map.jpeg";
                    wildPokemon = new Pokemon("Fuecoco");
                    break;

                case SOUTH:
                    externalLocationName = "Yosemite";
                    internalLocation = Location.SOUTH;
                    description = "<html><p><h5>Yosemite:</h5></p>" +
                            "<p>It is internationally recognized for its granite cliffs," +
                            " waterfalls, clear streams, giant sequoia groves, lakes, mountains, meadows, " +
                            "glaciers, and biological diversity.</p></html>";
                    this.appearance = "/images/south/yosemite.jpeg";
                    wildPokemon = new Pokemon("Turtwig");
                    break;

                case EAST:
                    externalLocationName = "Denali";
                    internalLocation = Location.EAST;
                    description = "<html><p><h5>Denali:</h5></p>" +
                            "<p>National Park and Preserve protects more than six million acres of wild " +
                            "interior Alaska. The south side of the reserve is dominated by the mountain and its " +
                            "acolyte peaks in the Alaska Range, while to the north the park includes a vast range of" +
                            "taiga and tundra lands, home to a wealth of animal life.</p></html>";
                    this.appearance = "/images/east/denali-map.jpeg";
                    wildPokemon = new Pokemon("Froakie");
                    break;

                case WEST:
                    externalLocationName = "Yellowstone";
                    internalLocation = Location.WEST;
                    description = "<html><p><h5>Yellowstone:</h5></p>" +
                            "<p>Yellowstone National Park sits on top of a dormant volcano and is home to more" +
                            " geysers and hot springs than any other place on earth.</p></html>";
                    this.appearance = "/images/west/yellowstone-map.jpeg";
                    wildPokemon = new Pokemon("Pikachu");
                    break;

                case ORIGIN:
                    this.wildPkmnPresent = false;
                    externalLocationName = "Home";
                    internalLocation = Location.ORIGIN;
                    description = "Home Screen";
                    this.appearance = "/images/origin.jpeg";
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
