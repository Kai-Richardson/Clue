package edu.up.cs301.game.GameFramework.Clue;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueMoveAction extends GameAction
{
    private int direction;

    //0 is up, 1 is right, 2 is down, 3 is left
    public ClueMoveAction(GamePlayer pl, int direction)
    {
        super(pl);
        this.direction = direction;
    }

    public int getDirection(){
        return direction;
    }
}




