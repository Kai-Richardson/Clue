package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueDisproveAction extends GameAction
{
    String name;

    public ClueDisproveAction(GamePlayer pl, String cardName)
    {
        super(pl);
        name = cardName;
    }

    public String getName()
    {
        return name;
    }
}
