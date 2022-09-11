import java.util.Random;

/**
 * Controls game logic
 * @author Rianna McIntyre and Jasmine Robbins
 */
public class GameMaster {
    private boolean gameWon = false;
    private boolean gameLost = false;
    private int battleTurn = 1;
    private int battleDamage;
    private Pokemon currentEnemyPokemon = new Pokemon("Fuecoco");

    public Pokemon getCurrentEnemyPokemon() {
        return currentEnemyPokemon;
    }

    public void setCurrentEnemyPokemon(Pokemon newEnemyPokemon) {
        this.currentEnemyPokemon = newEnemyPokemon;
    }

    public boolean isGameWon(Player player){
        if(player.getCapturedPkmnNum() == 4){gameWon = true;}
        return gameWon;
    }

    public boolean isGameLost(Player player){
        if(player.getCurrentBattlePokemon().getHealth() <= 0){gameLost = true;}
        return gameLost;
    }

    /**
     * from:
     * https://mkyong.com/java/java-generate-random-integers-in-a-range/
     * @return randomly chosen index number for the wild pokemon's attack
     */
    public int chooseWildAttack(){
        Random random = new Random();
        int randomNumber = random.nextInt((3 - 0) + 1) + 0;
        return randomNumber;}

    /**
     * @param targetType elemental type of the pokemon that's being attacked
     * @param moveType  elemental type of the attackers pokemon move
     * @return damage to be applied to the target pokemon
     */
    public int calculateDamage(Type targetType, Type moveType){
        int damage = 20;
        switch (targetType){
            case FIRE:
                if(moveType == Type.GROUND ||
                   moveType == Type.WATER ||
                   moveType == Type.ROCK)
                {damage = 40;}

                else if(moveType == Type.BUG ||
                    moveType == Type.FAIRY ||
                    moveType == Type.FIRE ||
                    moveType == Type.GRASS ||
                    moveType == Type.ICE ||
                    moveType == Type.STEEL)
                {damage = 10;}
                break;

            case WATER:
                if(moveType == Type.ELECTRIC ||
                   moveType == Type.GRASS)
                {damage = 40;}

                else if(moveType == Type.FIRE ||
                    moveType == Type.ICE ||
                    moveType == Type.STEEL ||
                    moveType == Type.WATER)
                {damage = 10;}
                break;

            case GRASS:
                if(moveType == Type.BUG ||
                   moveType == Type.FIRE ||
                   moveType == Type.FLYING ||
                   moveType == Type.ICE ||
                   moveType == Type.POISON)
                {damage = 40;}

                else if(moveType == Type.ELECTRIC ||
                    moveType == Type.GRASS ||
                    moveType == Type.GROUND ||
                    moveType == Type.WATER)
                {damage = 10;}
                break;

            case ELECTRIC:
                if(moveType == Type.GROUND) {damage = 40;}

                else if(moveType == Type.ELECTRIC ||
                    moveType == Type.FLYING ||
                    moveType == Type.STEEL)
                {damage = 10;}
                break;
        }
    return damage;
    }

}
