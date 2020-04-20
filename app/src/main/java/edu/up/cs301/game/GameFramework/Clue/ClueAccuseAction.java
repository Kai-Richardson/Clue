package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueAccuseAction extends GameAction
{

    private String weapon;
    private String room;
    private String person;

    public ClueAccuseAction(GamePlayer pl, String weapon, String room, String person){
        super(pl);
        this.weapon = weapon;
        this.room = room;
        this.person = person;
    }

    public String getWeapon()
    {
        return weapon;
    }

    public String getRoom()
    {
        return room;
    }

    public String getPerson()
    {
        return person;
    }
}
