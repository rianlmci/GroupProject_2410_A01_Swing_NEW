import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
    private JButton catchNorthPokemonBtn;
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
    private JLabel originScreenPaddingTop;
    private JPanel originScreenCenter;
    private JFormattedTextField originScreenFormattedStatsText;
    private JLabel originScreenStatsText;
    private JLabel originScreenTrainerAppearanceLabel;
    private JLabel originScreenTitleLabel;
    private JButton originToNorthBtn;
    private JButton originToSouthBtn;
    private JButton originToEastBtn;
    private JButton originToWestBtn;
    private JPanel originScreenDirectionsContainer;
    private JPanel originScreenCenterSouthContainer;
    private JPanel northScreenTEST;
    private JPanel northScreenTESTWest;
    private JLabel northDescriptionTESTLabel;
    private JPanel northScreenTestEast;
    private JButton northTESTToOrigin;
    private JButton returnToOriginN;
    private JButton returnToOriginS;
    private JButton returnToOriginE;
    private JButton returnToOriginW;
    private JLabel addToPartyLabel;
    private JTextField nameCaughtPokemon;
    private JButton addPokemonToParty;
    private JLabel caughtAll;
    private JLabel gameWon;
    private JRadioButton radioBattlePoke1;
    private JLabel battleFroakieLabel;
    private JLabel playerData;
    private JLabel gameOver;
    private JLabel gameOverLabel;
    private JRadioButton fuecocoBattleBtn;
    private JRadioButton pikachuBattleBtn;
    private JRadioButton turtwigBattleBtn;
    private JLabel battleFuecocoLabel;
    private JLabel battlePikachuLabel;
    private JLabel battleTurtwigLabel;
    private JLabel battlePokemonLabel;
    private JRadioButton froakieBattleBtn;
    private JLabel gameOverMessage;
    private JLabel battleScreenPaddingTop;
    private JLabel battleScreenPaddingBottom;
    private JLabel battleScreenPaddingLeft;
    private JLabel battleScreenPaddingRight;
    private JPanel battleScreenCenter;
    private JLabel battlePlayersStatsLabel;
    private JLabel battleEnemiesStatsLabel;
    private JLabel battleUpdateLabel;
    private JLabel battlePlayersPokemonLabel;
    private JLabel battleEnemiesPokemonLabel;
    private JButton battlePlayersMove0Btn;
    private JButton battlePlayersMove1Btn;
    private JButton battlePlayersMove2Btn;
    private JButton battlePlayersMove3Btn;
    private JTextField nicknameField;
    private JLabel addPkmnToPartyLabel;
    private JButton addPkmnToPartyBtn;
    private JButton goToBattle;
    private JLabel grandCanyonImage;
    private JButton catchItButton;
    private JLabel yosemiteLabel;
    private JButton catchItButton1;
    private JLabel denaliLabel;
    private JButton catchItButton2;
    private JLabel grandCanyonLabel;
    private CardLayout pkmnGameContainerDeck = (CardLayout)pokemonGameContainerPane.getLayout();

    //GAME PIECES
    private Player myPlayer = new Player("No Name", "feminine", new Pokemon("Fuecoco"));
    private GameMaster myGameMaster = new GameMaster();


    public gameContainer() {

        /**
         * @author Rianna McIntyre
         */
        startGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerData.setVisible(false);
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "playerSelect");
            }
        });
        /**
         * @author Rianna McIntyre
         * @author Jasmine
         */
        loadGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Loads player data from file
                ReadWriteFile test = new ReadWriteFile();
                try {
                    test.loadPlayerData();
                    test.loadGameMasterData();
                    // playerdata loadGame label. Read from file
                    playerData.setText(test.loadPlayerData());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                pkmnGameContainerDeck.show(pokemonGameContainerPane,"origin");
            }

        });


        /**
         * @author Rianna McIntyre
         */
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
        /**
         * @author Rianna McIntyre
         */
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

                originScreenTitleLabel.setText("<html><u><b>" + myPlayer.getName() + "'s Progress So Far...</b></u></html>");
                originScreenTrainerAppearanceLabel.setIcon(new ImageIcon(gameContainer.class.getResource(myPlayer.getAppearance())));
                originScreenStatsText.setText(myPlayer.getCapturedPkmnInfo());
                originToNorthBtn.setText(myGameMaster.north.getParkLocName());
                originToSouthBtn.setText(myGameMaster.south.getParkLocName());
                originToEastBtn.setText(myGameMaster.east.getParkLocName());
                originToWestBtn.setText(myGameMaster.west.getParkLocName());
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "origin");

                /**
                 * @author Jasmine
                 * Write player name to file
                 */
                ReadWriteFile gameFile = new ReadWriteFile();
                gameFile.risWrite(myPlayer);
            }
        });
        /**
         * @author Rianna McIntyre
         * @author Jasmine modified
         */
        originToNorthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.NORTH);
                myGameMaster.north.setWildPkmnPresent(false);
                myGameMaster.setCurrentEnemyPokemon(Location.NORTH);
                if(!myGameMaster.north.isWildPkmnPresent()){
                    northScreen.setVisible(false);
                }
                JLabel grandCanyonLabel = new JLabel();
                grandCanyonLabel.setText(myGameMaster.north.getDescription());
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "north");
            }
        });
        /**
         * @author Rianna McIntyre
         */
        originToSouthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.SOUTH);
                myGameMaster.south.setWildPkmnPresent(false);
                myGameMaster.setCurrentEnemyPokemon(Location.SOUTH);
                if(!myGameMaster.south.isWildPkmnPresent()){
                    southScreen.setVisible(false);
                }
                JLabel yosemiteLabel = new JLabel();
                yosemiteLabel.setText(myGameMaster.south.getDescription());
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "south");
            }
        });
        /**
         * @author Rianna McIntyre
         * @author Jasmine
         */
        originToEastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.EAST);
                myGameMaster.setCurrentEnemyPokemon(Location.EAST);
                if(!myGameMaster.east.isWildPkmnPresent()){
                    eastScreen.setVisible(false);
                }
                JLabel denaliLabel = new JLabel();
                denaliLabel.setText(myGameMaster.east.getDescription());
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "east");
            }
        });
        /**
         * @author Rianna McIntyre
         * @author Jasmine
         */
        originToWestBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.WEST);
                myGameMaster.setCurrentEnemyPokemon(Location.WEST);
                if(!myGameMaster.west.isWildPkmnPresent()){
                    westScreen.setVisible(false);
                }
                JLabel yellowstoneLabel = new JLabel();
                yellowstoneLabel.setText(myGameMaster.west.getDescription());
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "west");
            }
        });

        //TODO remove the method below when Jasmine makes her park locations:
        northTESTToOrigin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "origin");
            }
        });
        /**
         * @author Jasmine
         * Return to origin buttons for Cardinal Screens
         */
        returnToOriginN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.ORIGIN);
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "origin");
            }
        });
        returnToOriginS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.ORIGIN);
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "origin");
            }
        });
        returnToOriginE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.ORIGIN);
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "origin");
            }
        });
        returnToOriginW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPlayer.setPlayerLocation(Location.ORIGIN);
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "origin");
            }
        });
        // Radio Buttons for Battle Pokemon
        turtwigBattleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleFroakieLabel.setIcon(new ImageIcon("/images/Turtwig.png"));
            }
        });

        battlePlayersMove0Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBattleStatsAndLabels(0);
            }
        });
        battlePlayersMove1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBattleStatsAndLabels(1);
            }
        });
        battlePlayersMove2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBattleStatsAndLabels(2);
            }
        });
        battlePlayersMove3Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBattleStatsAndLabels(3);
            }
        });

        /**
         * @author Jasmine ******************************
         */
        addPkmnToPartyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParkLocation loc = new ParkLocation(myPlayer.getPlayerLocation());
                if(nicknameField.getText() != null){
                    myPlayer.addPkmntoPrty(loc.getWildPokemon());

                    pkmnGameContainerDeck.show(pokemonGameContainerPane, "originScreen");
                }
                if((myGameMaster.isGameWon(myPlayer)) == true){
                    pkmnGameContainerDeck.show(pokemonGameContainerPane, "gameWonScreen");
                }
            }
        });
        // Catch Pokemon on Current Screen
        catchNorthPokemonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUpCaughtPokemonScreen();
                pikachuBattleBtn.setEnabled(false);
                froakieBattleBtn.setEnabled(false);
                fuecocoBattleBtn.setEnabled(false);
                turtwigBattleBtn.setEnabled(false);
                if(checkCaughtPokemon("Pikachu")){
                    pikachuBattleBtn.setEnabled(true);
                }
                if(checkCaughtPokemon("Froakie")){
                    froakieBattleBtn.setEnabled(true);
                }
                if(checkCaughtPokemon("Fuecoco")){
                    fuecocoBattleBtn.setEnabled(true);
                }
                if(checkCaughtPokemon("Turtwig")){
                    turtwigBattleBtn.setEnabled(true);
                }

                pkmnGameContainerDeck.show(pokemonGameContainerPane, "chooseBattlePkmnScreen");
            }
        });
        goToBattle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUpBattleScreenLabels();
                setUpBattlePkmnFromRadio();
                pkmnGameContainerDeck.show(pokemonGameContainerPane, "battle");
            }
        });
    }
    public boolean checkCaughtPokemon(String pkmnToCheck){
        for(int i = 0; i < myPlayer.capturedPokemon.length; i++){
            if(myPlayer.capturedPokemon[i].getSpeciesName().equals(pkmnToCheck)){
                return true;
            }
        }
        return false;
    }

    /**
     * @author Rianna McIntyre
     * This is used in the battle screen.
     * It applies damage to the battling pokemon and adjusts their health accordingly.
     * also updates the battleUpdateLabel text if needed.
     * @param ourMoveChoice
     */
    public void updateBattleStatsAndLabels(int ourMoveChoice){
        int enemyChosenRandomMove = myGameMaster.chooseWildAttack();

        //Updates our pokemon's health.
        myPlayer.getCurrentBattlePokemon().setHealth(
                (myPlayer.getCurrentBattlePokemon().getHealth())
                        -
                        (myGameMaster.calculateDamage(myPlayer.getCurrentBattlePokemon().getType(),
                                myGameMaster.getCurrentEnemyPokemon().getMoveTypeAsType(enemyChosenRandomMove)))
        );

        //Updates enemy pokemon's health.
        myGameMaster.getCurrentEnemyPokemon().setHealth(
                (myGameMaster.getCurrentEnemyPokemon().getHealth())
                        -
                        (myGameMaster.calculateDamage(myGameMaster.getCurrentEnemyPokemon().getType(),
                                myPlayer.getCurrentBattlePokemon().getMoveTypeAsType(ourMoveChoice)))
        );

        //If player pokemon's health reaches less than or equal to zero by the point, they lose.
        if(myGameMaster.isGameLost(myPlayer)){
            pkmnGameContainerDeck.show(pokemonGameContainerPane, "gameOver");
        }

        //If enemy pokemon's health reaches less than or equal to zero by this point, move to catching screen.
        else if(myGameMaster.getCurrentEnemyPokemon().getHealth() <= 0){
            setUpCaughtPokemonScreen();
            pkmnGameContainerDeck.show(pokemonGameContainerPane, "addPokemon");
        }

        //Else, we update all the labels.
        else {
            String battleText = new String("<html><center><p>"
                    + myPlayer.getCurrentBattlePokemon().getSpeciesName() + "'s chosen attack was "
                    + myPlayer.getCurrentBattlePokemon().getMoveName(ourMoveChoice)
                    + " and it did "
                    + myGameMaster.calculateDamage(
                    myGameMaster.getCurrentEnemyPokemon().getType(),
                    myPlayer.getCurrentBattlePokemon().getMoveTypeAsType(ourMoveChoice))
                    + " damage to the " + myGameMaster.getCurrentEnemyPokemon().getTypeAsString() + " type "
                    + myGameMaster.getCurrentEnemyPokemon().getName() + "!"
                    + "</p><p>"
                    + myGameMaster.getCurrentEnemyPokemon().getSpeciesName() + "'s chosen attack was "
                    + myGameMaster.getCurrentEnemyPokemon().getMoveName(enemyChosenRandomMove)
                    + " and it did "
                    + myGameMaster.calculateDamage(
                    myPlayer.getCurrentBattlePokemon().getType(),
                    myGameMaster.getCurrentEnemyPokemon().getMoveTypeAsType(enemyChosenRandomMove))
                    + " damage to the " + myPlayer.getCurrentBattlePokemon().getTypeAsString() + " type "
                    + myPlayer.getCurrentBattlePokemon().getName() + "!"
                    + "</p></center></html>"
            );

            String playerStatsText = new String(
                    "<html><center><b><u>" + myPlayer.getCurrentBattlePokemon().getName()  + "</b></u>"
                            + "<p><b>Health: </b>" + myPlayer.getCurrentBattlePokemon().getHealth() + "</p>"
                            + "</center></html>"
            );
            String enemyStatsText= new String(
                    "<html><center><b><u>" + myGameMaster.getCurrentEnemyPokemon().getName()  + "</b></u>"
                            + "<p><b>Health: </b>" + myGameMaster.getCurrentEnemyPokemon().getHealth() + "</p>"
                            + "</center></html>"
            );

            battleUpdateLabel.setText(battleText);
            battlePlayersStatsLabel.setText(playerStatsText);
            battleEnemiesStatsLabel.setText(enemyStatsText);
        }
    }

    /**
     * @author Rianna McIntyre
     * Sets up battle screen labels for the start of the battle.
     */
    public void setUpBattleScreenLabels(){
        myGameMaster.setCurrentEnemyPokemon(myPlayer.getPlayerLocation());
        battleUpdateLabel.setText("The battle begins!");
        String playerStatsText = new String(
                "<html><center><b><u>" + myPlayer.getCurrentBattlePokemon().getName()  + "</b></u>"
                        + "<p><b>Health: </b>" + myPlayer.getCurrentBattlePokemon().getHealth() + "</p>"
                        + "</center></html>"
        );
        String enemyStatsText= new String(
                "<html><center><b><u>" + myGameMaster.getCurrentEnemyPokemon().getName()  + "</b></u>"
                        + "<p><b>Health: </b>" + myGameMaster.getCurrentEnemyPokemon().getHealth() + "</p>"
                        + "</center></html>"
        );
        battlePlayersPokemonLabel.setIcon(new ImageIcon(gameContainer.class.getResource(
                myPlayer.getCurrentBattlePokemon().getAppearance())));
        battlePlayersStatsLabel.setText(playerStatsText);
        battleEnemiesPokemonLabel.setIcon(new ImageIcon(gameContainer.class.getResource(
                myGameMaster.getCurrentEnemyPokemon().getAppearance())));
        battleEnemiesStatsLabel.setText(enemyStatsText);
        battlePlayersMove0Btn.setText(myPlayer.getCurrentBattlePokemon().getMoveName(0));
        battlePlayersMove1Btn.setText(myPlayer.getCurrentBattlePokemon().getMoveName(1));
        battlePlayersMove2Btn.setText(myPlayer.getCurrentBattlePokemon().getMoveName(2));
        battlePlayersMove3Btn.setText(myPlayer.getCurrentBattlePokemon().getMoveName(3));
    }

    /**
     * @author Rianna McIntyre
     * Sets up current battle pokemon based on radio button selections
     * on chooseBattlePkmnScreen.
     */
    public void setUpBattlePkmnFromRadio(){
        //TODO fix labels in this if label names change
        if (froakieBattleBtn.isSelected()){myPlayer.setCurrentBattlePokemon(0);}
        else if (fuecocoBattleBtn.isSelected()){myPlayer.setCurrentBattlePokemon(1);}
        else if (pikachuBattleBtn.isSelected()){myPlayer.setCurrentBattlePokemon(2);}
        else if (turtwigBattleBtn.isSelected()){myPlayer.setCurrentBattlePokemon(3);}
        else {throw new IllegalArgumentException("Selection is not valid. Check your label names in"
                + "chooseBattlePkmnScreen AND setUpBattlePkmnFromRadio()"
                + "and make sure they match."
        );}
    }
    /**
     * @author Rianna McIntyre
     * Sets up add caught pokemon screen labels appropriately based on what the player fought.
     */
    public void setUpCaughtPokemonScreen(){
        //TODO replace with actual image label name that Jasmine chooses, remove declared version in this method.
        JLabel addPkmnToPartyImageLabel = new JLabel();
        addPkmnToPartyImageLabel.setIcon(new ImageIcon(gameContainer.class.getResource(
                myGameMaster.getCurrentEnemyPokemon().getAppearance())));
        switch (myPlayer.getPlayerLocation()){
            case NORTH:
                myGameMaster.north.setWildPkmnPresent(false);
                break;
            case SOUTH:
                myGameMaster.south.setWildPkmnPresent(false);
                break;
            case EAST:
                myGameMaster.east.setWildPkmnPresent(false);
                break;
            case WEST:
                myGameMaster.west.setWildPkmnPresent(false);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        //from: https://www.anycodings.com/1questions/597382/why-is-my-image-icon-not-showing-up-in-my-jframe
        InputStream stream = gameContainer.class.getResourceAsStream("/images/newPokeballIcon.png");
        ImageIcon icon = new ImageIcon(ImageIO.read(stream));
        JFrame frame = new JFrame("2410 Group Project A01: Pokemon");
        frame.setIconImage(icon.getImage());
        frame.setContentPane(new gameContainer().pokemonGameContainerPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}


