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
    private int whoseMove;
    //maybe have a variable for all cards dealt, and it is accessed using player ID int
    //if any variables are added here, make sure to assign them in the two constuctors


    //some stuff for interface
    private static final long serialVersionUID = 7737393762469851826L;

    public ClueGameState()
    {
        /*
        //walls with no rooms
        board[][] = new TileData("wall", true);
        //board center TileData
        board[][] = new TileData("wall", true);
        //study TileData
        board[][] = new TileData("study", false);
        //hall TileData
        board[][] = new TileData("hall", false);
        //lounge TitleData
        board[][] = new TileData("lounge", false);
        //dining room TileData
        board[][] = new TileData("dining", false);
        //kitchen TileData
        board[][] = new TileData("kitchen", false);
        //ballroom TitleData
        board[][] = new TileData("ballroom", false);
        //conservatory TileData
        board[][] = new TileData("conservatory", false);
        //billard TileData
        board[][] = new TileData("billard", false);
        //library TileData
        board[][] = new TileData("library", false);
        */

        //empty constructor, this will assign the board and choose cards for players
    }

    public ClueGameState(ClueGameState or) {
        rollResult = or.rollResult;
        suggestedCards = or.suggestedCards;
        board = or.board;
        //if other variables are added, they need to be added here too
    }


    public int getWhoseTurn()
    {
        return whoseMove;
    }

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
