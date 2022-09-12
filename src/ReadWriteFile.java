import java.io.*;
/*
 * @author Jasmine Robbins
 */
public class ReadWriteFile {
    String filename = "pokemonPlayers.txt";
    Player myPlayer = new Player("Jasmine", "feminine", new Pokemon("Fuecoco"));

    public void write(String name) {
        File file = new File(filename);
        boolean append = false;
        try{
            BufferedWriter bw = null;
            if(file.exists())
            {
                append = true;
                bw = new BufferedWriter(new FileWriter(new File(filename), append));
            }
            else{
                append = false;
                System.out.println("Error with File");
            }
            bw.write(name);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the players information to a text file.
     * @author original by Jasmine, modified by Rianna
     * @param myPlayer player info we are saving
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
                    newCSV.append(myPlayer.getCapturedPokemon()[i].getName() + ","
                            + myPlayer.getCapturedPokemon()[i].getSpeciesName() + ",");
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

    /*  Create File
    public static void main(String[] args) {
        try {
            File file = new File("pokemonPlayers.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        */

    //= = = TEST CLIENT = = =//
    public static void main(String[] args) {
        Player myPlayer = new Player("Jasmine", "feminine", new Pokemon("Fuecoco"));
        myPlayer.getCapturedPokemon()[0].setName("Toopy");
        myPlayer.addPkmntoPrty(new Pokemon("Pikachu"));
        myPlayer.getCapturedPokemon()[1].setName("Pika");
        ReadWriteFile myReadWriteFile = new ReadWriteFile();
        myReadWriteFile.risWrite(myPlayer);
    }
}