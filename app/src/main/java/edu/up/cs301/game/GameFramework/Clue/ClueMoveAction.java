package edu.up.cs301.game.GameFramework.Clue;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueMoveAction extends GameAction
{
    private int direction;
    public ClueMoveAction(GamePlayer pl, int direction)
    {
        super(pl);
    }

    public int getDirection(){
        return direction;
    }
}




