package edu.up.cs301.game.GameFramework.Clue;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueRollAction extends GameAction
{
    private int[] dice;
    private int rollResult;


    public ClueRollAction(GamePlayer pl)
    {
        super(pl);
        Random random = new Random();
        dice = new int[2];
        dice[0] = random.nextInt(5)+1;
        dice[1] = random.nextInt(5)+1;
        rollResult = dice[0] + dice[1];
    }

    public int getRollResult()
    {
        return rollResult;
    }
}
