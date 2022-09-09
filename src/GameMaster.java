/**
 * Controls game logic
 * @author Rianna McIntyre and Jasmine Robbins
 */
public class GameMaster {
    private boolean gameWon = false;
    private boolean gameLost = false;
    private int battleTurn = 1;
    private int battleDamage;

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
     * https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
     * @return randomly chosen index number for the wild pokemon's attack
     */
    public int chooseWildAttack(){
        return 1 + (int)(Math.random() * ((4 - 1) + 1));}

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
