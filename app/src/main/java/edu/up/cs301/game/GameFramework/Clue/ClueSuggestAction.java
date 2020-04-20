package edu.up.cs301.game.GameFramework.Clue;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class ClueSuggestAction extends GameAction
{
    public String weapon;
    public String room;
    public String person;

    public ClueSuggestAction(GamePlayer pl, String weapon, String room, String person)
    {
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
