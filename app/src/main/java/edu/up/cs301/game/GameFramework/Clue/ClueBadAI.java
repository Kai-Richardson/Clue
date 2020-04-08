package edu.up.cs301.game.GameFramework.Clue;

import android.util.Log;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.NotYourTurnInfo;

public class ClueBadAI extends GameComputerPlayer {

    private ClueGameState gs;

    public ClueBadAI(String name) {
        super(name);
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
        if(gs.getGameStage() == 1)
        {
            boolean canMove = true;
            //keep looping until moves are up
            while(canMove)
            {
                int movesLeft = gs.getMovesLeft();
                if(movesLeft == 0)
                {
                    canMove = false;
                }
                else
                    {
                    //randomly choose a direction
                    Random r = new Random();
                    int direction = r.nextInt(4);
                    game.sendAction(new ClueMoveAction(this, direction));
                }
            }

        }
    }
}
