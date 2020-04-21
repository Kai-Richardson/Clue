package edu.up.cs301.game.GameFramework.Clue;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;

public class ClueBadAI extends GameComputerPlayer {

    private ClueGameState gs;
    private int turnCount;
    private ArrayList<String> weaponChoices = new ArrayList<String>();
    private ArrayList<String> personChoices = new ArrayList<String>();
    private ArrayList<String> roomChoices = new ArrayList<String>();

    public ClueBadAI(String name)
    {
        super(name);
        turnCount = 0;
        weaponChoices.add("wrench");
        weaponChoices.add("candlestick");
        weaponChoices.add("pipe");
        weaponChoices.add("rope");
        weaponChoices.add("gun");
        weaponChoices.add("knife");
        roomChoices.add("yard");
        roomChoices.add("conservatory");
        roomChoices.add("lounge");
        roomChoices.add("kitchen");
        roomChoices.add("courtyard");
        roomChoices.add("pool");
        roomChoices.add("ballroom");
        roomChoices.add("dining");
        roomChoices.add("library");
        personChoices.add("scarlet");
        personChoices.add("plum");
        personChoices.add("mustard");
        personChoices.add("green");
        personChoices.add("white");
        personChoices.add("peacock");
    }

    protected void receiveInfo(GameInfo info)
    {
        if(!(info instanceof ClueGameState) || info instanceof NotYourTurnInfo)
        {
            return;
        }

        gs = (ClueGameState)info;


        //roll action
        if(gs.getGameStage() == 0)
        {
            Log.d("ROLL", "Sending roll action");
            game.sendAction(new ClueRollAction(this));
        }

        //move phase
        else if(gs.getGameStage() == 1)
        {
            //randomly choose a direction
            Random r = new Random();
            int direction = r.nextInt(4);
            game.sendAction(new ClueMoveAction(this, direction));
        }

        //accuse / suggest phase
        else if(gs.getGameStage() == 2)
        {
            TileData td = gs.getTileDataAtCoord(gs.getPlayerX(playerNum), gs.getPlayerY(playerNum));
            if(turnCount == 10)
            {
                Random r = new Random();
                int wc = r.nextInt(6);
                int pc = r.nextInt(6);
                int rc = r.nextInt(9);
                game.sendAction(new ClueAccuseAction(this, weaponChoices.get(wc), roomChoices.get(rc), personChoices.get(pc)));
            }
            else if(td.getRoom().getName() != null)
            {
                Random r = new Random();
                int wc = r.nextInt(6);
                int pc = r.nextInt(6);
                game.sendAction(new ClueSuggestAction(this, weaponChoices.get(wc), td.getRoom().getName(), personChoices.get(pc)));
            }
            else
            {
                game.sendAction(new ClueEndTurnAction(this));
            }
        }
        //disproving
        else if(gs.getGameStage() == 3)
        {
            Card[] hand = gs.getHand(playerNum);
            ArrayList<String> possibleCards = new ArrayList<String>();
            int count = 0;
            for(int i = 0; i < gs.getHandSize(); i++)
            {
                String cn = hand[i].getName();
                //compare to suggested cards, if they are equal, then add them to an arraylist
                if(cn.equals(gs.getSugPerson()))
                {
                    count++;
                    possibleCards.add(cn);
                }
                if(cn.equals(gs.getSugWeapon()))
                {
                    count++;
                    possibleCards.add(cn);
                }
                if(cn.equals(gs.getSugRoom()))
                {
                    count++;
                    possibleCards.add(cn);
                }
            }
            //choose one of the cards at random
            Random r = new Random();
            int chosenCard = r.nextInt(count);
            String cardName = possibleCards.get(chosenCard);
            game.sendAction(new ClueDisproveAction(this, cardName));
        }
        else
        {
            game.sendAction(new ClueEndTurnAction(this));
        }
    }

    @Override
    protected void timerTicked()
    {

    }
}
