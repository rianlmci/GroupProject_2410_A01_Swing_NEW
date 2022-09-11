import java.io.*;
/*
 * @author Jasmine
 */
public class ReadWriteFile {
    String filename = "pokemonPlayers.txt";
    Player playerName = new Player();

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

}