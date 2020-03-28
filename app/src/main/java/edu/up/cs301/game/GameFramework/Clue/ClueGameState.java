package edu.up.cs301.game.GameFramework.Clue;

import android.widget.ProgressBar;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class ClueGameState extends GameState
{

    //private gameStage;
    private int[] rollResult;
    private TileData[][] board;
    private Card[] suggestedCards;
    private int moves;
    //maybe have a variable for all cards dealt, and it is accessed using player ID int
    //if any variables are added here, make sure to assign them in the two constuctors


    //some stuff for interface
    private static final long serialVersionUID = 7737393762469851826L;

    public ClueGameState()
    {
        //empty constructor, this will assign the board and choose cards for players
    }

    public ClueGameState(ClueGameState or) {
        rollResult = or.rollResult;
        suggestedCards = or.suggestedCards;
        board = or.board;
        //if other variables are added, they need to be added here too
    }


    //public Player getWhoseTurn()
    //{

    //}

    public int getMovesLeft()
    {
        return moves;
    }

    public void setRollResult(int[] roll)
    {
        this.rollResult = roll;
        moves = rollResult[0] + rollResult[1];
    }
}
