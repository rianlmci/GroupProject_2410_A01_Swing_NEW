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
    private JLabel pokemonSelectScreenPaddingSouth;
    private JPanel buttonContainer;
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
    private CardLayout pkmnGameContainerDeck = (CardLayout)pokemonGameContainerPane.getLayout();
    private Player myPlayer = new Player("No Name", "feminine", new Pokemon("Fuecoco"));


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
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("2410 Group Project A01: Pokemon");
        frame.setContentPane(new gameContainer().pokemonGameContainerPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


