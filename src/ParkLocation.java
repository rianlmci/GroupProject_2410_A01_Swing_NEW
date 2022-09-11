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
     * @author Jasmine Robbins for names descriptions and images. Rianna for everything else.
     * @param location
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
                    description = "<html><center><p><h2>The Grand Canyon:</h2></p>" +
                            "<p>is considered one of the finest examples of arid-land erosion in the world." +
                            " Incised by the Colorado River, the canyon is immense, averaging 4,000 feet deep for its " +
                            "entire 277 miles. It is 6,000 feet deep at its deepest point and 18 miles at its widest (NPS).</p></center></html>";
                    this.appearance = "/images/north/grand-canyon-aerial-map.jpeg";
                    wildPokemon = new Pokemon("Fuecoco");
                    break;

                case SOUTH:
                    externalLocationName = "Yosemite";
                    internalLocation = Location.SOUTH;
                    description = "<html><center><p><h2>Yosemite:</h2></p>" +
                            "<p>It is internationally recognized for its granite cliffs," +
                            " waterfalls, clear streams, giant sequoia groves, lakes, mountains, meadows, " +
                            "glaciers, and biological diversity.</p></center></html>";
                    this.appearance = "/images/south/yosemite.jpeg";
                    wildPokemon = new Pokemon("Turtwig");
                    break;

                case EAST:
                    externalLocationName = "Banff";
                    internalLocation = Location.EAST;
                    description = "<html><center><p><h2>Banff:</h2></p>" +
                            "<p>Banff National Park is famous for its surreally coloured lakes, majestic mountains," +
                            "ice fields, and glaciers.</p></center></html>";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Froakie");
                    break;

                case WEST:
                    externalLocationName = "Zion";
                    internalLocation = Location.WEST;
                    description = "<html><center><p><h2>Zion:</h2></p>" +
                            "<p>Consisting of high plateaus, a maze of narrow, deep, sandstone canyons, and the Virgin " +
                            "River and its tributaries. Zion also has 2,000-foot Navajo Sandstone cliffs, " +
                            "pine- and juniper-clad slopes, and seeps, springs, and waterfalls supporting lush " +
                            "and colorful hanging gardens.</p></center></html>";
                    //TODO SET THE IMAGE PATH AS A STRING, SHOULD BE this.appearance = "/images/imageName.extension";
                    wildPokemon = new Pokemon("Pikachu");
                    break;

                case ORIGIN:
                    this.wildPkmnPresent = false;
                    externalLocationName = "Home";
                    internalLocation = Location.ORIGIN;
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
       return false;
    }

    public void setWildPkmnPresent(boolean isPresent) {this.wildPkmnPresent = isPresent;}

    public Pokemon getWildPokemon(){return this.wildPokemon;}

    public void setWildPokemon(Pokemon wildPkmn){this.wildPokemon = wildPkmn;} //Might be redundant due to constructor??

}
