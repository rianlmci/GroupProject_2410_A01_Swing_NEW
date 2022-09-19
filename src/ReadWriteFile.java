import java.io.*;
/*
 * @author Jasmine Robbins
 */
public class ReadWriteFile {
    String filename = "pokemonPlayers.txt";
    Player myPlayer = new Player("Jasmine", "feminine", new Pokemon("Fuecoco"));

    /**
     * Saves the players information to a text file.
     * @author original by Jasmine, modified by Rianna
     * @param myPlayer player info we are saving.
     */
    public void risWrite(Player myPlayer) {
        File file = new File(filename);
        boolean append = false;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename), append));
            if (file.exists()) {
                append = true;
            }
            else {
                append = false;
                System.out.println("Error with File");
            }

            //building the string we are writing to the file...
            StringBuilder newCSV = new StringBuilder();

            //to get the player's name:
            newCSV.append(myPlayer.getName() + ",");

            //to get the players chosen appearance:
            if (myPlayer.getAppearance().compareTo("/images/Feminine.png") == 0){
                newCSV.append("feminine" + ",");
            }

            else{ newCSV.append("masculine" + ",");}

            //to get all the players pokemon:
            for (int i = 0; i < myPlayer.getCapturedPokemon().length; i++) {

                //check if current index of all their caught pokemon isn't null
                if (myPlayer.getCapturedPokemon()[i] != null) {
                    newCSV.append(myPlayer.getCapturedPokemon()[i].getSpeciesName() + ","
                            + myPlayer.getCapturedPokemon()[i].getName() + ",");
                }

                //If we are at the last pokemon they caught, don't add another comma separator and go to the end of the array
                if (i + 1 >= myPlayer.getCapturedPokemon().length || myPlayer.getCapturedPokemon()[i + 1] == null) {
                    newCSV.append(myPlayer.getCapturedPokemon()[i].getHealth());
                    i = myPlayer.getCapturedPokemon().length;
                }

                else {
                    newCSV.append(myPlayer.getCapturedPokemon()[i].getHealth() + ",");
                }
            }
            bw.write(newCSV.toString());
            bw.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }
    /**
     * @author Jasmine and modified by Rianna
     * Load player data on loadGameBtn
     * loaadPlayerData gets all of the player information
     * loadGameMasterData sets isWildPkmn to false if pokemon is already found
     * @return loadedMyPlayer, player info from loaded file.
     */
    public Player risLoadPlayerData() throws IOException {
        String currentLine;
        Player loadedMyPlayer = new Player("Jasmine", "feminine", new Pokemon("Fuecoco"));
        //autocloseable try with resources
        try (BufferedReader br = new BufferedReader(new FileReader(filename));){
            while((currentLine = br.readLine()) != null) {
                String[] loadedData = currentLine.split("\\,");
                loadedMyPlayer = new Player(loadedData[0], loadedData[1], new Pokemon(loadedData[2], loadedData[3]));
                loadedMyPlayer.capturedPokemon[0].setHealth(Integer.parseInt(loadedData[4]));
                if(loadedData.length > 4) {
                    for (int i = 5; i < loadedData.length; i += 3) {
                        if (i + 3 <= loadedData.length) {
                            Pokemon pkmntoAdd = new Pokemon(loadedData[i], loadedData[i + 1]);
                            pkmntoAdd.setHealth(Integer.parseInt(loadedData[i + 2]));
                            loadedMyPlayer.addPkmntoPrty(pkmntoAdd);
                        }
                    }
                }
            }
            return loadedMyPlayer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @author Jasmine and modified by Rianna
     * loadGameMasterData on loadGameBtn
     * loadGameMasterData sets isWildPkmn to false if pokemon is already found
     * @return loadedMyGameMaster, based on info from loaded file.
     */
    public GameMaster risLoadGameMasterData() throws IOException {
        String currentLine;
        GameMaster loadedMyGameMaster = new GameMaster();
        //autocloseable try with resources
        try (BufferedReader br = new BufferedReader(new FileReader(filename));){
            while((currentLine = br.readLine()) != null) {
                String[] loadedData = currentLine.split("\\,");
                for (int i = 2; i < loadedData.length; i+=3) {
                    switch (loadedData[i]){
                        case "Fuecoco":
                            loadedMyGameMaster.north.setWildPkmnPresent(false);
                            break;
                        case "Turtwig":
                            loadedMyGameMaster.south.setWildPkmnPresent(false);
                            break;
                        case "Froakie":
                            loadedMyGameMaster.east.setWildPkmnPresent(false);
                            break;
                        case "Pikachu":
                            loadedMyGameMaster.west.setWildPkmnPresent(false);
                            break;
                    }
                }
            }
            return loadedMyGameMaster;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //= = = TEST CLIENT = = =//
    public static void main(String[] args) throws IOException {
        Player myPlayer = new Player("Jasmine", "feminine", new Pokemon("Fuecoco"));
        ReadWriteFile myReadWriteFile = new ReadWriteFile();
        myPlayer = myReadWriteFile.risLoadPlayerData();
        System.out.println("Player name:" + myPlayer.getName());
        System.out.println("Player appearance:" + myPlayer.getAppearance());
        System.out.println();
        for (int i = 0; i < myPlayer.capturedPokemon.length; i++) {
            if (myPlayer.capturedPokemon[i] != null){
                System.out.println("Player pokemon species:" + myPlayer.capturedPokemon[i].getSpeciesName());
                System.out.println("Player pokemon nickname:" + myPlayer.capturedPokemon[i].getName());
                System.out.println("Player pokemon health:" + myPlayer.capturedPokemon[i].getHealth());
            }
        }
        System.out.println();
        GameMaster myGameMaster = new GameMaster();
        myGameMaster = myReadWriteFile.risLoadGameMasterData();
        System.out.println("Is there a wild pokemon (Fuecoco) at GM's north location: " + myGameMaster.north.isWildPkmnPresent());
        System.out.println("Is there a wild pokemon (Turtwig) at GM's south location: " + myGameMaster.south.isWildPkmnPresent());
        System.out.println("Is there a wild pokemon (Froakie) at GM's east location: " + myGameMaster.east.isWildPkmnPresent());
        System.out.println("Is there a wild pokemon (Pikachu) at GM's west location: " + myGameMaster.west.isWildPkmnPresent());
    }
}

