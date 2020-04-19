package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueAccuseAction extends GameAction{
    public String weapon;
    public String room;
    public String person;
    public ClueAccuseAction(GamePlayer pl){
        super(pl);

    }
}
