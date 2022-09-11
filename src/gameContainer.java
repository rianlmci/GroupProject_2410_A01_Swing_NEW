import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameContainer {
    private JPanel pokemonGameContainerPane;
    private JPanel startScreen;
    private JPanel startScreenPaddingTop;
    private JLabel startScreenPaddingLeft;
    private JLabel startScreenPaddingRight;
    private JLabel startScreenPaddingBottom;
    private JPanel startScreenCenter;
    private JPanel startScreenButtonContainer;
    private JButton startGameBtn;
    private JButton loadGameBtn;
    private JPanel playerSelectScreen;
    private JPanel playerSelectCenter;
    private JRadioButton playerSelectFemBtn;
    private JRadioButton playerSelectMascBtn;
    private JButton createTrainerBtn;
    private JPanel playerSelectNameSpace;
    private JTextArea playerSelectNameInput;
    private JLabel playerSelectPaddingRight;
    private JLabel playerSelectPaddingBottom;
    private JLabel playerSelectPaddingLeft;
    private JPanel pokemonSelectScreen;
    private JPanel pokemonSelectScreenPaddingTop;
    private JLabel pokemonSelectPlayerWelcomeLabel;
    private JLabel pokemonSelectScreenPaddingRight;
    private JLabel pokemonSelectScreenPaddingLeft;
    private JLabel pokemonSelectScreenPaddingBottom;
    private JPanel lowerButtonContainer;
    private JPanel pokemonSelectPokemonContainer;
    private JPanel originScreen;
    private JPanel northScreen;
    private JPanel southScreen;
    private JPanel eastScreen;
    private JPanel westScreen;
    private JPanel addCaughtPkmnScreen;
    private JPanel chooseBattlePkmnScreen;
    private JPanel battleScreen;
    private JPanel gameOverScreen;
    private JPanel gameWonScreen;
    private JRadioButton selectStarterFuecocoBtn;
    private JRadioButton selectStarterFroakieBtn;
    private JRadioButton selectStarterPikachuBtn;
    private JRadioButton selectStarterTurtwigBtn;
    private JButton pokemonSelectToOriginBtn;
    private JTextArea pokemonSelectNameInput;
    private JLabel originScreenPaddingLeft;
    private JLabel originScreenPaddingRight;
    private JLabel originScreenPaddingBottom;
    private JLabel originScreenPaddingTop;
    private JPanel originScreenCenter;
    private JFormattedTextField originScreenFormattedStatsText;
    private JLabel originScreenStatsText;
    private JLabel originScreenTrainerAppearanceLabel;
    private JLabel originScreenTitleLabel;
    private JLabel origin;
    //private JLabel originScreenStatsText;
    private CardLayout pkmnGameContainerDeck = (CardLayout)pokemonGameContainerPane.getLayout();
    private Player myPlayer = new Player("No Name", "feminine", new Pokemon("Fuecoco"));
    private GameMaster myGameMaster = new GameMaster();

    //GAME PIECES
    //This causes a crash when it is called, probably because it's not fully implemented. also I move this from game master for testing.
    /*
    private ParkLocation north = new ParkLocation(Location.NORTH);
    private ParkLocation south = new ParkLocation(Location.SOUTH);
    private ParkLocation east = new ParkLocation(Location.EAST);
    private ParkLocation west = new ParkLocation(Location.WEST);
    private ParkLocation origin = new ParkLocation(Location.ORIGIN);
     */

    public gameContainer() {
        startGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "playerSelect");
            }
        });

        loadGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        createTrainerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!playerSelectNameInput.getText().isEmpty()){myPlayer.setName(playerSelectNameInput.getText());}

                if (playerSelectMascBtn.isSelected()){
                    myPlayer.setAppearance("masculine");
                }
                pokemonSelectPlayerWelcomeLabel.setText("Welcome " + myPlayer.getName() + "!");
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "pokemonSelect");
            }
        });
        pokemonSelectToOriginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(selectStarterFuecocoBtn.isSelected()){
                    myPlayer.chooseStarterPokemon(new Pokemon("Fuecoco"));
                }
                else if(selectStarterTurtwigBtn.isSelected()){
                    myPlayer.chooseStarterPokemon(new Pokemon("Turtwig"));
                }

                else if(selectStarterFroakieBtn.isSelected()){
                    myPlayer.chooseStarterPokemon(new Pokemon("Froakie"));
                }

                else if(selectStarterPikachuBtn.isSelected()){
                    myPlayer.chooseStarterPokemon(new Pokemon("Pikachu"));
                }

                if(!pokemonSelectNameInput.getText().isEmpty()){
                    myPlayer.capturedPokemon[0].setName(pokemonSelectNameInput.getText());
                }

                else{
                    myPlayer.capturedPokemon[0].setName(myPlayer.capturedPokemon[0].getSpeciesName());
                }
                //saveGame(); //TODO
                originScreenStatsText.setText(myPlayer.getCapturedPkmnInfo());
                originScreenTitleLabel.setText(myPlayer.getName() + "'s Progress So Far...");
                originScreenTrainerAppearanceLabel.setIcon(new ImageIcon(gameContainer.class.getResource(myPlayer.getAppearance())));
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "origin");
            }
        });
    }

    /**
     * This is used in the battle screen.
     * It applies damage to the battling pokemon and adjusts their health accordingly.
     * also updates the battleUpdateLabel text if needed.
     * @param ourMoveChoice
     */
    public void updateBattleStatsAndLabels(int ourMoveChoice){
        int enemyChosenRandomMove = myGameMaster.chooseWildAttack();

        //Updates our pokemon's health.
        myPlayer.getCurrentBattlePokemon().setHealth(
                myGameMaster.calculateDamage(myPlayer.getCurrentBattlePokemon().getType(),
                myGameMaster.getCurrentEnemyPokemon().getMoveTypeAsType(enemyChosenRandomMove))
        );

        //Updates enemy pokemon's health.
        myGameMaster.getCurrentEnemyPokemon().setHealth(
                myGameMaster.calculateDamage(myGameMaster.getCurrentEnemyPokemon().getType(),
                myPlayer.getCurrentBattlePokemon().getMoveTypeAsType(ourMoveChoice))
        );

        //If player pokemon's health reaches less than or equal to zero by the point, they lose.
        if(myGameMaster.isGameLost(myPlayer)){
            pkmnGameContainerDeck.show(pokemonGameContainerPane, "gameOver");
        }

        //If enemy pokemon's health reaches less than or equal to zero by this point, move to catching screen.
        else if(myGameMaster.getCurrentEnemyPokemon().getHealth() <= 0){
            pkmnGameContainerDeck.show(pokemonGameContainerPane, "addPokemon");
        }

        //Else, we update all the labels.
        else {
            JLabel battleUpdateLabel = new JLabel();
            JLabel playersStatsLabel = new JLabel();
            JLabel enemiesStatsLabel = new JLabel();
            String battleText = new String("<html><center><p>"
                    + myPlayer.getCurrentBattlePokemon().getSpeciesName() + "'s chosen attack was "
                    + myPlayer.getCurrentBattlePokemon().getMoveName(ourMoveChoice)
                    + " and it did "
                    + myGameMaster.calculateDamage(
                    myGameMaster.getCurrentEnemyPokemon().getType(),
                    myPlayer.getCurrentBattlePokemon().getMoveTypeAsType(ourMoveChoice)
            )
                    + " damage to the " + myGameMaster.getCurrentEnemyPokemon().getTypeAsString() + " type "
                    + myGameMaster.getCurrentEnemyPokemon().getName() + "!"
                    + "</p><p>"
                    + myGameMaster.getCurrentEnemyPokemon().getSpeciesName() + "'s chosen attack was "
                    + myGameMaster.getCurrentEnemyPokemon().getMoveName(enemyChosenRandomMove)
                    + " and it did "
                    + myGameMaster.calculateDamage(
                    myPlayer.getCurrentBattlePokemon().getType(),
                    myGameMaster.getCurrentEnemyPokemon().getMoveTypeAsType(enemyChosenRandomMove)
            )
                    + " damage to the " + myPlayer.getCurrentBattlePokemon().getTypeAsString() + " type "
                    + myPlayer.getCurrentBattlePokemon().getName() + "!"
                    + "</p></center></html>"
            );

            String playerStatsText = new String(
                    "<html><b><u>" + myPlayer.getCurrentBattlePokemon().getName()  + "</b></u>"
                    + "<p><b>Health: </b>" + myPlayer.getCurrentBattlePokemon().getHealth() + "</p>"
                    + "</html>"
            );
            String enemyStatsText= new String(
                    "<html><b><u>" + myGameMaster.getCurrentEnemyPokemon().getName()  + "</b></u>"
                    + "<p><b>Health: </b>" + myGameMaster.getCurrentEnemyPokemon().getHealth() + "</p>"
                    + "</html>"
            );

            battleUpdateLabel.setText(battleText);
            playersStatsLabel.setText(playerStatsText);
            enemiesStatsLabel.setText(enemyStatsText);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2410 Group Project A01: Pokemon");
        frame.setContentPane(new gameContainer().pokemonGameContainerPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}


