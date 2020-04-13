package edu.up.cs301.game.GameFramework.Clue;

import android.util.Log;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueRollAction extends GameAction
{
    private int die1;
    private int die2;
    private int rollTotal;


    public ClueRollAction(GamePlayer pl)
    {
        super(pl);
        Random random = new Random();
        die1 = random.nextInt(5)+1;
        die2 = random.nextInt(5)+1;
        rollTotal = die1 + die2;
        Log.d("Inside roll action", "Roll Total is " + rollTotal);
    }

    public int getResult()
    {
        return rollTotal;
    }
}
