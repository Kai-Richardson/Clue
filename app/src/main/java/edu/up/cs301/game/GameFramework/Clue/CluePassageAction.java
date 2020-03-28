package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class CluePassageAction extends GameAction {

    private Room room;
    public CluePassageAction(GamePlayer pl, Room rm){
        super(pl);
    }
    public Room getRoom(){
        return room;
    }
}


